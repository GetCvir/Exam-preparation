package spring.web.site.examprep.service;

import spring.web.site.examprep.entity.Card;
import spring.web.site.examprep.entity.User;

public interface CardService {
    Card getCardById(int id);
    public void saveCard(Card card, User user);
    void deleteCardById(int id);
}
