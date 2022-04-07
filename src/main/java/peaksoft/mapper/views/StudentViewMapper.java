package peaksoft.mapper.views;

import org.springframework.stereotype.Component;
import peaksoft.dto.response.StudentResponse;
import peaksoft.entity.Student;

@Component
public class StudentViewMapper {

    public StudentResponse viewStudent(Student student) {
        if (student == null) {
            return null;
        }

        StudentResponse studentResponse = new StudentResponse();
        if (student.getId() != null) {
            studentResponse.setId(student.getId());
        }

        studentResponse.setFullName(student.getFullName());
        studentResponse.setAge(student.getAge());
        System.out.println("Student ViewMapper");
        return studentResponse;
    }
}
