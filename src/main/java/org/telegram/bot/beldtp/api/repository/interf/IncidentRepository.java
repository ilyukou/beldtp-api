package org.telegram.bot.beldtp.api.repository.interf;


import org.telegram.bot.beldtp.api.model.Incident;

import java.util.List;

public interface IncidentRepository {

    Incident get(Long id);

    List<Long> getAll();
}
