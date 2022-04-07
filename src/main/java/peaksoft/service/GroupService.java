package peaksoft.service;

import peaksoft.dto.request.GroupRequest;
import peaksoft.dto.response.GroupResponse;
import peaksoft.entity.Group;

import java.util.List;

public interface GroupService {

    List<Group> getAllGroup();

    GroupResponse saveGroup(GroupRequest groupRequest, Long id);

    GroupResponse updateGroup(Long id, GroupRequest groupRequest);

    GroupResponse getGroupById(Long id);

    void deleteGroupById(Long id);


}
