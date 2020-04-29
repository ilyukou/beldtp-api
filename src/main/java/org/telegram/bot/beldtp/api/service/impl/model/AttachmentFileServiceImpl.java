package org.telegram.bot.beldtp.api.service.impl.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.bot.beldtp.api.model.AttachmentFile;
import org.telegram.bot.beldtp.api.repository.interf.AttachmentFileRepository;
import org.telegram.bot.beldtp.api.service.interf.model.AttachmentFileService;
import org.telegram.bot.beldtp.api.service.interf.model.ResourcesService;

@Service
public class AttachmentFileServiceImpl implements AttachmentFileService {

    @Autowired
    private AttachmentFileRepository attachmentFileRepository;

    @Autowired
    private ResourcesService resourcesService;

    @Override
    public AttachmentFile get(Long id) {
        return attachmentFileRepository.get(id);
    }

    @Override
    public byte[] getFile(Long id) {
        AttachmentFile media = get(id);

        if (media == null || media.getResource() == null || media.getResource().getId() == null) {
            return null;
        }

        return resourcesService.get(media.getResource());
    }
}
