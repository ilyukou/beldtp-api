package org.telegram.bot.beldtp.api.service.impl.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.bot.beldtp.api.model.Time;
import org.telegram.bot.beldtp.api.repository.interf.TimeRepository;
import org.telegram.bot.beldtp.api.service.interf.model.TimeService;

import java.util.List;

@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    private TimeRepository timeRepository;

    @Override
    public List<Time> get(long from, long to) {
        return timeRepository.get(from, to);
    }
}
