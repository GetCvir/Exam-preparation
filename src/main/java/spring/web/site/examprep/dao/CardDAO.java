package spring.web.site.examprep.dao;

import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.web.site.examprep.entity.Card;
import spring.web.site.examprep.service.CardService;

import java.util.List;

public interface CardDAO extends JpaRepository<Card, Integer> {
    public List<Card> findAllByUser_Id(int id);
}
