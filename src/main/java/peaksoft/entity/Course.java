package peaksoft.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    private int duration;

    @JsonIgnore
    @ManyToOne(cascade = {PERSIST, REFRESH, DETACH, MERGE})
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(cascade = {PERSIST, REFRESH, DETACH, REMOVE, MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "groups_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id"))
    private List<Group> groups;

    @OneToOne(cascade = ALL, mappedBy = "course", fetch = FetchType.LAZY)
    private Teacher teacher;


    public void setGroup(Group group) {
        if (groups == null) {
            groups = new ArrayList<>();
        }
        groups.add(group);
    }
}
