package org.hx.template.controller;

/**
 * @author 35762
 */

public enum ResultCode {
  /**
   * www
   */
  SUCCESS(200, "成功"),
  SYSTEM_ERROR(400, "失败"),
  MISTYPE_PARAM(400, "失败"),
  MISSING_PARAM(400, "失败"),
  UNSUPPORTED_METHOD(400, "失败"),
  INVALID_PARAM(201, "");
  private Integer code;
  private String message;

  ResultCode(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }

  //覆盖方法
  @Override
  public String toString() {
    return this.code + "_" + this.message;
  }
}
