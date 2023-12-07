package com.xxx.pojo;

/**
 * @ClassName T_user
 * @Description TODO
 * @Author yefeng
 * @Date 2021/4/8 12:28
 * @Version 1.0
 */

public class T_user {
  private int id;
  private String userName;
  private String password;
  private int member;

  public T_user() {
  }

  public T_user(int id, String userName, String password, int member) {
    this.id = id;
    this.userName = userName;
    this.password = password;
    this.member = member;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getMember() {
    return member;
  }

  public void setMember(int member) {
    this.member = member;
  }

  @Override
  public String toString() {
    return "T_user{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", password='" + password + '\'' +
            ", member=" + member +
            '}';
  }
}
