package org.bongiorno.aspects.latency.esper.listeners;

import com.espertech.esper.client.EPAdministrator;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author cbongiorno
 */
public class AlertOnErrorListener extends AbstractErrorListener {

//    @Autowired
//    private MessageService messageService;

    public AlertOnErrorListener(EPAdministrator epAdmin, Class<? extends Throwable> errorType) {
        super(epAdmin, errorType);
    }

    @Override
    protected void notify(String subject, String details) {
//        messageService.sendSysMail(new SimpleEventMessage(subject, details));
    }
}
