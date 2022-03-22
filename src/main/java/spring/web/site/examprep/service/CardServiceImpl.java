package spring.web.site.examprep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.web.site.examprep.dao.CardDAO;
import spring.web.site.examprep.dao.UserDAO;
import spring.web.site.examprep.entity.Card;
import spring.web.site.examprep.entity.User;

@Service
public class CardServiceImpl implements CardService{
    private final UserDAO userDAO;
    private final CardDAO cardDAO;

    @Autowired
    public CardServiceImpl(UserDAO userDAO, CardDAO cardDAO) {
        this.userDAO = userDAO;
        this.cardDAO = cardDAO;
    }

    @Override
    public void saveCard(Card card, User user) {

        card.setUser(user);
        cardDAO.saveAndFlush(card);

    }

    @Override
    public void deleteCardById(int id) {
        Card card= cardDAO.getById(id);
        cardDAO.delete(card);
    }
}
