package com.aconex.hackathon.opendoor.service;

import com.aconex.hackathon.opendoor.model.Location;
import com.aconex.hackathon.opendoor.repository.LocationRepository;
import com.aconex.hackathon.opendoor.representation.LocationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.aconex.hackathon.opendoor.service.ObjectConverter.dto;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationDto> getLocations() {
        List<Location> locations = locationRepository.findAll();
        return locations.stream().map(ObjectConverter::dto)
                .collect(Collectors.toList());
    }

    public LocationDto getLocation(int locationId) {
        Location location = locationRepository.findOne(locationId);
        return dto(location);
    }
}
