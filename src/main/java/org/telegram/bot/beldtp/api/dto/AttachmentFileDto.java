package org.telegram.bot.beldtp.api.dto;

import org.telegram.bot.beldtp.api.model.AttachmentFile;
import org.telegram.bot.beldtp.api.model.AttachmentFileType;

public class AttachmentFileDto {

    private Long id;

    private String caption;

    private AttachmentFileType mediaType;

    private String fileName;

    public AttachmentFileDto(AttachmentFile media) {
        if (media != null) {
            this.id = media.getId();
            this.caption = media.getCaption();
            this.mediaType = media.getAttachmentFileType();

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

    public AttachmentFileType getMediaType() {
        return mediaType;
    }

    public void setMediaType(AttachmentFileType mediaType) {
        this.mediaType = mediaType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
