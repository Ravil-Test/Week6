package ru.nurullin.jwptoken.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "audiences")
@Data
public class Audience extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "audiences")
    private List<Spectator> spectators;

    @ManyToMany(mappedBy = "audiences", fetch = FetchType.EAGER)
    private List<Report> reports;

    @ManyToMany(mappedBy = "audiences", fetch = FetchType.EAGER)
    private List<Reporter> reporters;
}
