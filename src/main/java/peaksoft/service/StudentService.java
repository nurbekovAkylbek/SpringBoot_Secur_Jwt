package peaksoft.service;

import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.StudentResponse;
import peaksoft.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudent();

    StudentResponse saveStudent(StudentRequest studentRequest, Long id);

    StudentResponse updateStudent(StudentRequest studentRequest, Long id);

    StudentResponse getStudentById(Long id);

    StudentResponse deleteStudentById(Long id);
}
