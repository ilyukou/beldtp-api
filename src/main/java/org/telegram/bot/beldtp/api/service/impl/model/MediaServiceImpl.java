package org.telegram.bot.beldtp.api.service.impl.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.bot.beldtp.api.model.Media;
import org.telegram.bot.beldtp.api.repository.interf.MediaRepository;
import org.telegram.bot.beldtp.api.service.interf.model.MediaService;
import org.telegram.bot.beldtp.api.service.interf.model.ResourcesService;

@Service
public class MediaServiceImpl implements MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private ResourcesService resourcesService;

    @Override
    public Media get(Long id) {
        return mediaRepository.get(id);
    }

    @Override
    public byte[] getFile(Long id) {
        Media media = get(id);

        if (media == null || media.getResource() == null || media.getResource().getId() == null) {
            return null;
        }

        return resourcesService.get(media.getResource());
    }
}
