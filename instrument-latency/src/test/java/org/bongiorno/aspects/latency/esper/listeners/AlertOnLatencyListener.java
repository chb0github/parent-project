package org.bongiorno.aspects.latency.esper.listeners;

/**
 * @author cbongiorno
 */
public class AlertOnLatencyListener extends AbstractLatencyListener {

//    @Autowired
//    private MessageService messageService;

    private long threshold;

    public AlertOnLatencyListener(long threshold) {
        this.threshold = threshold;
    }

    @Override
    protected void notify(Class clazz, String methodName, Number latency, int callCount, int windowSize) {
        if(callCount > 0 && latency.doubleValue() > threshold){
//            messageService.sendLatencyAlert(clazz,methodName,latency,callCount,windowSize);

        }
    }

}
