package peaksoft.mapper.edit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import peaksoft.dto.request.TeacherRequest;
import peaksoft.entity.Teacher;
import peaksoft.rpeository.CourseRepository;

@Component
@RequiredArgsConstructor
public class TeacherEditMapper {

    private final CourseRepository courseRepository;

    public Teacher create(TeacherRequest teacherRequest, Long id) {
        if (teacherRequest == null) {
            return null;
        }

        Teacher teacher = new Teacher();
        teacher.setTeacherName(teacherRequest.getTeacherName());
        teacher.setAge(teacherRequest.getAge());
        teacher.setCourse(courseRepository.findById(id).get());
        return teacher;
    }

    public void update(Teacher teacher, TeacherRequest teacherRequest) {
        teacher.setTeacherName(teacherRequest.getTeacherName());
        teacher.setAge(teacherRequest.getAge());
    }
}
