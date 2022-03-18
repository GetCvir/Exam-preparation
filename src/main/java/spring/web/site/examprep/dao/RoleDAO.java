package spring.web.site.examprep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.web.site.examprep.entity.Role;

public interface RoleDAO extends JpaRepository<Role, Integer> {
}
