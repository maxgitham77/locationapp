package com.locationapp.locationapp.controller;

import com.locationapp.locationapp.entity.Location;
import com.locationapp.locationapp.repository.LocationRepository;
import com.locationapp.locationapp.service.LocationService;
import com.locationapp.locationapp.utilities.EmailUtil;
import com.locationapp.locationapp.utilities.ReportUtil;
import jakarta.servlet.ServletContext;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class LocationController {

    private LocationService locationService;
    private LocationRepository locationRepository;
    private EmailUtil emailUtil;
    private ReportUtil reportUtil;

    private ServletContext servletContext;

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
        emailUtil.sendMail("mig1@student.london.ac.uk", "Location", "The Location was saved successfully!");
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

    @RequestMapping("/generateReport")
    public String generateReport()
    {
        String path = servletContext.getRealPath("/");
        List<Object[]> data = locationRepository.findTypeAndTypeCount();
        reportUtil.generatePieChart(path, data);
        return "report";
    }

}
