package com.erp.notification.domain.auth.support;

import java.util.UUID;

public class AuthFactory {

  private final String PREFIX = "AUTH:";

  public String getKey(UUID uuid) {
    return PREFIX + uuid;
  }

}
