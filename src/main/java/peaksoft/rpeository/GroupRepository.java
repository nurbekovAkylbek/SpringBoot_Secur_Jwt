package peaksoft.rpeository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}
