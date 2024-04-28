package com.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
public class User {
    private long id;
    private String username;
    private String nickname;
    private String password;
    private String email;
    private String avatar;
    private int type;
    private LocalDate createTime;
    private LocalDate updateTime;

}
