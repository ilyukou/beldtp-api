package org.telegram.bot.beldtp.api.service.interf.model;


import org.telegram.bot.beldtp.api.model.Resource;

public interface ResourcesService {

    Resource get(Long id);

    byte[] get(Resource resource);
}
