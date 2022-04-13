package com.hx.json.service;

import com.alibaba.fastjson.JSON;
import lombok.Data;

/**
 * Json
 *
 * @author 35762
 */
@Data
public class MyJsonService {


  private String name;

  public String objectToJson(Object obj) {
    return name + "@" + JSON.toJSONString(obj);
  }
}
