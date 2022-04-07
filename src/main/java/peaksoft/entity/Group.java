package peaksoft.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "groups")
@Getter
@Setter
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String groupName;
    private int numberOfStudents;

    @JsonIgnore
    @ManyToMany(cascade = {MERGE, DETACH, PERSIST, REFRESH}, fetch = FetchType.LAZY, mappedBy = "groups")
    private List<Course> courses;

    @OneToMany(cascade = ALL, mappedBy = "group")
    private List<Student> student;

    public void setCourse(Course course) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(course);
        course.setGroup(this);
    }
}
