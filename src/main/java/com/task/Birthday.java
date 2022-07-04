package com.task;


import com.task.advice.MyException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;

public class Birthday {
  private String baseBirthday;
  private String birthday;

  public Birthday(final String baseBirthday) {
    this.baseBirthday = baseBirthday;
  }

  public void extractBirthdayData() {
    try {
      //URLパラメータから取得したしきい値となる年月日文字列を年、月、日にわける。
      int yearData = changeLocalDateTime(this.baseBirthday).getYear();
      int monthData = changeLocalDateTime(this.baseBirthday).getMonthValue();
      int dateData = changeLocalDateTime(this.baseBirthday).getDayOfMonth();

      if (yearData < 1900 || yearData > LocalDate.now().getYear()) {
        throw new MyException(
            "年の値は1900～" + LocalDate.now().getYear() + "を入力してください");
      }
      if (monthData < 1 || monthData > 12) {
        throw new MyException("月の値は1～12を入力してください");
      }
      int endOfMonth =
          YearMonth.of(yearData, monthData).atEndOfMonth().getDayOfMonth();
      if (dateData < 1) {
        throw new MyException("日付の値は1以上を入力してください");
      } else if (dateData > endOfMonth) {
        throw new MyException(
            yearData + "年" + monthData + "月は" + endOfMonth + "日迄です。日付は"
                + endOfMonth + "以下の値を入力してください。");
      }

      LocalDate baseDate = this.changeLocalDateTime(this.baseBirthday);

      String generateDate = this.generateRandomDate();
      LocalDate s = this.changeLocalDateTime(generateDate);

      //発生させた生年月日がURLリクエストの閾値以降なら発生させた生年月日を返す。閾値未満なら下記メッセージを返す。
      if (this.changeLocalDateTime(generateDate).compareTo(baseDate) < 0) {
        throw new MyException("該当のデータがありませんでした。");
      }

      this.birthday = generateDate;


    } catch (NumberFormatException | DateTimeParseException
             | StringIndexOutOfBoundsException e) {
      throw new MyException("年月日の入力に誤りがあります。「yyyy-mm-dd」の形式で入力してください。");
    }
  }

  private LocalDate changeLocalDateTime(String stringDateData) {
    return LocalDate.parse(stringDateData,
        DateTimeFormatter.ofPattern("yyyy-MM-dd"));
  }

  private String generateRandomDate() {
    //ランダムの年月日を生成するメソッド。範囲は1900年からシステム年
    Random rand = new Random();
    int rangeOfYear = LocalDate.now().getYear() - 1900;
    int generateYear = rand.nextInt(rangeOfYear) + 1900;

    int generateMonth = rand.nextInt(12) + 1;

    int endOfMonth =
        YearMonth.of(generateYear, generateMonth).atEndOfMonth()
            .getDayOfMonth();
    int generateDay = rand.nextInt(endOfMonth) + 1;

    String generateDate =
        generateYear + "-" +
            String.format("%02d", generateMonth).replace(" ", "0") + "-" +
            String.format("%02d", generateDay).replace(" ", "0");

    return generateDate;
  }


  public String getBirthday() {
    return birthday;
  }

//  @Override
//  public String toString() {
//    return this.birthdayData[this.i];
//  }
}
