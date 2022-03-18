package spring.web.site.examprep.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.web.site.examprep.entity.Card;

public interface QuestionRepository extends JpaRepository<Card, Integer> {
}
