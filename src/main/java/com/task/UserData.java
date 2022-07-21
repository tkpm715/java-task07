package com.task;

public class UserData {

  private String name;
  private String birthday;

  public UserData(final String name, final String birthday) {
    this.name = name;

    Birthday validBirthday = new Birthday(birthday);
    validBirthday.extractBirthdayData();

    this.birthday = validBirthday.getBirthday();
  }

  public String getName() {
    return name;
  }

  public String getBirthday() {
    return birthday;
  }
}
