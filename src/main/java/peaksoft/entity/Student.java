package peaksoft.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;

@Entity
@Table(name = "students")
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private int age;

    @JsonIgnore
    @ManyToOne(cascade = {PERSIST, REFRESH, DETACH, MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

}
