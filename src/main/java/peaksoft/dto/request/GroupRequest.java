package peaksoft.dto.request;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GroupRequest {

    @NotNull
    private String groupName;
    @NotNull
    private int numberOfStudents;
}
