package org.hejin.messaging.rest.repository;

import java.util.Date;
import java.util.List;

import org.hejin.messaging.rest.domain.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends JpaRepository<Rate, String> {

    List<Rate> findByDate(Date date);

    Rate findByDateAndCode(Date date, String code);

}
