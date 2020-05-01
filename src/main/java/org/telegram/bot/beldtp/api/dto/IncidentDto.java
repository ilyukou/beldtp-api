package org.telegram.bot.beldtp.api.dto;

import org.telegram.bot.beldtp.api.model.AttachmentFile;
import org.telegram.bot.beldtp.api.model.Incident;
import org.telegram.bot.beldtp.api.model.Location;
import org.telegram.bot.beldtp.api.model.Time;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class IncidentDto {

    private Long id;

    private String text;

    private Set<Long> media = new HashSet<>();

    private Integer year;

    private Long millis;

    private Byte day;

    private Byte month;

    private Byte hour;

    private Byte minute;

    private Float longitude;

    private Float latitude;

    public IncidentDto(Incident incident) {
        this(incident, incident.getTime(), incident.getLocation());
    }

    public IncidentDto(Incident incident, Time time, Location location) {
        if (incident != null) {
            this.id = incident.getId();
            this.text = incident.getText();

            if (incident.getAttachmentFiles() != null) {
                this.media = incident.getAttachmentFiles().stream().map(AttachmentFile::getId).collect(Collectors.toSet());
            }
        }

        if (time != null) {
            this.year = time.getYear();
            this.day = time.getDay();
            this.month = time.getMonth();
            this.hour = time.getHour();
            this.minute = time.getMinute();
            this.millis = time.getTimeInMillis();
        }

        if (location != null) {
            this.longitude = location.getLongitude();
            this.latitude = location.getLatitude();
        }
    }

    public Long getMillis() {
        return millis;
    }

    public void setMillis(Long millis) {
        this.millis = millis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<Long> getMedia() {
        return media;
    }

    public void setMedia(Set<Long> media) {
        this.media = media;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Byte getDay() {
        return day;
    }

    public void setDay(Byte day) {
        this.day = day;
    }

    public Byte getMonth() {
        return month;
    }

    public void setMonth(Byte month) {
        this.month = month;
    }

    public Byte getHour() {
        return hour;
    }

    public void setHour(Byte hour) {
        this.hour = hour;
    }

    public Byte getMinute() {
        return minute;
    }

    public void setMinute(Byte minute) {
        this.minute = minute;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
}
