package com.xxx.pojo;

import org.apache.ibatis.type.Alias;

/**
 * @ClassName T_user
 * @Description TODO
 * @Author yefeng
 * @Date 2021/4/8 12:28
 * @Version 1.0
 */

public class T_user {
  private int id;
  private String username;
  private String pwd;
  private int member;

  public T_user() {
  }

  @Override
  public String toString() {
    return "T_user{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", pwd='" + pwd + '\'' +
            ", member=" + member +
            '}';
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public int getMember() {
    return member;
  }

  public void setMember(int member) {
    this.member = member;
  }

  public T_user(int id, String username, String pwd, int member) {
    this.id = id;
    this.username = username;
    this.pwd = pwd;
    this.member = member;
  }
}
