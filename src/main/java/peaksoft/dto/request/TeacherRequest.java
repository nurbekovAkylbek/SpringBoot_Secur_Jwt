package peaksoft.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TeacherRequest {

    @NotNull
    private String teacherName;
    @NotNull
    private int age;
}
