package com.tony.apimongodb.user;

import com.tony.apimongodb.post.dto.PostDTO;
import com.tony.apimongodb.user.dto.UserDTO;
import com.tony.apimongodb.user.service.DeleteByIdService;
import com.tony.apimongodb.user.service.FindUserByIdService;
import com.tony.apimongodb.user.service.FindUserPostsById;
import com.tony.apimongodb.user.service.PageUsersService;
import com.tony.apimongodb.user.service.SaveUserService;
import com.tony.apimongodb.user.service.UpdateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {


    private final PageUsersService findAllUsersService;
    private final FindUserByIdService findUserByIdService;
    private final FindUserPostsById findUserPostsById;
    private final SaveUserService saveUserService;
    private final DeleteByIdService deleteByIdService;
    private final UpdateUserService updateUserService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<UserDTO> pageUsers(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        return this.findAllUsersService.pageUsers(page, linesPerPage, orderBy, direction).map(UserDTO::from);
    }

    @GetMapping(value = "/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findUserById(@PathVariable String userId) {
        return UserDTO.from(this.findUserByIdService.findById(userId));
    }

    @GetMapping(value = "/{userId}/posts")
    @ResponseStatus(HttpStatus.OK)
    public List<PostDTO> findUserPostsById(@PathVariable String userId) {
        return this.findUserPostsById.findUserPostsById(userId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody UserDTO userDTO) {
        this.saveUserService.save(User.from(userDTO));
    }

    @DeleteMapping(value = "/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable String userId) {
        this.deleteByIdService.deleteById(userId);
    }

    @PutMapping(value = "/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable String userId) {
        return this.updateUserService.updateUser(User.from(userDTO), userId);
    }
}
