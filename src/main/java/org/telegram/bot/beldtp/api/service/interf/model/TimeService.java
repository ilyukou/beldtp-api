package org.telegram.bot.beldtp.api.service.interf.model;

import org.telegram.bot.beldtp.api.model.Time;

import java.util.List;

public interface TimeService {
    List<Time> get(long from, long to);
}
