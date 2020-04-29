package org.telegram.bot.beldtp.api.service.interf.model;


import org.telegram.bot.beldtp.api.model.AttachmentFile;

public interface AttachmentFileService {

    AttachmentFile get(Long id);

    byte[] getFile(Long id);
}
