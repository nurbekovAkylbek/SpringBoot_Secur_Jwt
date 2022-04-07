package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.StudentResponse;
import peaksoft.entity.Student;
import peaksoft.mapper.edit.StudentEditMapper;
import peaksoft.mapper.views.StudentViewMapper;
import peaksoft.rpeository.StudentRepository;
import peaksoft.service.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentEditMapper studentEditMapper;
    private final StudentViewMapper studentViewMapper;

    @Override
    @Transactional
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public StudentResponse saveStudent(StudentRequest studentRequest, Long id) {
        return studentViewMapper.viewStudent(studentRepository.save(studentEditMapper.create(studentRequest, id)));
    }

    @Override
    @Transactional
    public StudentResponse updateStudent(StudentRequest studentRequest, Long id) {
        Student student = studentRepository.getById(id);
        studentEditMapper.update(student, studentRequest);
        return studentViewMapper.viewStudent(studentRepository.findById(id).get());
    }

    @Override
    @Transactional
    public StudentResponse getStudentById(Long id) {
        return studentViewMapper.viewStudent(studentRepository.findById(id).get());
    }

    @Override
    @Transactional
    public StudentResponse deleteStudentById(Long id) {
        Student student = studentRepository.getById(id);
        studentRepository.deleteById(id);
        return studentViewMapper.viewStudent(student);
    }
}
