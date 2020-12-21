package ru.mvc.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mvc.forms.UserForm;

import javax.persistence.*;
import java.util.List;
/**
 * 20.12.2020
 * User
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "seller")
    private List<Product> products;


    public static User from(UserForm form) {
        return User.builder()
                .login(form.getLogin())
                .password(form.getPassword())
                .build();
    }
}
