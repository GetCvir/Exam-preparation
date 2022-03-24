package spring.web.site.examprep.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cards")
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;

    @Column(name="question")
    private String question;

    @Column(name = "answer")
    private String answer;

<<<<<<< Updated upstream
    @ManyToOne(cascade = CascadeType.ALL)
=======
    @ManyToOne(cascade = {CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.REFRESH})
>>>>>>> Stashed changes
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String toString() {
        return "Card{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", answer='" + answer + "}";
    }
}
