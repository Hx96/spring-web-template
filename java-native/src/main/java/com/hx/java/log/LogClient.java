package com.hx.java.log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
/**
 * appender 进行自由设置
 */
public class LogClient {
    public static void main(String[] args) {
        log.info("i am info");
        log.error("i am error");
        log.warn("i am warn");
        log.debug("i am debug");
    }
}
