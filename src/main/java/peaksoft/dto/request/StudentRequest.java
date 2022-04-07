package peaksoft.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class StudentRequest {

    @NotNull
    private String fullName;
    @NotNull
    private int age;


}
