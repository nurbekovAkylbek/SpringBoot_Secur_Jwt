package peaksoft.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupResponse {

    private Long id;
    private String groupName;
    private int numberOfStudents;
}
