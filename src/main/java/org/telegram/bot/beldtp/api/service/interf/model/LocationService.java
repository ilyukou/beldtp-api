package org.telegram.bot.beldtp.api.service.interf.model;

import org.telegram.bot.beldtp.api.model.Location;

import java.util.List;

public interface LocationService {
    List<Location> getByLocation(Float longitude, Float latitude, Float radius);

    List<Location> getLongitudeAndLatitude(List<Long> ids);
}
