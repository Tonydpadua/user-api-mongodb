package com.tony.apimongodb.user.dto;

import com.tony.apimongodb.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO implements Serializable {


    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    private String id;

    @NotEmpty(message = "Name is mandatory")
    private String name;

    private String email;

    public static UserDTO from(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
