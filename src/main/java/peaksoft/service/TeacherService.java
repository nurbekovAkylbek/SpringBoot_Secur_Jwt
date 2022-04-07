package peaksoft.service;

import peaksoft.dto.request.TeacherRequest;
import peaksoft.dto.response.TeacherResponse;
import peaksoft.entity.Teacher;

import java.util.List;

public interface TeacherService {

    List<Teacher> getAllTeacher();

    TeacherResponse saveTeacher(TeacherRequest teacherRequest, Long id);

    TeacherResponse updateTeacher(TeacherRequest teacherRequest, Long id);

    TeacherResponse getTeacherById(Long id);

    TeacherResponse deleteTeacherById(Long id);
}
