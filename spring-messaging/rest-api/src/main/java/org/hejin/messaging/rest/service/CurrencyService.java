package org.hejin.messaging.rest.service;

import java.util.Arrays;
import java.util.Date;

import javax.transaction.Transactional;

import org.hejin.messaging.rest.domain.Rate;
import org.hejin.messaging.rest.event.CurrencyEvent;
import org.hejin.messaging.rest.repository.RateRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {
    private RateRepository repository;
    private ApplicationEventPublisher publisher;

    public CurrencyService(RateRepository repository, ApplicationEventPublisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    public void saveRates(Rate[] rates, Date date) {
        Arrays.stream(rates)
                .forEach(rate -> repository.save(new Rate(rate.getCode(), rate.getRate(), date)));
    }

    @Transactional
    public void saveRate(Rate rate) {
        repository.save(new Rate(rate.getCode(), rate.getRate(), rate.getDate()));
        publisher.publishEvent(new CurrencyEvent(this, rate));
    }
}
