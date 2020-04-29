package org.telegram.bot.beldtp.api.repository.interf;


import org.telegram.bot.beldtp.api.model.AttachmentFile;

public interface AttachmentFileRepository {

    AttachmentFile get(Long id);
}
