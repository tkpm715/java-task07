package com.task.controller;

import com.task.Birthday;
import com.task.Name;
import com.task.UserData;
import com.task.form.CreateForm;
import com.task.form.UpdateForm;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class CrudController {

  @GetMapping("/names")
  public List<UserData> read() {

    UserData[] UserData = new UserData[5];
    UserData[0] = new UserData("tanaka", "1990/05/10");
    UserData[1] = new UserData("suzuki", "2000/08/20");

    List<UserData> list = new ArrayList<>();

    list.add(UserData[0]);
    list.add(UserData[1]);

    return list;
  }

  @GetMapping("/names/{base-birthday}")
  public List<UserData> readBirthday(
      @PathVariable("base-birthday") String baseBirthday) {
    UserData[] userData = new UserData[5];

    List<UserData> list = new ArrayList<>();

    //URLパラメータから受け取った年月の文字列baseBirthday以降のオブジェクトだけを取得表示
       for (int i = 0; i < 5; i++) {
        Birthday birthdayCheck =
            new Birthday(i, baseBirthday );

        if (birthdayCheck.dateCheck()) {
          Birthday birthday = new Birthday(i, "");
          Name name = new Name(i);
          userData[i] = new UserData(name.toString(), birthday.toString());
          list.add(userData[i]);
        }
      }
      return list;
  }


  @PostMapping("/names")
  public ResponseEntity<String> create(@RequestBody CreateForm createForm) {

    URI url = UriComponentsBuilder.fromUriString("http://localhost:8080")
        .path("/names/id")
        .build()
        .toUri();

    return ResponseEntity.created(url).body("successfully created");
  }

  @PatchMapping("/names/{id}")
  public ResponseEntity<Map<String, String>> update(@PathVariable("id") int id,
                                                    @RequestBody
                                                    UpdateForm updateForm) {


    return ResponseEntity.ok(Map.of("message", "successfully updated"));
  }

  @DeleteMapping("/names")
  public ResponseEntity<Map<String, String>> delete() {

    return ResponseEntity.ok(Map.of("message", "successfully delete"));

  }

}
