package ru.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mvc.models.User;

import java.util.List;

/**
 * 20.12.2020
 * UsersRepository
 *
 * @author Sherstobitov Mikhail
 * @version v1.0
 */
public interface UsersRepository extends JpaRepository<User, Long> {
    List<User> findAllByLogin(String login);
    List<User> findAllByLoginAndPassword(String login,String password);
}
