package org.bongiorno.aspects.latency.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfileLoggingListener implements LatencyListener {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void perform(Class type, String methodName, Object[] args, long duration, Throwable error) {
        logger.trace("{}.{},{},{}", new Object[]{type.getSimpleName(), methodName, duration, (error == null ? "" : error.getClass().getSimpleName())});
    }

    public void setLoggerName(String name) {
        logger = LoggerFactory.getLogger(name);
    }
}
