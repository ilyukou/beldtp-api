package org.telegram.bot.beldtp.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.bot.beldtp.api.dto.BackupInfoWrapper;
import org.telegram.bot.beldtp.api.dto.IncidentBackupDto;
import org.telegram.bot.beldtp.api.service.interf.model.IncidentService;

import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/backup")
public class BackupController {

    @Autowired
    private IncidentService incidentService;

    @GetMapping
    public BackupInfoWrapper getAll() {
        List<IncidentBackupDto> incidents = incidentService.getAllIncident()
                .stream()
                .map(incident -> new IncidentBackupDto(incident, incident.getTime(), incident.getLocation()))
                .collect(Collectors.toList());

        Calendar calendar = Calendar.getInstance();
 

        return new BackupInfoWrapper(calendar.getTimeInMillis(), "ok", calendar.getTime().toString(), incidents);
    }

}
