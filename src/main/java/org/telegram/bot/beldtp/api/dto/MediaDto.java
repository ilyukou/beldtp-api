package org.telegram.bot.beldtp.api.dto;

import org.telegram.bot.beldtp.api.model.Media;
import org.telegram.bot.beldtp.api.model.MediaType;

public class MediaDto {

    private Long id;

    private String caption;

    private MediaType mediaType;

    private String fileName;

    public MediaDto(Media media) {
        if (media != null) {
            this.id = media.getId();
            this.caption = media.getCaption();
            this.mediaType = media.getMediaType();

            if (media.getResource() != null) {
                this.fileName = media.getResource().getFileName();
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
