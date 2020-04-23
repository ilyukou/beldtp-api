package org.telegram.bot.beldtp.api.repository.interf;


import org.telegram.bot.beldtp.api.model.Time;

import java.util.List;

public interface TimeRepository {
    List<Time> get(long from, long to);

}
