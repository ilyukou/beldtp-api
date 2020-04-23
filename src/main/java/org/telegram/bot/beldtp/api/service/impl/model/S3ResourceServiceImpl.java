package org.telegram.bot.beldtp.api.service.impl.model;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.bot.beldtp.api.model.Resource;
import org.telegram.bot.beldtp.api.repository.interf.ResourceRepository;
import org.telegram.bot.beldtp.api.service.interf.model.ResourcesService;

import java.io.IOException;

@Service
public class S3ResourceServiceImpl implements ResourcesService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Autowired
    private AmazonS3 amazonS3;


    @Value("${s3.bucketName}")
    private String bucketName;


    @Override
    public Resource get(Long id) {
        return resourceRepository.get(id);
    }

    @Override
    public byte[] get(Resource resource) {
        if (resource == null) {
            return null;
        }
        GetObjectRequest rangeObjectRequest = new GetObjectRequest(bucketName, resource.getFileName());

        try {
            S3Object objectPortion = amazonS3.getObject(rangeObjectRequest);
            return objectPortion.getObjectContent().readAllBytes();
        } catch (IOException e) {
            return null;
        }
    }
}
