package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.GroupRequest;
import peaksoft.dto.response.GroupResponse;
import peaksoft.entity.Group;
import peaksoft.service.GroupService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/group")
public class GroupApi {

    private final GroupService groupService;

    @PostMapping("/save/{teacherId}")
    public GroupResponse create(@Valid @RequestBody GroupRequest group, @PathVariable Long teacherId) {
        return groupService.saveGroup(group, teacherId);
    }

    @GetMapping("/getAllGroup")
    public List<Group> getAllGroup() {
        return groupService.getAllGroup();
    }

    @PutMapping("/update/{id}")
    public GroupResponse updateGroup(@PathVariable Long id, @RequestBody GroupRequest groupRequest) {
        return groupService.updateGroup(id, groupRequest);
    }

    @GetMapping("/getById/{id}")
    public GroupResponse getById(@PathVariable Long id) {
        return groupService.getGroupById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        groupService.deleteGroupById(id);
    }
}
