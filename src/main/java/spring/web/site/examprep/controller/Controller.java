package spring.web.site.examprep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import spring.web.site.examprep.entity.Card;
import spring.web.site.examprep.entity.User;
import spring.web.site.examprep.service.CardService;
import spring.web.site.examprep.service.UserService;

import java.util.Optional;

@org.springframework.stereotype.Controller
@RequestMapping("/exam-card")
@EnableWebMvc
public class Controller {
    private final CardService cardService;
    private final UserService userService;


    @Autowired
    public Controller(CardService cardService, UserService userService) {
        this.cardService = cardService;
        this.userService=userService;
    }

    @GetMapping("/sign")
    public String sign(Model model){
        model.addAttribute("user", new User());
        return "sign-view";
    }

    @GetMapping("/questions")
    @PreAuthorize("hasAuthority('read')")
    public String questions(Authentication authentication,Model model){
        model.addAttribute("cards", userService
                .findUserByLogin(authentication.getName())
                .getCards());

        return "questions";
    }

    @GetMapping("/registration")
    public String registrationForm(Model model){
        model.addAttribute("user", new User());
        return "registration-view";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("user") User user){
        userService.saveUser(user);

        return "redirect:/exam-card/questions";
    }



    @GetMapping("/add-card")
    @PreAuthorize("hasAuthority('create')")
    public String getAddCardForm(Model model){
        model.addAttribute("card", new Card());

        return "add-question-view";
    }

    @PostMapping("/save-card")
    public String saveCard(@ModelAttribute("card") Card card, Authentication authentication){
        cardService.saveCard(card, userService
                .findUserByLogin(authentication.getName()));

        return "redirect:/exam-card/questions";
    }

    @GetMapping("/delete-card/{id}")
    @PreAuthorize("hasAuthority('delete_card')")
    public String deleteCard(@PathVariable(value = "id") int id){
        System.out.println(id);
        cardService.deleteCardById(id);
        System.out.println(id);
        return "redirect:/exam-card/questions";
    }

}
