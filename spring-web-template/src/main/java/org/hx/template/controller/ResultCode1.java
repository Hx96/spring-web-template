package org.hx.template.controller;

public enum ResultCode1 {
  SUCCESS(200, "成功"), FAILED_CODE(400, "失败");
  // 成员变量
  private int code;
  private String message;

  public Integer getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  // 构造方法
  private ResultCode1(int code, String message) {
    this.code = code;
    this.message = message;
  }

  //覆盖方法
  @Override
  public String toString() {
    return this.code + "_" + this.message;
  }
}
