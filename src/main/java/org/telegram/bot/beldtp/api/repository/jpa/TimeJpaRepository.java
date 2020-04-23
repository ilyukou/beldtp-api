package org.telegram.bot.beldtp.api.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telegram.bot.beldtp.api.model.Time;

import java.util.List;

public interface TimeJpaRepository extends JpaRepository<Time, Long> {

    List<Time> findByTimeInMillisGreaterThanEqualAndTimeInMillisLessThanEqual(long from, long to);
}
