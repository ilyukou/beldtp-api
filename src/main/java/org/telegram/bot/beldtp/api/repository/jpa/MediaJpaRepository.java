package org.telegram.bot.beldtp.api.repository.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.telegram.bot.beldtp.api.model.Media;

import java.util.List;

public interface MediaJpaRepository extends JpaRepository<Media, Long> {
    List<Media> findByIncident_Id(Long incidentId);
}
