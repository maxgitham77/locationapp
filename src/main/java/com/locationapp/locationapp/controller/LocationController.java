package com.locationapp.locationapp.controller;

import com.locationapp.locationapp.entity.Location;
import com.locationapp.locationapp.service.LocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class LocationController {

    private LocationService locationService;

    @GetMapping("/showCreate")
    public String showCreate()
    {
        return "createLocation";
    }

    @PostMapping("/saveLocation")
    public String saveLocation(@ModelAttribute Location location, ModelMap modelMap)
    {
        Location savedLocation = locationService.createLocation(location);
        String msg = "Location saved with the id: " + savedLocation.getId();
        modelMap.addAttribute("msg", msg);
        return "createLocation";
    }

    @GetMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap)
    {
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @GetMapping("/deleteLocation")
    public String deleteLocation(@RequestParam Long id, ModelMap modelMap)
    {
        Location location = new Location();
        location.setId(id);
        locationService.deleteLocation(location);
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @GetMapping("/showUpdate")
    public String showUpdate(@RequestParam Long id, ModelMap modelMap)
    {
        Location location = locationService.getLocationById(id);
        modelMap.addAttribute("location", location);
        return "updateLocation";
    }

    @PostMapping("/updateLocation")
    public String updateLocation(@ModelAttribute Location location, ModelMap modelMap)
    {
        locationService.updateLocation(location);
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

}
