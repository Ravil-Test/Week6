package ru.nurullin.jwptoken.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reports")
@Data
public class Report extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private Date date;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "report_audience",
            joinColumns = {@JoinColumn(name = "report_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "audience_id", referencedColumnName = "id")})
    private List<Audience> audiences;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "report_reporter",
            joinColumns = {@JoinColumn(name = "report_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "reporter_id", referencedColumnName = "id")})
    private List<Reporter> reporters;
}
