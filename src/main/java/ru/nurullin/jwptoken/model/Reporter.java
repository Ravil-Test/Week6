package ru.nurullin.jwptoken.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "reporters")
@Data
public class Reporter extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "description")
    private String description;

    @Column(name = "telnumber")
    private long telNumber;

    @Column(name = "email")
    private String email;

    @ManyToMany(mappedBy = "reporters", fetch = FetchType.EAGER)
    private List<Report> reports;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "reporter_roles",
            joinColumns = {@JoinColumn(name = "reporter_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "reporter_audience",
            joinColumns = {@JoinColumn(name = "reporter_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "audience_id", referencedColumnName = "id")})
    private List<Audience> audiences;
}
