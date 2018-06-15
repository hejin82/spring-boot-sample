package org.hejin.messaging.rest.event;

import org.hejin.messaging.rest.domain.Rate;
import org.springframework.context.ApplicationEvent;

public class CurrencyEvent extends ApplicationEvent {

    private static final long serialVersionUID = 4037174253408497288L;
    private Rate rate;

    public CurrencyEvent(Object source, Rate rate) {
        super(source);
        this.rate = rate;
    }

    public Rate getRate() {
        return this.rate;
    }

}
