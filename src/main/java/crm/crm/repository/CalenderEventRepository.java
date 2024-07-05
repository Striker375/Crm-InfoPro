package crm.crm.repository;

import crm.crm.entity.CalenderEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalenderEventRepository extends JpaRepository<CalenderEvent, Long> {
}
