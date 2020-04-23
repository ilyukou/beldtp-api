package org.telegram.bot.beldtp.api.repository.interf;


import org.telegram.bot.beldtp.api.model.Media;

public interface MediaRepository {

    Media get(Long id);
}
