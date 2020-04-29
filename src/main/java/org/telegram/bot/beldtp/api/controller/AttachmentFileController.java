package org.telegram.bot.beldtp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.telegram.bot.beldtp.api.dto.AttachmentFileDto;
import org.telegram.bot.beldtp.api.model.AttachmentFile;
import org.telegram.bot.beldtp.api.service.interf.model.AttachmentFileService;
import org.telegram.bot.beldtp.api.service.interf.model.ResourcesService;

import java.net.URLConnection;

@RestController
@RequestMapping("/attachmentFile")
@CrossOrigin
public class AttachmentFileController {

    @Autowired
    private AttachmentFileService attachmentFileService;

    @Autowired
    private ResourcesService resourcesService;

    @GetMapping("/{id}")
    public ResponseEntity<AttachmentFileDto> getById(@PathVariable Long id) {
        AttachmentFile media = attachmentFileService.get(id);

        if (media == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new AttachmentFileDto(media), HttpStatus.OK);
    }

    @GetMapping("/file/{id}")
    public ResponseEntity<byte[]> get(@PathVariable Long id) {
        AttachmentFile media = attachmentFileService.get(id);

        if (media == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        byte[] bytes = attachmentFileService.getFile(id);

        if (bytes == null) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(bytes, getContentType(media), HttpStatus.OK);
    }

    public HttpHeaders getContentType(AttachmentFile media) {
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("Content-Type", URLConnection
                .guessContentTypeFromName(media.getResource().getFileName()));

        return httpHeaders;
    }
}
