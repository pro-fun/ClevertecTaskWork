//package by.clevertec.testwork.repository;
//
//
//import by.clevertec.testwork.model.User;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.test.context.ContextConfiguration;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
//import java.util.Optional;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.is;
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataMongoTest
//@Testcontainers
//@ContextConfiguration(classes = MongoDBTestContainerConfig.class)
//class UserRepositoryTest {
//
//    @Autowired
//    MongoTemplate mongoTemplate;
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Test
//    void givenUserExists_whenFindByLogin_thenGetUser() {
//        User user = new User();
//        user.setLogin("user11");
//        user.setPassword("password11");
//        mongoTemplate.save(user);
//
//        Optional<User> user1 = Optional.ofNullable(userRepository.findByLogin("user11"));
//        assertTrue(user1.isPresent());
//        assertThat(user1.get().getLogin(), is("user11"));
//        assertThat(user1.get().getPassword(), is("password11"));
//    }
//
//    @Test
//    void givenNonExistingUser_whenFindByLogin_thenReturnNotPresent(){
//        Optional<User> user = Optional.ofNullable(userRepository.findByLogin("notExistingLogin"));
//        assertTrue(user.isEmpty());
//    }
//}