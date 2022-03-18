package spring.web.site.examprep.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.web.site.examprep.dao.UserDAO;

@Service
public class QuestionServiceImpl implements QuestionsService{
    private UserDAO userDAO;

    @Autowired
    public QuestionServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void saveQuestion() {

    }
}
