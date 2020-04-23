package org.telegram.bot.beldtp.api.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.telegram.bot.beldtp.api.model.Media;
import org.telegram.bot.beldtp.api.repository.interf.IncidentRepository;
import org.telegram.bot.beldtp.api.repository.interf.MediaRepository;
import org.telegram.bot.beldtp.api.repository.jpa.MediaJpaRepository;

@Repository
public class MediaRepositoryImpl implements MediaRepository {

    @Autowired
    private MediaJpaRepository mediaJpaRepository;

    @Autowired
    private IncidentRepository incidentRepository;

    @Override
    public Media get(Long id) {
        return mediaJpaRepository.findById(id).orElse(null);
    }
}
