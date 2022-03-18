package spring.web.site.examprep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.web.site.examprep.entity.User;

import java.util.Optional;

public interface UserDAO extends JpaRepository<User, Integer> {
    public Optional<User> findUserByLogin(String login);
}
