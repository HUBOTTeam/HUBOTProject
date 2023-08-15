package com.HUBOT.HUBOT.PublicServices;

import com.HUBOT.HUBOT.Enum.TypeOfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/publicServices")
public class PublicServicesController {

    private final PublicServicesService publicServicesService;

    @Autowired
    public PublicServicesController(PublicServicesService publicServicesService) {
        this.publicServicesService = publicServicesService;
    }

    @PostMapping("/addPublicService")
    public ResponseEntity<PublicServices> addPublicService(@RequestBody PublicServices publicService) {
        PublicServices addedPublicService = publicServicesService.addPublicService(publicService);
        if (addedPublicService != null) {
            return new ResponseEntity<>(addedPublicService, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getPublicServiceById")
    public ResponseEntity<PublicServices> getPublicServiceById(@RequestParam String publicServiceId) {
        PublicServices publicService = publicServicesService.getPublicServiceById(publicServiceId);
        if (publicService != null) {
            return new ResponseEntity<>(publicService, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllPublicServices")
    public ResponseEntity<List<PublicServices>> getAllPublicServices() {
        List<PublicServices> publicServices = publicServicesService.getAllPublicServices();
        if (!publicServices.isEmpty()) {
            return new ResponseEntity<>(publicServices, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
// Existing mappings...

    @GetMapping("/getPublicServicesByBuildingId")
    public ResponseEntity<List<PublicServices>> getPublicServicesByBuildingId(@RequestParam String buildingId) {
        List<PublicServices> publicServices = publicServicesService.getPublicServicesByBuildingId(buildingId);
        if (!publicServices.isEmpty()) {
            return new ResponseEntity<>(publicServices, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getPublicServicesByTypeOfService")
    public ResponseEntity<List<PublicServices>> getPublicServicesByTypeOfService(@RequestParam TypeOfService typeOfService) {
        List<PublicServices> publicServices = publicServicesService.getPublicServicesByTypeOfService(typeOfService);
        if (!publicServices.isEmpty()) {
            return new ResponseEntity<>(publicServices, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getPublicServicesByPublicServicePlaceName")
    public ResponseEntity<List<PublicServices>> getPublicServicesByPublicServicePlaceName(@RequestParam String publicServicePlaceName) {
        List<PublicServices> publicServices = publicServicesService.getPublicServicesByPublicServicePlaceName(publicServicePlaceName);
        if (!publicServices.isEmpty()) {
            return new ResponseEntity<>(publicServices, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updatePublicServiceLocationId")
    public ResponseEntity<PublicServices> updatePublicServiceLocationId(
            @RequestParam String publicServiceId,
            @RequestParam int publicServiceLocationId) {
        PublicServices updatedPublicService = publicServicesService.updatePublicServiceLocationId(publicServiceId, publicServiceLocationId);
        if (updatedPublicService != null) {
            return new ResponseEntity<>(updatedPublicService, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateTypeOfService")
    public ResponseEntity<PublicServices> updateTypeOfService(
            @RequestParam String publicServiceId,
            @RequestParam TypeOfService typeOfService) {
        PublicServices updatedPublicService = publicServicesService.updateTypeOfService(publicServiceId, typeOfService);
        if (updatedPublicService != null) {
            return new ResponseEntity<>(updatedPublicService, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updatePublicServicePlaceName")
    public ResponseEntity<PublicServices> updatePublicServicePlaceName(
            @RequestParam String publicServiceId,
            @RequestParam String publicServicePlaceName) {
        PublicServices updatedPublicService = publicServicesService.updatePublicServicePlaceName(publicServiceId, publicServicePlaceName);
        if (updatedPublicService != null) {
            return new ResponseEntity<>(updatedPublicService, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateKeyword")
    public ResponseEntity<PublicServices> updateKeyword(
            @RequestParam String publicServiceId,
            @RequestParam String keyword) {
        PublicServices updatedPublicService = publicServicesService.updateKeyword(publicServiceId, keyword);
        if (updatedPublicService != null) {
            return new ResponseEntity<>(updatedPublicService, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updateDescription")
    public ResponseEntity<PublicServices> updateDescription(
            @RequestParam String publicServiceId,
            @RequestParam String description) {
        PublicServices updatedPublicService = publicServicesService.updateDescription(publicServiceId, description);
        if (updatedPublicService != null) {
            return new ResponseEntity<>(updatedPublicService, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletePublicService")
    public ResponseEntity<String> deletePublicService(@RequestParam String publicServiceId) {
        boolean deleted = publicServicesService.deletePublicService(publicServiceId);
        if (deleted) {
            return new ResponseEntity<>("Public Service with ID: " + publicServiceId + " was deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Public Service with ID: " + publicServiceId + " not found", HttpStatus.NOT_FOUND);
        }
    }
}
