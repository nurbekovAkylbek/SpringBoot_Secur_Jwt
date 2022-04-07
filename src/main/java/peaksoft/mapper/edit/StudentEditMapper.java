package peaksoft.mapper.edit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import peaksoft.dto.request.StudentRequest;
import peaksoft.entity.Student;
import peaksoft.rpeository.GroupRepository;

@Component
@RequiredArgsConstructor
public class StudentEditMapper {

    private final GroupRepository groupRepository;

    public Student create(StudentRequest studentRequest, Long id) {
        if (studentRequest == null) {
            return null;
        }

        Student student = new Student();
        student.setFullName(studentRequest.getFullName());
        student.setAge(studentRequest.getAge());
        student.setGroup(groupRepository.getById(id));
        return student;
    }

    public void update(Student student, StudentRequest studentRequest) {
        student.setFullName(studentRequest.getFullName());
        student.setAge(studentRequest.getAge());
    }
}
