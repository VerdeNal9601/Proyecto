package com.Mongo.EjemploMongo.controller;

import com.Mongo.EjemploMongo.dto.UserDto;
import com.Mongo.EjemploMongo.model.User;
import com.Mongo.EjemploMongo.service.user.UserService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class UserControllerTest {


    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;


    @Test
    @Order(1)
    public void get_all_status200 (){

        List<User> userListMock = new ArrayList<>();
        userListMock.add(new User("user1", "user1@gmail.com", "123s"));
        userListMock.add(new User("user2", "user2@gmail.com", "154s"));
        userListMock.add(new User("user3", "user3@gmail.com", "187s"));

        Mockito.when(userService.findAll()).thenReturn(userListMock);

        ResponseEntity<List<User>> listUserController = userController.getAll();

        Assertions.assertEquals(200, listUserController.getStatusCodeValue());

    }


    @Test
    @Order(3)
    public void find_by_id_200(){

        User userMockito = new User( "user1","user@gmail.com","sebas123");
        Mockito.when(userService.findById(Mockito.anyString())).thenReturn(userMockito);

        ResponseEntity<User> userResult = userController.findById("sdrw");
        Assertions.assertEquals(200,userResult.getStatusCodeValue());
    }

    @Test
    @Order(4)
    public void update_user(){

        UserDto userMockito = new UserDto( "user1","user@gmail.com","sebas123");
        User userMockitoUpdate = new User(userMockito);
        Mockito.when(userService.update("1",userMockito)).thenReturn(userMockitoUpdate);

        ResponseEntity<User> userResponseEntity  =  userController.updateUser("1", userMockito);
        Assertions.assertEquals(200,userResponseEntity.getStatusCodeValue());
        Assertions.assertTrue(userResponseEntity.getBody() != null);
    }





}