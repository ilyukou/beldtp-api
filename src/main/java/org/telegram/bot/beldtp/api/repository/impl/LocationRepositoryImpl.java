package org.telegram.bot.beldtp.api.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.telegram.bot.beldtp.api.model.Location;
import org.telegram.bot.beldtp.api.repository.interf.LocationRepository;
import org.telegram.bot.beldtp.api.repository.jpa.LocationJpaRepository;

import java.util.List;

@Repository
public class LocationRepositoryImpl implements LocationRepository {

    @Autowired
    private LocationJpaRepository locationJpaRepository;

    @Override
    public List<Location> getByLocation(Float longitude, Float latitude, Float radius) {
        return locationJpaRepository
                .findByLongitudeGreaterThanEqualAndLongitudeLessThanEqualAndLatitudeGreaterThanEqualAndLatitudeLessThanEqual(
                        longitude - radius, longitude + radius,
                        latitude - radius, latitude + radius
                );
    }
}
