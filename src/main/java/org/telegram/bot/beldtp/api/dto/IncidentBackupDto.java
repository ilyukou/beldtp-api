package org.telegram.bot.beldtp.api.dto;

import org.telegram.bot.beldtp.api.model.AttachmentFile;
import org.telegram.bot.beldtp.api.model.Incident;
import org.telegram.bot.beldtp.api.model.Location;
import org.telegram.bot.beldtp.api.model.Time;

import java.util.HashSet;
import java.util.Set;

public class IncidentBackupDto {

    private Long id;

    private String text;

    private Set<AttachmentFileDto> attachmentFile = new HashSet<>();

    private Integer year;

    private Long millis;

    private Byte day;

    private Byte month;

    private Byte hour;

    private Byte minute;

    private Float longitude;

    private Float latitude;

    private String city;

    private String cityDistrict;

    private String country;

    private String countryCode;

    private String county;

    private String postcode;

    private String road;

    private String houseNumber;

    private String state;

    public IncidentBackupDto(Incident incident, Time time, Location location) {
        if (incident != null) {
            this.id = incident.getId();
            this.text = incident.getText();

            for (AttachmentFile attachmentFile : incident.getAttachmentFiles()){
                this.attachmentFile.add(new AttachmentFileDto(attachmentFile));
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
            this.city = location.getCity();
            this.cityDistrict = location.getCityDistrict();
            this.country = location.getCountry();
            this.countryCode = location.getCountryCode();
            this.county = location.getCounty();
            this.postcode = location.getPostcode();
            this.road = location.getRoad();
            this.houseNumber = location.getHouseNumber();
            this.state = location.getState();
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

    public Set<AttachmentFileDto> getAttachmentFile() {
        return attachmentFile;
    }

    public void setAttachmentFile(Set<AttachmentFileDto> attachmentFile) {
        this.attachmentFile = attachmentFile;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityDistrict() {
        return cityDistrict;
    }

    public void setCityDistrict(String cityDistrict) {
        this.cityDistrict = cityDistrict;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getRoad() {
        return road;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
