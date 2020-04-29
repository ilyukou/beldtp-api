package org.telegram.bot.beldtp.api.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "incident")
public class Incident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String text;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "incident", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<AttachmentFile> attachmentFiles = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "timeId")
    private Time time;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "locationId")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private IncidentType type;

    public Incident() {
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

    public Set<AttachmentFile> getAttachmentFiles() {
        return attachmentFiles;
    }

    public void setAttachmentFiles(Set<AttachmentFile> attachmentFiles) {
        this.attachmentFiles = attachmentFiles;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public IncidentType getType() {
        return type;
    }

    public void setType(IncidentType type) {
        this.type = type;
    }

    public boolean hasTime() {
        return time != null;
    }

    public boolean hasLocation(){
        return location != null;
    }

    public boolean hasMedia(){
        return attachmentFiles != null && attachmentFiles.size() > 0;
    }

    public void add(AttachmentFile attachmentFile){
        this.attachmentFiles.add(attachmentFile);
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        Incident inc = (Incident) obj;

        if (inc.id == null || this.id == null) {
            return false;
        }

        return inc.id.equals(id);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Incident{" +
                "id=" + id);

        if(text != null){
            builder.append(", text='" + text + '\'');
        }

        builder.append(", attachmentFiles=")
                .append(attachmentFiles
                        .stream()
                        .map(AttachmentFile::getId)
                        .collect(Collectors.toList()));

        if(time != null){
            builder.append(", time=" + time);
        }

        if(location != null){
            builder.append(", location=" + location);
        }

        if(user != null){
            builder.append(", user=" + user);
        }

        builder.append(", type=" + type );

        builder.append('}');

        return builder.toString();
    }
}

