package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.CourseRequest;
import peaksoft.dto.response.CourseResponse;
import peaksoft.entity.Course;
import peaksoft.service.CourseService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/course")
public class CourseApi {

    private final CourseService courseService;

    @GetMapping("/getAllCourse")
    public List<Course> getAll() {
        return courseService.getAllCourse();
    }

    @PostMapping("/add/{companyId}")
    public CourseResponse create(@RequestBody CourseRequest courseRequest, @PathVariable Long companyId) {
        return courseService.saveCourse(courseRequest, companyId);
    }

    @PutMapping("/updateById/{id}")
    public CourseResponse update(@PathVariable Long id, @RequestBody CourseRequest courseRequest) {
        return courseService.updateCourse(id, courseRequest);
    }

    @GetMapping("/getById/{id}")
    public CourseResponse getById(@PathVariable("id") Long id) {
        return courseService.getCourseById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        courseService.deleteCourseById(id);
    }
}
