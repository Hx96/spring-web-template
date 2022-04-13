package org.hx.myjson.controller;

import com.hx.json.service.MyJsonService;
import org.hx.myjson.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * controller
 * @author 35762
 */
@RestController
public class JsonRestController {

  @Autowired
  MyJsonService myJsonService;

  @GetMapping
  public String getJsonString(){
    User hx = new User().setName("hx").setId(222);
    return myJsonService.objectToJson(hx);
  }
}
