package org.telegram.bot.beldtp.api.service.impl.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.bot.beldtp.api.model.Location;
import org.telegram.bot.beldtp.api.repository.interf.LocationRepository;
import org.telegram.bot.beldtp.api.service.interf.model.LocationService;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getByLocation(Float longitude, Float latitude, Float radius) {
        return locationRepository.getByLocation(longitude, latitude, radius);
    }

    @Override
    public List<Location> getLongitudeAndLatitude(List<Long> ids) {
        return locationRepository.getLongitudeAndLatitude(ids);
    }

}
