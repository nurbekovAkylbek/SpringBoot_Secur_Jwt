package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dto.request.GroupRequest;
import peaksoft.dto.response.GroupResponse;
import peaksoft.entity.Course;
import peaksoft.entity.Group;
import peaksoft.mapper.edit.GroupEditMapper;
import peaksoft.mapper.views.GroupViewMapper;
import peaksoft.rpeository.CourseRepository;
import peaksoft.rpeository.GroupRepository;
import peaksoft.service.GroupService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private final GroupEditMapper groupEditMapper;
    private final GroupViewMapper groupViewMapper;
    private final CourseRepository courseRepository;

    @Override
    @Transactional
    public List<Group> getAllGroup() {
        return groupRepository.findAll();
    }

    @Override
    @Transactional
    public GroupResponse saveGroup(GroupRequest groupRequest, Long id) {
        Course course = courseRepository.getById(id);
        return groupViewMapper.viewGroup(groupRepository.save(groupEditMapper.create(groupRequest, course)));
    }

    @Override
    @Transactional
    public GroupResponse updateGroup(Long id, GroupRequest groupRequest) {
        Group group = groupRepository.getById(id);
        groupEditMapper.update(group, groupRequest);
        return groupViewMapper.viewGroup(groupRepository.findById(id).get());
    }

    @Override
    @Transactional
    public GroupResponse getGroupById(Long id) {
        return groupViewMapper.viewGroup(groupRepository.findById(id).get());
    }

    @Override
    @Transactional
    public void deleteGroupById(Long id) {
        groupRepository.deleteById(id);

    }
}
