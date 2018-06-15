package org.hejin.messaging.rest.listener;

import org.hejin.messaging.rest.annotation.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.ServletRequestHandledEvent;

@Component
public class RestApiEventsListener implements ApplicationListener<ApplicationEvent> {
    private static final String LATEST = "/currency/latest";

    @Autowired
    private CounterService counterService;

    @Override
    @Log(printParamsValues = true)
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ServletRequestHandledEvent) {
            if (((ServletRequestHandledEvent) event).getRequestUrl().equals(LATEST)) {
                counterService.increment("url.currency.lastest.hits");
            }
        }
    }

}
