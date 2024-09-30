package com.locationapp.locationapp.integration;

import com.locationapp.locationapp.entity.Location;
import com.locationapp.locationapp.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
@CrossOrigin("*")
public class LocationRestController {

    @Autowired
    LocationRepository locationRepository;

    @GetMapping
    public List<Location> getLocations()
    {
        return locationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Location getLocation(@PathVariable("id") Long id)
    {
        return locationRepository.findById(id).get();
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location)
    {
        return locationRepository.save(location);
    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location)
    {
        return locationRepository.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") Long id)
    {
        locationRepository.deleteById(id);
    }

}
