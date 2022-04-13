package org.hx.template.bean;

import org.springframework.beans.BeanUtils;
import org.springframework.util.Assert;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class UserDTO {

  private Integer id;

  @NotNull(message = "name不能为空")
  private String name;

  private String gender;

  private String genderDesc;

  private Date createdTime;

  public static UserDTO convert(User user) {
    Assert.notNull(user, "user不能为空");
    UserDTO dto = new UserDTO();
    BeanUtils.copyProperties(user, dto);
    return dto;
  }
//getter and setter
}
