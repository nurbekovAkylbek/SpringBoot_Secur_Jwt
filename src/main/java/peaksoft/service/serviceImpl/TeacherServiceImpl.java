package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dto.request.TeacherRequest;
import peaksoft.dto.response.TeacherResponse;
import peaksoft.entity.Teacher;
import peaksoft.mapper.edit.TeacherEditMapper;
import peaksoft.mapper.views.TeacherViewMapper;
import peaksoft.rpeository.TeacherRepository;
import peaksoft.service.TeacherService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherEditMapper teacherEditMapper;
    private final TeacherViewMapper teacherViewMapper;

    @Override
    @Transactional
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    @Transactional
    public TeacherResponse saveTeacher(TeacherRequest teacherRequest, Long id) {
        return teacherViewMapper.viewTeacher(teacherRepository.save(teacherEditMapper.create(teacherRequest, id)));
    }

    @Override
    @Transactional
    public TeacherResponse updateTeacher(TeacherRequest teacherRequest, Long id) {
        Teacher teacher = teacherRepository.getById(id);
        teacherEditMapper.update(teacher, teacherRequest);
        return teacherViewMapper.viewTeacher(teacherRepository.findById(id).get());
    }

    @Override
    @Transactional
    public TeacherResponse getTeacherById(Long id) {
        return teacherViewMapper.viewTeacher(teacherRepository.getById(id));
    }

    @Override
    @Transactional
    public TeacherResponse deleteTeacherById(Long id) {
        Teacher teacher = teacherRepository.getById(id);
        teacherRepository.deleteById(id);
        return teacherViewMapper.viewTeacher(teacher);
    }
}
