package peaksoft.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CourseRequest {

    @NotNull
    private String courseName;
    @NotNull
    private int duration;

}
