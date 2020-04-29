package org.telegram.bot.beldtp.api.dto;

import java.util.List;

public class BackupInfoWrapper {
    private long millis;
    private String info;
    private String date;
    private List<IncidentBackupDto> incident;

    public BackupInfoWrapper(long millis, String info, String date, List<IncidentBackupDto> incident) {
        this.millis = millis;
        this.info = info;
        this.date = date;
        this.incident = incident;
    }

    public long getMillis() {
        return millis;
    }

    public void setMillis(long millis) {
        this.millis = millis;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<IncidentBackupDto> getIncident() {
        return incident;
    }

    public void setIncident(List<IncidentBackupDto> incident) {
        this.incident = incident;
    }
}
