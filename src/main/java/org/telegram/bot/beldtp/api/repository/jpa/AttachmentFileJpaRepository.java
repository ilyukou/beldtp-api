package org.telegram.bot.beldtp.api.repository.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.telegram.bot.beldtp.api.model.AttachmentFile;

import java.util.List;

public interface AttachmentFileJpaRepository extends JpaRepository<AttachmentFile, Long> {
    List<AttachmentFile> findByIncident_Id(Long incidentId);
}
