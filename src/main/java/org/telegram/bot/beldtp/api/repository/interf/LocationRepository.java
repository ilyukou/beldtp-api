package org.telegram.bot.beldtp.api.repository.interf;

import org.telegram.bot.beldtp.api.model.Location;

import java.util.List;

public interface LocationRepository {
    List<Location> getByLocation(Float longitude, Float latitude, Float radius);
}
