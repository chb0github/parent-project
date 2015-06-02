package org.bongiorno.aspects.latency.listeners;


public interface LatencyListener {

    public void perform(Class type, String methodName, Object[] args, long duration, Throwable error);

}
