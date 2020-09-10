package com.thoughtworks.capacity.gtb.mvc.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Size(min=3, max=10)
    @NotNull(message = "用户名不为空")
    @Pattern(regexp = "^/w+$", message = "用户名不合法")
    private String username;
    @Size(min=5, max=12, message = "密码不合法")
    @NotNull(message = "密码不为空")
    private String password;
    @Email(message = "邮箱地址不合法")
    private String email;
}
