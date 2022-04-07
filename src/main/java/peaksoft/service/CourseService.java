package peaksoft.service;

import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;
import peaksoft.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourse();

    CourseResponse saveCourse(CourseRequest courseRequest, Long id);

    CourseResponse updateCourse(Long id, CourseRequest courseRequest);

    CourseResponse getCourseById(Long id);

    void deleteCourseById(Long id);

}
