package org.telegram.bot.beldtp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.telegram.bot.beldtp.api.dto.MediaDto;
import org.telegram.bot.beldtp.api.model.Media;
import org.telegram.bot.beldtp.api.service.interf.model.MediaService;
import org.telegram.bot.beldtp.api.service.interf.model.ResourcesService;

import java.net.URLConnection;

@RestController
@RequestMapping("/media")
@CrossOrigin
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @Autowired
    private ResourcesService resourcesService;

    @GetMapping("/{id}")
    public ResponseEntity<MediaDto> getById(@PathVariable Long id) {
        Media media = mediaService.get(id);

        if (media == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new MediaDto(media), HttpStatus.OK);
    }

    @GetMapping("/file")
    public ResponseEntity<byte[]> get(@RequestParam Long id) {
        Media media = mediaService.get(id);

        if (media == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        byte[] bytes = mediaService.getFile(id);

        if (bytes == null) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity(bytes, getContentType(media), HttpStatus.OK);
    }

    public HttpHeaders getContentType(Media media) {
        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.add("Content-Type", URLConnection
                .guessContentTypeFromName(media.getResource().getFileName()));

        return httpHeaders;
    }
}
