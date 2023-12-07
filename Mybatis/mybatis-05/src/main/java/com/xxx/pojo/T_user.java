package com.xxx.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class T_user {
  private int id;
  private String username;
  private String pwd;
  private int member;

}
