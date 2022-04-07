package peaksoft.mapper.edit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import peaksoft.dto.request.GroupRequest;
import peaksoft.entity.Course;
import peaksoft.entity.Group;

@Component
@RequiredArgsConstructor
public class GroupEditMapper {

    public Group create(GroupRequest groupRequest, Course id) {
        if (groupRequest == null) {
            return null;
        }

        Group group = new Group();
        group.setGroupName(groupRequest.getGroupName());
        group.setNumberOfStudents(groupRequest.getNumberOfStudents());
        group.setCourse(id);
        return group;

    }

    public void update(Group group, GroupRequest groupRequest) {
        group.setGroupName(groupRequest.getGroupName());
        group.setNumberOfStudents(groupRequest.getNumberOfStudents());
    }
}
