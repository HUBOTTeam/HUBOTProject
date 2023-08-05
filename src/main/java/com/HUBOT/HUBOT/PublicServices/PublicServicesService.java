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
        return publicServicesRepository.insert(publicService);
    }

    public PublicServices getPublicServiceById(String publicServiceId) {
        return publicServicesRepository.findById(publicServiceId).orElse(null);
    }

    public List<PublicServices> getAllPublicServices() {
        return publicServicesRepository.findAll();
    }

    public PublicServices updatePublicService(PublicServices publicService) {
        return publicServicesRepository.save(publicService);
    }

    public boolean deletePublicService(String publicServiceId) {
        PublicServices existingPublicService = publicServicesRepository.findById(publicServiceId).orElse(null);
        if (existingPublicService != null) {
            publicServicesRepository.delete(existingPublicService);
            return true;
        }
        return false;
    }

    // Additional methods for filtering and updating public services

    public List<PublicServices> getPublicServicesByBuildingId(String buildingId) {
        return publicServicesRepository.findByBuildingId(buildingId);
    }

    public List<PublicServices> getPublicServicesByTypeOfService(String typeOfService) {
        return publicServicesRepository.findByTypeOfService(typeOfService);
    }

    public List<PublicServices> getPublicServicesByPublicServicePlaceName(String publicServicePlaceName) {
        return publicServicesRepository.findByPublicServicePlaceName(publicServicePlaceName);
    }

    public PublicServices updatePublicServiceLocationId(String publicServiceId, int publicServiceLocationId) {
        PublicServices publicService = publicServicesRepository.findById(publicServiceId).orElse(null);
        if (publicService != null) {
            publicService.setPublicServiceLocationId(publicServiceLocationId);
            return publicServicesRepository.save(publicService);
        } else {
            return null;
        }
    }

    public PublicServices updateBuildingId(String publicServiceId, String buildingId) {
        PublicServices publicService = publicServicesRepository.findById(publicServiceId).orElse(null);
        if (publicService != null) {
            publicService.setBuildingId(buildingId);
            return publicServicesRepository.save(publicService);
        } else {
            return null;
        }
    }

    public PublicServices updateTypeOfService(String publicServiceId, String typeOfService) {
        PublicServices publicService = publicServicesRepository.findById(publicServiceId).orElse(null);
        if (publicService != null) {
            publicService.setTypeOfService(typeOfService);
            return publicServicesRepository.save(publicService);
        } else {
            return null;
        }
    }

    public PublicServices updatePublicServicePlaceName(String publicServiceId, String publicServicePlaceName) {
        PublicServices publicService = publicServicesRepository.findById(publicServiceId).orElse(null);
        if (publicService != null) {
            publicService.setPublicServicePlaceName(publicServicePlaceName);
            return publicServicesRepository.save(publicService);
        } else {
            return null;
        }
    }

    public PublicServices updateKeyword(String publicServiceId, String keyword) {
        PublicServices publicService = publicServicesRepository.findById(publicServiceId).orElse(null);
        if (publicService != null) {
            publicService.setKeyword(keyword);
            return publicServicesRepository.save(publicService);
        } else {
            return null;
        }
    }

    public PublicServices updateDescription(String publicServiceId, String description) {
        PublicServices publicService = publicServicesRepository.findById(publicServiceId).orElse(null);
        if (publicService != null) {
            publicService.setDescription(description);
            return publicServicesRepository.save(publicService);
        } else {
            return null;
        }
    }

}
