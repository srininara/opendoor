package com.aconex.hackathon.opendoor.controller;

import com.aconex.hackathon.opendoor.model.Location;
import com.aconex.hackathon.opendoor.repository.LocationRepository;
import com.aconex.hackathon.opendoor.representation.FeedbackDto;
import com.aconex.hackathon.opendoor.representation.LocationDto;
import com.aconex.hackathon.opendoor.service.FeedbackService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);

    private LocationRepository locationRepository;

    @Autowired
    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<LocationDto> getLocations() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream().map(location -> new LocationDto(location.getName())).collect(Collectors.toList());
    }
}
