package org.bongiorno.aspects.latency.listeners;

public class ProfileSysOutListener implements LatencyListener {


    @Override
    public void perform(Class type, String methodName, Object[] args, long duration, Throwable error) {
        System.out.format("%s.%s,%d,%s\n", type.getSimpleName(), methodName, duration, (error == null ? "" : error.getClass().getSimpleName()));
    }
}
