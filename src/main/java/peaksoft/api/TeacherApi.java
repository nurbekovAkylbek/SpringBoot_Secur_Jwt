package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.TeacherRequest;
import peaksoft.dto.response.TeacherResponse;
import peaksoft.entity.Teacher;
import peaksoft.service.TeacherService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/teacher")
public class TeacherApi {

    private final TeacherService teacherService;

    @PostMapping("/save/{courseId}")
    public TeacherResponse create(@Valid @RequestBody TeacherRequest teacherRequest, @PathVariable Long courseId) {
        return teacherService.saveTeacher(teacherRequest, courseId);
    }

    @GetMapping("/getAllTeacher")
    public List<Teacher> getAllTeacher() {
        return teacherService.getAllTeacher();
    }

    @PutMapping("/update/{id}")
    public TeacherResponse updateTeacher(@PathVariable Long id, @RequestBody TeacherRequest teacherRequest) {
        return teacherService.updateTeacher(teacherRequest, id);
    }

    @GetMapping("/getById/{id}")
    public TeacherResponse getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public TeacherResponse deleteById(@PathVariable Long id) {
        return teacherService.deleteTeacherById(id);
    }
}
