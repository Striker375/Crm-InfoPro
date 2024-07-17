package crm.crm.repository;

import crm.crm.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByUsername(String username);
}