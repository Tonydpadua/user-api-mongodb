package com.tony.apimongodb.user.service;

import com.tony.apimongodb.user.User;
import com.tony.apimongodb.user.UserBuilder;
import com.tony.apimongodb.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Tag("service")
@DisplayName("Validate create a user")
class SaveUserServiceTest {

    @Mock
    private UserRepository userRepository;

    private SaveUserService saveUserService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        this.saveUserService = new SaveUserServiceImpl(this.userRepository);
    }

    @Test
    @DisplayName("Create a user")
    void createUserWithSuccess() {
        User user  = UserBuilder.createUser().build();

        when(this.userRepository.save(any(User.class)))
                .thenReturn(user);
        this.saveUserService.save(user);

        ArgumentCaptor<User> argumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(this.userRepository).save(argumentCaptor.capture());

        User createdUser = argumentCaptor.getValue();

        assertEquals("12345", createdUser.getId());
        assertEquals("User 1", createdUser.getName());
        assertEquals("user@email.com", createdUser.getEmail());
    }
}
