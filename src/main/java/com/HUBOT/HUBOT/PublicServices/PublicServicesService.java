package com.HUBOT.HUBOT.PublicServices;

import com.HUBOT.HUBOT.Enum.TypeOfService;
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

    public List<PublicServices> getPublicServicesByBuildingId(String buildingId) {
        return publicServicesRepository.findByBuildingId(buildingId);
    }

    public List<PublicServices> getPublicServicesByTypeOfService(TypeOfService typeOfService) {
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
        }
        return null;
    }

    public PublicServices updateTypeOfService(String publicServiceId, TypeOfService typeOfService) {
        PublicServices publicService = publicServicesRepository.findById(publicServiceId).orElse(null);
        if (publicService != null) {
            publicService.setTypeOfService(typeOfService);
            return publicServicesRepository.save(publicService);
        }
        return null;
    }

    public PublicServices updatePublicServicePlaceName(String publicServiceId, String publicServicePlaceName) {
        PublicServices publicService = publicServicesRepository.findById(publicServiceId).orElse(null);
        if (publicService != null) {
            publicService.setPublicServicePlaceName(publicServicePlaceName);
            return publicServicesRepository.save(publicService);
        }
        return null;
    }

    public PublicServices updateKeyword(String publicServiceId, String keyword) {
        PublicServices publicService = publicServicesRepository.findById(publicServiceId).orElse(null);
        if (publicService != null) {
            publicService.setKeyword(keyword);
            return publicServicesRepository.save(publicService);
        }
        return null;
    }

    public PublicServices updateDescription(String publicServiceId, String description) {
        PublicServices publicService = publicServicesRepository.findById(publicServiceId).orElse(null);
        if (publicService != null) {
            publicService.setDescription(description);
            return publicServicesRepository.save(publicService);
        }
        return null;
    }

    public boolean deletePublicService(String publicServiceId) {
        PublicServices publicService = publicServicesRepository.findById(publicServiceId).orElse(null);
        if (publicService != null) {
            publicServicesRepository.delete(publicService);
            return true;
        }
        return false;
    }
}
