package org.telegram.bot.beldtp.api.service.impl.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.bot.beldtp.api.model.Incident;
import org.telegram.bot.beldtp.api.repository.interf.IncidentRepository;
import org.telegram.bot.beldtp.api.service.interf.model.IncidentService;
import org.telegram.bot.beldtp.api.service.interf.model.LocationService;
import org.telegram.bot.beldtp.api.service.interf.model.TimeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidentServiceImpl implements IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;

    @Autowired
    private TimeService timeService;

    @Autowired
    private LocationService locationService;

    @Override
    public Incident get(Long id) {
        return incidentRepository.get(id);
    }

    @Override
    public List<Long> getAll() {
        return incidentRepository.getAll();
    }

    @Override
    public List<Long> getByTime(long from, long to) {
        return timeService.get(from, to).stream()
                .map(time -> time.getIncident().getId())
                .collect(Collectors.toList());
    }

    @Override
    public List<Long> getByLocation(Float longitude, Float latitude, Float radius) {
        return locationService.getByLocation(longitude, latitude, radius)
                .stream()
                .map(location -> location.getIncident().getId())
                .collect(Collectors.toList());
    }

    @Override
    public List<Incident> getAllIncident() {
        return incidentRepository.getAllIncident();
    }
}
