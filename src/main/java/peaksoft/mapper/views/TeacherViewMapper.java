package peaksoft.mapper.views;

import org.springframework.stereotype.Component;
import peaksoft.dto.response.TeacherResponse;
import peaksoft.entity.Teacher;

@Component
public class TeacherViewMapper {

    public TeacherResponse viewTeacher(Teacher teacher) {
        if (teacher == null) {
            return null;
        }

        TeacherResponse teacherResponse = new TeacherResponse();
        if (teacher.getId() != null) {
            teacherResponse.setId(teacher.getId());
        }

        teacherResponse.setTeacherName(teacher.getTeacherName());
        teacherResponse.setAge(teacher.getAge());
        return teacherResponse;
    }
}
