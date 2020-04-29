package org.telegram.bot.beldtp.api.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

@Entity
@Table(name = "user")
public class User {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private UserRole role;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private Set<Incident> incident = new HashSet<>();

    private Language language;

    @Lob
    private Stack<String> status = new Stack<>();


    public User() {

    }

    public void add(Incident incident) {
        this.incident.add(incident);
    }

    public void remove(Incident incdt) {
        this.incident.removeIf(incident -> incdt.getId().equals(incident.getId()));
    }

    public String peekStatus() {
        return status.peek();
    }

    public void popStatus() {
        status.pop();
    }

    public void pushStatus(String string) {
        status.push(string);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Set<Incident> getIncident() {
        return incident;
    }

    public void setIncident(Set<Incident> incident) {
        this.incident = incident;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Stack<String> getStatus() {
        return status;
    }

    public void setStatus(Stack<String> status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", role=" + role +
                ", incident=" + incident.stream().map(Incident::getId).collect(Collectors.toList()) +
                ", language=" + language +
                ", status=" + status +
                '}';
    }
}
