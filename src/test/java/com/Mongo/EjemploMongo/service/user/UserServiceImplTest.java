package com.Mongo.EjemploMongo.service.user;

import com.Mongo.EjemploMongo.dto.UserDto;
import com.Mongo.EjemploMongo.model.User;
import com.Mongo.EjemploMongo.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        userService = new UserServiceImpl(userRepository);
    }

    @Test
    public void find_all_users() {
        List<User> userListMock = new ArrayList<>();
        userListMock.add(new User("user1", "user1@gmail.com", "123s"));
        userListMock.add(new User("user2", "user2@gmail.com", "154s"));
        userListMock.add(new User("user3", "user3@gmail.com", "187s"));

        Mockito.when(userRepository.findAll()).thenReturn(userListMock);

        List<User> userListResult = userService.findAll();

        List<User> userListExpected = new ArrayList<>();
        userListExpected.add(new User("user1", "user1@gmail.com", "123s"));
        userListExpected.add(new User("user2", "user2@gmail.com", "154s"));
        userListExpected.add(new User("user3", "user3@gmail.com", "187s"));


        Assertions.assertEquals(userListExpected, userListResult);

    }

    @Test
    public void find_user_by_id(){
        User userMock = new User("user","user@gmail.com","ada123");
        Mockito.when(userRepository.findById("ada123")).thenReturn(userMock);
        User userResult = userService.findById("ada123");
        User userExpected = new User("user","user@gmail.com","ada123");

        Assertions.assertEquals(userExpected, userResult);
    }
    @Test
        public void create_user(){
            UserDto userInput = new UserDto("user1","user1@gmail.com","sebas123");
            User userMock = new User(userInput);
            Mockito.when(userRepository.create(Mockito.any(UserDto.class)))
                    .thenReturn(userMock);

            UserDto userInput2 = new UserDto("user2","user2@gmail.com","sebas123");

            User userResult = userService.create(userInput2);
            User userExpected = new User("user1","user1@gmail.com","sebas123");

            Assertions.assertTrue(userResult.getEmail().equals("user1@gmail.com"));


    }




}