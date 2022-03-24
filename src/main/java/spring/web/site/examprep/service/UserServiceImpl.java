package spring.web.site.examprep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.web.site.examprep.dao.RoleDAO;
import spring.web.site.examprep.dao.UserDAO;
import spring.web.site.examprep.entity.*;

@Service
public class UserServiceImpl implements UserService{
    private final UserDAO userDAO;
    private final RoleDAO roleDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    @Override
    public void saveUser(User user) {
//        User user=userDAO.getById(4);
//        Card card = new Card("2+2?", "4", user);
//        List<Card> cardList =new ArrayList<>(user.getCards());
//
//        cardList.add(card);
//
//        user.setCards(cardList);
//
//        userDAO.saveAndFlush(user);

        Role role=roleDAO.getById(1);
        user.setRole(role);
        user.setStatus(Status.ACTIVE);

        userDAO.saveAndFlush(user);

        System.out.println(user);
    }

    @Override
    public User findUserByLogin(String login) {
        return userDAO.findUserByLogin(login);
    }
    
//
//    public User getUser(Authentication authentication){
//        return findUserByLogin(
//                authentication.getName()).orElseThrow(
//                () ->new UsernameNotFoundException("User does not exist."));
//    }
}
