package peaksoft.mapper.views;

import org.springframework.stereotype.Component;
import peaksoft.dto.response.GroupResponse;
import peaksoft.entity.Group;

@Component
public class GroupViewMapper {

    public GroupResponse viewGroup(Group group) {
        if (group == null) {
            return null;
        }

        GroupResponse groupResponse = new GroupResponse();
        if (group.getId() != null) {
            groupResponse.setId(group.getId());
        }

        groupResponse.setGroupName(group.getGroupName());
        groupResponse.setNumberOfStudents(group.getNumberOfStudents());
        System.out.println("Group ViewMapper ");
        return groupResponse;
    }
}
