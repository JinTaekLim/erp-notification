package com.erp.notification.domain.owner.support;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public class OwnerSseFactory {

  private final long TIMEOUT = Long.MAX_VALUE;
  private final String PREFIX = "OWNER:";

  public String getKey(String id) {
    return PREFIX + id;
  }

  public SseEmitter getEmitter() {
    return new SseEmitter(TIMEOUT);
  }
}
