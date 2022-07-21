package com.task;


import com.task.advice.MyException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Birthday {
  private String Birthday;
  private String userBirthday;

  public Birthday(final String userBirthday) {
    this.userBirthday = userBirthday;
  }

  public void extractBirthdayData() {
    try {
      //URLパラメータから取得したユーザーの生年月日文字列を年を取得
      int yearData = changeLocalDateTime(this.userBirthday).getYear();

      //指定年未満は例外を発生
      if (yearData < 1900) {
        throw new MyException(
            "年の値は1900～" + LocalDate.now().getYear() + "を入力してください");
      }
      //システム年以降は下記の例外を発生
      if (changeLocalDateTime(this.userBirthday).isAfter(LocalDate.now())) {
        throw new MyException("未来の日付は入力できません。");
      }

    } catch (DateTimeParseException e) {
      //存在しない年月日が入力された時
      throw new MyException("年月日の入力に誤りがあります。「yyyy-mm-dd」の形式で実在する日付を入力してください");
    }
  }

  private LocalDate changeLocalDateTime(String stringDateData) {
    return LocalDate.parse(stringDateData,
        DateTimeFormatter.ofPattern("uuuu-MM-dd")
            .withResolverStyle(
                ResolverStyle.STRICT)); //厳密性を設定しないと2/31等がに2/28に丸まる。STRICTの場合、yyyyでは例外発生。
  }

  public String getBirthday() {
    return userBirthday;
  }

}
