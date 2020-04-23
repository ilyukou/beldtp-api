package org.telegram.bot.beldtp.api.repository.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.telegram.bot.beldtp.api.model.Resource;
import org.telegram.bot.beldtp.api.repository.interf.ResourceRepository;
import org.telegram.bot.beldtp.api.repository.jpa.ResourceJpaRepository;

@Repository
public class ResourceRepositoryImpl implements ResourceRepository {

    @Autowired
    private ResourceJpaRepository resourceJpaRepository;

    @Override
    public Resource get(Long id) {
        return resourceJpaRepository.findById(id).orElse(null);
    }

}
