package com.locationapp.locationapp.service;

import com.locationapp.locationapp.entity.Location;

import java.util.List;

public interface LocationService {
     Location createLocation(Location location);
     List<Location> getAllLocations();
     Location getLocationById(Long locationId);
     Location updateLocation(Location location);
     void deleteLocation(Location location);
}
