package ru.nurullin.jwptoken.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "spectators")
@Data
public class Spectator extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "telnumber")
    private long telNumber;

    @Column(name = "email")
    private String email;

    @ManyToOne
    private Audience audiences;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "spectator_roles",
            joinColumns = {@JoinColumn(name = "spectator_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;
}
