package org.telegram.bot.beldtp.api.repository.interf;


import org.telegram.bot.beldtp.api.model.Resource;

public interface ResourceRepository {
    Resource get(Long id);
}
