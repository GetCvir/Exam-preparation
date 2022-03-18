package spring.web.site.examprep.entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;

import javax.persistence.*;

@Entity
@Table(name = "details")
@Data
public class Role {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Roles role;

}
