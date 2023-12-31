package by.clevertec.testwork.repository;

import by.clevertec.testwork.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    User findByLogin(String login);
}
