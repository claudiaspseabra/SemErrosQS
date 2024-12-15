package com.example.qsproject.qsproject;

import com.example.qsproject.qsproject.Implementation.UserImpl;
import com.example.qsproject.qsproject.dtos.UsersDto;
import com.example.qsproject.qsproject.repositories.UsersRespository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.List;
import java.util.Optional;


public class UserImplTest {

    @Mock
    private UsersRespository usersRespository;

    @InjectMocks
    private UserImpl userImpl;

    private User user;
    private UsersDto usersDto;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setName("Test User");
        user.setUsername("testuser");
        user.setPassword("password123");
        user.setAdmin(false);
        usersDto = new UsersDto();
        usersDto.setName("Test User");
        usersDto.setUsername("testuser");
        usersDto.setPassword("password123");
        usersDto.setAdmin(false);
    }

    @Test
    public void testCreateUser() {
        when(usersRespository.save(any(User.class))).thenReturn(new User(1L, "Test User", "password123", "testuser", true));
        UsersDto result = userImpl.createUser(usersDto);

        assertNotNull(result);
        assertEquals(1L, result.getUserId());
        assertEquals("testuser", result.getUsername());
        assertEquals("Test User", result.getName());
    }


    @Test
    public void testDeleteUserById() {
        when(usersRespository.findById(1L)).thenReturn(Optional.of(user));
        UsersDto result = userImpl.deleteUserById(1L);

        assertNotNull(result);
        assertEquals(user.getUserId(), result.getUserId());
    }

    @Test
    public void testGetAllUsers() {
        when(usersRespository.findAll()).thenReturn(List.of(user));
        List<UsersDto> result = userImpl.getAllUsers();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(user.getUserId(), result.get(0).getUserId());
    }

    @Test
    public void testUpdateUser() {
        UsersDto updatedUsersDto = new UsersDto();
        updatedUsersDto.setUserId(1L);
        updatedUsersDto.setName("Updated Name");
        updatedUsersDto.setUsername("updateduser");
        updatedUsersDto.setPassword("newpassword");
        updatedUsersDto.setAdmin(true);
        when(usersRespository.findById(1L)).thenReturn(Optional.of(user));
        when(usersRespository.save(any(User.class))).thenReturn(user);
        UsersDto result = userImpl.updateUser(1L, updatedUsersDto);

        assertNotNull(result);
        assertEquals(updatedUsersDto.getName(), result.getName());
        assertEquals(updatedUsersDto.getUsername(), result.getUsername());
        assertEquals(updatedUsersDto.getPassword(), result.getPassword());
        assertTrue(result.isAdmin());
    }

    @Test
    public void testValidateUser_ValidUser() {
        when(usersRespository.findByUsername("testuser")).thenReturn(user);
        User result = userImpl.validateUser("testuser", "password123");
        assertNotNull(result);
        assertEquals(user.getUsername(), result.getUsername());
    }
}
