package org.bongiorno.aspects.latency;

import com.espertech.esper.client.EPStatement;
import com.espertech.esper.client.soda.EPStatementObjectModel;
import org.bongiorno.aspects.latency.listeners.LatencyListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:latency-context.xml")
public class LatencyAspectTest {

    @Test
    public void testDoAroundAdvice() throws Exception {
        EPStatementObjectModel epStatementObjectModel = epAdministrator.compileEPL("select amount,currency from Payment");
        EPStatement epStatement = epAdministrator.create(epStatementObjectModel);
        epStatement.addListener((newEvent,OldEvent) -> Arrays.stream(newEvent).forEach(event -> System.out.println(event.getUnderlying())));




        for(int i = 0; i < 10; i++) {
            Payment p = new PojoPayment(RandomStringUtils.random(5),"CHK", (float) (Math.random() * 1000),"USD");
            esperRuntime.sendEvent(p);
        }
        Thread.sleep(5000);
    }

    public class LatencyMeaurement implements LatencyListener{
        @Override
        public void perform(Class type, String methodName, Object[] args, long duration, Throwable error) {

        }
    }
}