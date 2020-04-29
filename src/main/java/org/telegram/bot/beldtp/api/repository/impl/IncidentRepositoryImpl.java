package org.telegram.bot.beldtp.api.repository.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.telegram.bot.beldtp.api.model.Incident;
import org.telegram.bot.beldtp.api.model.IncidentType;
import org.telegram.bot.beldtp.api.repository.interf.IncidentRepository;
import org.telegram.bot.beldtp.api.repository.jpa.IncidentJpaRepository;
import org.telegram.bot.beldtp.api.service.interf.model.ResourcesService;

import java.util.List;

@Repository
public class IncidentRepositoryImpl implements IncidentRepository {

    private static final IncidentType API_INCIDENT_TYPE = IncidentType.PUBLISH;

    @Autowired
    private IncidentJpaRepository incidentJpaRepository;

    @Autowired
    private ResourcesService resourcesService;


    @Override
    public Incident get(Long id) {
        return incidentJpaRepository.findByIdAndType(id, API_INCIDENT_TYPE);
    }

    @Override
    public List<Long> getAll() {
        return incidentJpaRepository.findByType();
    }

    @Override
    public List<Incident> getAllIncident() {
        return incidentJpaRepository.findAll();
    }
}
