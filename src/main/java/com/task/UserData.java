package com.task;

public class UserData {

  private String name;

  private String birthday;

  public UserData(String name, String birthday) {
    this.setName(name);
    this.setBirthday(birthday);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }
}
