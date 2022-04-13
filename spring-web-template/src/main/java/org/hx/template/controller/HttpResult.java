package org.hx.template.controller;


import lombok.Data;

@Data
public class HttpResult<T> {
  private boolean success;
  private Object data;
  private Integer code;
  private String message;
}
