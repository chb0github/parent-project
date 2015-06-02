package org.bongiorno.aspects.latency;

import org.aspectj.lang.ProceedingJoinPoint;
import org.bongiorno.aspects.latency.listeners.LatencyListener;

public class LatencyAspect {

    private LatencyListener action;

    public LatencyAspect(LatencyListener action) {
        this.action = action;
    }

    public Object doAroundAdvice(ProceedingJoinPoint jp) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object retVal = null;
        Throwable error = null;
        try{
            retVal = jp.proceed();
        }catch (Throwable t){
            error = t;
        }

        Class withinType = jp.getSourceLocation().getWithinType();
        String methodName = jp.getSignature().getName();

        long endTime = System.currentTimeMillis();
        long runningTime = endTime - startTime;

        action.perform(withinType, methodName, jp.getArgs(), runningTime, error);

        if( error != null ){
            throw error;
        }

        return retVal;
    }
}
