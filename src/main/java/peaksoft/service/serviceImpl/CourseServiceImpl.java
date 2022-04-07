package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;
import peaksoft.entity.Course;
import peaksoft.mapper.edit.CourseEditMapper;
import peaksoft.mapper.views.CourseViewMapper;
import peaksoft.rpeository.CourseRepository;
import peaksoft.service.CourseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository repository;
    private final CourseEditMapper editMapper;
    private final CourseViewMapper viewMapper;

    @Override
    @Transactional
    public List<Course> getAllCourse() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public CourseResponse saveCourse(CourseRequest courseRequest, Long id) {
        return viewMapper.viewCourse(repository.save(editMapper.create(courseRequest, id)));
    }

    @Override
    @Transactional
    public CourseResponse updateCourse(Long id, CourseRequest courseRequest) {
        Course course = repository.findById(id).get();
        editMapper.update(course, courseRequest);
        return viewMapper.viewCourse(repository.findById(id).get());
    }

    @Override
    @Transactional
    public CourseResponse getCourseById(Long id) {
        return viewMapper.viewCourse(repository.findById(id).get());
    }

    @Override
    public void deleteCourseById(Long id) {
        repository.deleteById(id);
    }
}
