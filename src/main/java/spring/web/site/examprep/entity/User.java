package spring.web.site.examprep.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column( name ="login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = Role.class)
    @JoinColumn(name = "role_id")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(cascade = CascadeType.ALL,
               mappedBy = "user",
               fetch = FetchType.EAGER)
    private List<Card> cards;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + login + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", role=" + role +
                ", cards=" + cards +
                '}';
    }
}
