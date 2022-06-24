package com.task;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Birthday {
  private String birthday;
  private String baseBirthday;


  public Birthday(final String birthday, final String baseBirthday) {
    this.birthday = birthday;
    this.baseBirthday = baseBirthday;
  }

  public boolean dateCheck() {
    LocalDate date = LocalDate.parse(this.birthday,
        DateTimeFormatter.ofPattern("yyyy/MM/dd"));
    LocalDate baseDate = LocalDate.parse(this.baseBirthday,
        DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    return date.compareTo(baseDate) >= 0;
  }

//  @Override
//  public String toString(){
//    return birthday;
//  }

}
