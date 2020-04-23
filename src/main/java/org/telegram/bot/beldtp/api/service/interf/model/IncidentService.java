package org.telegram.bot.beldtp.api.service.interf.model;


import org.telegram.bot.beldtp.api.model.Incident;

import java.util.List;

public interface IncidentService {

    Incident get(Long id);

    List<Long> getAll();

    List<Long> getByTime(long from, long to);

    List<Long> getByLocation(Float longitude, Float latitude, Float radius);
}
