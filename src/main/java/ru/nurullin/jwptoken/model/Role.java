package ru.nurullin.jwptoken.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "roles")
@Data
public class Role extends BaseModel {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<Reporter> reporters;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<Spectator> spectators;
}
