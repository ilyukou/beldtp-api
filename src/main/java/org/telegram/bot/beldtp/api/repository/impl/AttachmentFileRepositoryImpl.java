package org.telegram.bot.beldtp.api.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.telegram.bot.beldtp.api.model.AttachmentFile;
import org.telegram.bot.beldtp.api.repository.interf.IncidentRepository;
import org.telegram.bot.beldtp.api.repository.interf.AttachmentFileRepository;
import org.telegram.bot.beldtp.api.repository.jpa.AttachmentFileJpaRepository;

@Repository
public class AttachmentFileRepositoryImpl implements AttachmentFileRepository {

    @Autowired
    private AttachmentFileJpaRepository attachmentFileJpaRepository;

    @Autowired
    private IncidentRepository incidentRepository;

    @Override
    public AttachmentFile get(Long id) {
        return attachmentFileJpaRepository.findById(id).orElse(null);
    }
}
