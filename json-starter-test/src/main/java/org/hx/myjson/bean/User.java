package org.hx.myjson.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * User
 * @author 35762
 */
@Data
@Accessors(chain = true)
public class User {
  int id;
  String name;
}
