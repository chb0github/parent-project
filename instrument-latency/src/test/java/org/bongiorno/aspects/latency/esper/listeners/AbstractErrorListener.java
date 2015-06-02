package org.bongiorno.aspects.latency.esper.listeners;

import com.espertech.esper.client.*;
import org.bongiorno.aspects.latency.esper.MethodCalledEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;


public abstract class AbstractErrorListener implements UpdateListener {

    private static final Logger log = LoggerFactory.getLogger(AbstractErrorListener.class);


    public AbstractErrorListener(EPAdministrator epAdmin, Class<? extends Throwable> errorType){
        EPPreparedStatement preparedStatement = epAdmin.prepareEPL("select * from MethodCalledEvent where exception is not null and (?).isAssignableFrom(exception.getClass())");
        preparedStatement.setObject(1, errorType);
        EPStatement epStatement = epAdmin.create(preparedStatement);
        epStatement.addListener(this);
    }

    @Override
    public void update(EventBean[] newEvents, EventBean[] oldEvents) {
        if(newEvents != null){
            for (EventBean newEvent : newEvents) {
                MethodCalledEvent event = (MethodCalledEvent) newEvent.getUnderlying();
                Throwable exception = event.getException();
                String subject = String.format("%s in %s.%s on %s", exception.getClass().getSimpleName(), event.getTargetClass().getSimpleName(), event.getMethodName(), getMyHostname());

                StringWriter bodyStr = new StringWriter();
                PrintWriter bodyWriter = new PrintWriter(bodyStr);
                bodyWriter.println("Stack trace:");
                exception.printStackTrace(bodyWriter);

                notify(subject, bodyStr.toString());
            }

        }

    }
    // actually comes from package MISC
    public static String getMyHostname() {
        String hostName = null;
        try {
            hostName = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            log.error("Unknown *local* host?  Really?", e);
        }
        return hostName;
    }
    protected abstract void notify(String subject, String details);
}
