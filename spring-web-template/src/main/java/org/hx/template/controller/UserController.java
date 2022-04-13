package org.hx.template.controller;

import org.hx.template.bean.User;
import org.hx.template.bean.UserDTO;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/user")
public class UserController extends BaseController {


  @PutMapping("/{id}")
  public HttpResult<UserDTO> updateUser(@PathVariable("id") Integer id, @Valid @RequestBody UserDTO userDTO) throws Exception {
    System.out.println("ID");
    return responseOK(UserDTO.convert(new User()));
  }
}
