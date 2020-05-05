package org.telegram.bot.beldtp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.telegram.bot.beldtp.api.dto.IncidentDto;
import org.telegram.bot.beldtp.api.dto.LocationDto;
import org.telegram.bot.beldtp.api.model.Incident;
import org.telegram.bot.beldtp.api.service.interf.model.IncidentService;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "Access-Control-Allow-Origin: *", allowedHeaders = "Access-Control-Allow-Origin: *")
@RestController
@RequestMapping("/incident")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @GetMapping("/getAllMarker")
    public List<LocationDto> getAllMarker() {
        return incidentService.getAllMarker();
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncidentDto> getById(@PathVariable Long id) {
        Incident incident = incidentService.get(id);

        if (incident == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(new IncidentDto(incident, incident.getTime(), incident.getLocation()), HttpStatus.OK);
    }

    @GetMapping
    public List<Long> getAll() {
        return incidentService.getAll();
    }

    @GetMapping("/getByTime")
    public ResponseEntity<List<Long>> getByTime(
            @RequestParam long from,
            @RequestParam long to
    ) {

        if (from > to) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(incidentService.getByTime(from, to), HttpStatus.OK);
    }

    @GetMapping("/getByLocation")
    public List<Long> getByLocation(
            @RequestParam Float longitude,
            @RequestParam Float latitude,
            @RequestParam Float radius
    ) {
        return incidentService.getByLocation(longitude, latitude, radius);
    }
}
