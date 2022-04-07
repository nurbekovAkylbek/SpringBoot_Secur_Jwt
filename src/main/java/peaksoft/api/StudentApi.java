package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.StudentRequest;
import peaksoft.dto.response.StudentResponse;
import peaksoft.entity.Student;
import peaksoft.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentApi {

    private final StudentService studentService;

    @PostMapping("/save/{groupId}")
    public StudentResponse save(@Valid @PathVariable Long groupId, @RequestBody StudentRequest studentRequest) {
        return studentService.saveStudent(studentRequest, groupId);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @PutMapping("/updateById/{id}")
    public StudentResponse updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(studentRequest, id);
    }

    @GetMapping("/getById/{id}")
    public StudentResponse getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/deleteById/{id}")
    public StudentResponse deleteById(@PathVariable Long id) {
        return studentService.deleteStudentById(id);
    }
}
