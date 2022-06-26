package com.task;

public class UserData {

  private String name;

  private String birthday;

  public UserData(final String name, final String birthday) {
    this.name = name;
    this.birthday = birthday;
  }

  public String getName() {
    return name;
  }

  public String getBirthday() {
    return birthday;
  }
}
