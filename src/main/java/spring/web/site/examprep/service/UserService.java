package spring.web.site.examprep.service;

import spring.web.site.examprep.entity.User;

public interface UserService {
    public void saveUser(User user);
    public User findUserByLogin(String login);
//    public void addCard(Card card, Authentication authentication);
//    public User getUser(Authentication authentication);
}
