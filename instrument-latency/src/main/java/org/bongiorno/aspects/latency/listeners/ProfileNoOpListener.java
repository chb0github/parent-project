package org.bongiorno.aspects.latency.listeners;

public class ProfileNoOpListener implements LatencyListener {


    @Override
    public void perform(Class type, String methodName, Object[] args, long duration, Throwable error) {

    }
}
