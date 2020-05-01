package org.telegram.bot.beldtp.api.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.telegram.bot.beldtp.api.model.Location;

import java.util.List;

public interface LocationJpaRepository extends JpaRepository<Location, Long> {

    List<Location> findByLongitudeGreaterThanEqualAndLongitudeLessThanEqualAndLatitudeGreaterThanEqualAndLatitudeLessThanEqual(
            Float minLongitude, Float maxLongitude, Float minLatitude, Float maxLatitude);

    @Query(value = "SELECT l.longitude, l.latitude from Location l where l.id in :ids")
    List<Object[]> getLongitudeAndLatitude(@Param("ids") List<Long> ids);
}
