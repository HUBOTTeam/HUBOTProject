package com.HUBOT.HUBOT.PublicServices;

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
        if (publicServices != null) {
            return new ResponseEntity<>(publicServices, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/updatePublicService")
    public ResponseEntity<PublicServices> updatePublicService(@RequestBody PublicServices publicService) {
        PublicServices updatedPublicService = publicServicesService.updatePublicService(publicService);
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
