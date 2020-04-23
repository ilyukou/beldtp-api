package org.telegram.bot.beldtp.api.service.interf.model;


import org.telegram.bot.beldtp.api.model.Media;

public interface MediaService {

    Media get(Long id);

    byte[] getFile(Long id);
}
