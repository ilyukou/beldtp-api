package org.telegram.bot.beldtp.api.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.telegram.bot.beldtp.api.model.Time;
import org.telegram.bot.beldtp.api.repository.interf.TimeRepository;
import org.telegram.bot.beldtp.api.repository.jpa.TimeJpaRepository;

import java.util.List;

@Repository
public class TimeRepositoryImpl implements TimeRepository {

    @Autowired
    private TimeJpaRepository timeJpaRepository;

    @Override
    public List<Time> get(long from, long to) {

        return timeJpaRepository.findByTimeInMillisGreaterThanEqualAndTimeInMillisLessThanEqual(from, to);
    }
}
