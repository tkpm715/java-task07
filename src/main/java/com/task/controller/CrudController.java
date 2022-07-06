package com.task.controller;

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

    UserData[] userData = new UserData[5];
    userData[0] = new UserData("tanaka", "1990/05/10");
    userData[1] = new UserData("suzuki", "2000/08/20");

    List<UserData> userList = new ArrayList<>();

    userList.add(userData[0]);
    userList.add(userData[1]);

    return userList;
  }

  @GetMapping("/names/{user-birthday}/{user-name}")
  public UserData readBirthday(
      @PathVariable("user-birthday") String userBirthday,
      @PathVariable("user-name") String userName) {

    UserData userData = new UserData(userName, userBirthday);

    return userData;
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
