package com.HUBOT.HUBOT.PublicServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicServicesService {

    private final PublicServicesRepository publicServicesRepository;

    @Autowired
    public PublicServicesService(PublicServicesRepository publicServicesRepository) {
        this.publicServicesRepository = publicServicesRepository;
    }

    public PublicServices addPublicService(PublicServices publicService) {
        return publicServicesRepository.save(publicService);
    }

    public PublicServices getPublicServiceById(String publicServiceId) {
        return publicServicesRepository.findById(publicServiceId).orElse(null);
    }

    public List<PublicServices> getAllPublicServices() {
        return publicServicesRepository.findAll();
    }

    public PublicServices updatePublicService(PublicServices publicService) {
        PublicServices existingPublicService = publicServicesRepository.findById(publicService.getPublicServicesId()).orElse(null);
        if (existingPublicService != null) {
            return publicServicesRepository.save(publicService);
        }
        return null;
    }

    public boolean deletePublicService(String publicServiceId) {
        PublicServices existingPublicService = publicServicesRepository.findById(publicServiceId).orElse(null);
        if (existingPublicService != null) {
            publicServicesRepository.delete(existingPublicService);
            return true;
        }
        return false;
    }
}
