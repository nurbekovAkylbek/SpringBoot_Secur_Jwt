package peaksoft.mapper.edit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import peaksoft.dto.request.CourseRequest;
import peaksoft.entity.Course;
import peaksoft.rpeository.CompanyRepository;

@Component
@RequiredArgsConstructor
public class CourseEditMapper {

    private final CompanyRepository companyRepository;

    public Course create(CourseRequest courseRequest, Long id) {
        if (courseRequest == null) {
            return null;
        }

        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
        course.setCompany(companyRepository.findById(id).get());
        return course;
    }

    public void update(Course course, CourseRequest courseRequest) {
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
    }
}
