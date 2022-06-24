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

    UserData[] UserData = new UserData[2];
    UserData[0] = new UserData("tanaka", "1990/5/10");
    UserData[1] = new UserData("suzuki", "2000/8/20");

    List<UserData> list = new ArrayList<>();

    list.add(UserData[0]);
    list.add(UserData[1]);

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
                                                    @RequestBody UpdateForm updateForm) {


    return ResponseEntity.ok(Map.of("message", "successfully updated"));
  }

  @DeleteMapping("/names")
  public ResponseEntity<Map<String, String>> delete() {

    return ResponseEntity.ok(Map.of("message", "successfully delete"));

  }

}
