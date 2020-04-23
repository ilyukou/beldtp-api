package org.telegram.bot.beldtp.api.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.telegram.bot.beldtp.api.model.Location;

import java.util.List;

public interface LocationJpaRepository extends JpaRepository<Location, Long> {

    List<Location> findByLongitudeGreaterThanEqualAndLongitudeLessThanEqualAndLatitudeGreaterThanEqualAndLatitudeLessThanEqual(
            Float minLongitude, Float maxLongitude, Float minLatitude, Float maxLatitude);

}
