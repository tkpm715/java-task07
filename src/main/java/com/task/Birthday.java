package com.task;


import com.task.advice.MyException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Birthday {
  private String baseBirthday;
  private String birthdayData[];
  private int i;


  public Birthday(final int i, final String baseBirthday) {

    this.i = i;
    this.baseBirthday = baseBirthday;

    this.birthdayData = new String[5];
    this.birthdayData[0] = "1990-05-10";
    this.birthdayData[1] = "2000-08-20";
    this.birthdayData[2] = "1995-03-05";
    this.birthdayData[3] = "2005-10-05";
    this.birthdayData[4] = "2003-02-12";
  }

  public boolean dateCheck() {

    try {
      //URLパラメータから取得したしきい値となる年月日文字列を年、月、日にわける。
      int checkYear = Integer.parseInt(this.baseBirthday.substring(0, 4));
      int checkMonth = Integer.parseInt(this.baseBirthday.substring(5, 7));
      int checkDate = Integer.parseInt(this.baseBirthday.substring(8, 10));

      if (checkYear < 1) {
        throw new MyException("年の値は1～9999を入力してください");
      }
      if (checkMonth < 1 || checkMonth > 12) {
        throw new MyException("月の値は1～12を入力してください");
      }
      int endOfMonth =
          YearMonth.of(checkYear, checkMonth).atEndOfMonth().getDayOfMonth();
      if (checkDate < 1) {
        throw new MyException("日付の値は1以上を入力してください");
      } else if (checkDate > endOfMonth) {
        throw new MyException(
            checkYear + "年" + checkMonth + "月は" + endOfMonth + "日迄です。日付は"
                + endOfMonth + "以下の値を入力してください。");
      }

      LocalDate date = LocalDate.parse(this.birthdayData[this.i],
          DateTimeFormatter.ofPattern("yyyy-MM-dd"));
      LocalDate baseDate = LocalDate.parse(this.baseBirthday,
          DateTimeFormatter.ofPattern("yyyy-MM-dd"));

      return date.compareTo(baseDate) >= 0;

    } catch (NumberFormatException | DateTimeParseException
             | StringIndexOutOfBoundsException e) {
      throw new MyException("年月日の入力に誤りがあります。「yyyy-mm-dd」の形式で入力してください。");
    }
  }

  @Override
  public String toString() {
    return this.birthdayData[this.i];
  }

}
