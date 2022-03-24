package spring.web.site.examprep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
<<<<<<< Updated upstream:src/main/java/spring/web/site/examprep/controller/Controller.java
=======
import org.springframework.security.core.Authentication;
>>>>>>> Stashed changes:src/main/java/spring/web/site/examprep/controller/UserController.java
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
<<<<<<< Updated upstream:src/main/java/spring/web/site/examprep/controller/Controller.java
public class Controller {
    private final QuestionsService questionsService;
=======
public class UserController {
    private final CardService cardService;
>>>>>>> Stashed changes:src/main/java/spring/web/site/examprep/controller/UserController.java
    private final UserService userService;

    @Autowired
<<<<<<< Updated upstream:src/main/java/spring/web/site/examprep/controller/Controller.java
    public Controller(QuestionsService questionsService, UserService userService) {
        this.questionsService = questionsService;
=======
    public UserController(CardService cardService, UserService userService) {
        this.cardService = cardService;
>>>>>>> Stashed changes:src/main/java/spring/web/site/examprep/controller/UserController.java
        this.userService=userService;
    }

    @GetMapping("/sign-in")
    public String sign(Model model){
        System.out.println("sign");
        model.addAttribute("user", User.class);
        return "sign-view";
    }

<<<<<<< Updated upstream:src/main/java/spring/web/site/examprep/controller/Controller.java

=======
>>>>>>> Stashed changes:src/main/java/spring/web/site/examprep/controller/UserController.java
    @GetMapping("/registration")
    public String registrationForm(Model model){
        model.addAttribute("user", new User());
        return "registration-view";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") User user){
        userService.saveUser(user);

<<<<<<< Updated upstream:src/main/java/spring/web/site/examprep/controller/Controller.java
        return "redirect:/questions";
    }

    @GetMapping("/questions")
    @PreAuthorize("hasAuthority('read')")
    public String questions(@ModelAttribute("user") User user){

        return "questions";
    }

    @GetMapping("/add-question")
=======
        return "redirect:/exam-card/cards";
    }

    @GetMapping("/add-card")
    @PreAuthorize("hasAuthority('create')")
>>>>>>> Stashed changes:src/main/java/spring/web/site/examprep/controller/UserController.java
    public String getAddCardForm(Model model){
        model.addAttribute("card", new Card());
        return "add-question-view";
    }

<<<<<<< Updated upstream:src/main/java/spring/web/site/examprep/controller/Controller.java
=======
    @GetMapping("/cards")
    @PreAuthorize("hasAuthority('read')")
    public String questions(Authentication authentication,Model model){
        model.addAttribute("cards",
                userService
                        .findUserByLogin(authentication.getName())
                        .getCards());

        return "cards";
    }

    @GetMapping("/card/{id}")
    @PreAuthorize("hasAuthority('read')")
    public String card(@PathVariable("id") int id, Model model){
        model.addAttribute("card", cardService.getCardById(id));
        return "card-view";
    }

    @PostMapping("/save-card")
    public String saveCard(@ModelAttribute("card") Card card, Authentication authentication){
        cardService.saveCard(card, userService
                .findUserByLogin(authentication.getName()));

        return "redirect:/exam-card/cards";
    }

    @GetMapping("delete-card/{id}")
    @PreAuthorize("hasAuthority('delete_card')")
    public String deleteCard(@PathVariable(value = "id") int id){
        cardService.deleteCardById(id);
        return "redirect:/exam-card/cards";
    }

    @GetMapping("/update-card/{id}")
    @PreAuthorize("hasAuthority('update')")
    public String updateCardForm(@PathVariable("id")int id, Model model){
        Card card=cardService.getCardById(id);
        model.addAttribute("card", card);
        return "update-card-view";
    }

    @PostMapping("/update-card")
    public String updateCard(Card card){
        cardService.saveCard(card, card.getUser());
        return "redirect:/exam-card/cards";
    }

>>>>>>> Stashed changes:src/main/java/spring/web/site/examprep/controller/UserController.java
}
