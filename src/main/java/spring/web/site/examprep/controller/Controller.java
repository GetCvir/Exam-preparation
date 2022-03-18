package spring.web.site.examprep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import spring.web.site.examprep.entity.Card;
import spring.web.site.examprep.entity.User;
import spring.web.site.examprep.service.QuestionsService;
import spring.web.site.examprep.service.UserService;

@org.springframework.stereotype.Controller
@RequestMapping("/exam-card")
@EnableWebMvc
public class Controller {
    private final QuestionsService questionsService;
    private final UserService userService;

    @Autowired
    public Controller(QuestionsService questionsService, UserService userService) {
        this.questionsService = questionsService;
        this.userService=userService;
    }

    @GetMapping("/sign-in")
    public String sign(Model model){
        System.out.println("sign");
        model.addAttribute("user", User.class);
        return "sign-view";
    }


    @GetMapping("/registration")
    public String registrationForm(Model model){
        model.addAttribute("user", new User());
        return "registration-view";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") User user){
        userService.saveUser(user);

        return "redirect:/questions";
    }

    @GetMapping("/questions")
    @PreAuthorize("hasAuthority('read')")
    public String questions(@ModelAttribute("user") User user){

        return "questions";
    }

    @GetMapping("/add-question")
    public String getAddCardForm(Model model){
        model.addAttribute("card", new Card());
        return "add-question-view";
    }

}
