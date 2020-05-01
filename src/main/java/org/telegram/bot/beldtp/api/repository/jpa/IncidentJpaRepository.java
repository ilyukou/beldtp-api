package org.telegram.bot.beldtp.api.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.telegram.bot.beldtp.api.model.Incident;
import org.telegram.bot.beldtp.api.model.IncidentType;

import java.util.List;

public interface IncidentJpaRepository extends JpaRepository<Incident, Long> {

    Incident findByIdAndType(Long id, IncidentType type);

    List<Incident> findByType(IncidentType type);

    @Query(value = "SELECT id FROM beldtp.incident WHERE type = 5;", nativeQuery = true)
    List<Long> findByType();

    @Query(value = "SELECT id,location_id FROM beldtp.incident WHERE type = 5;", nativeQuery = true)
    List<Object[]> getIncidentIdAndLocation();
}
