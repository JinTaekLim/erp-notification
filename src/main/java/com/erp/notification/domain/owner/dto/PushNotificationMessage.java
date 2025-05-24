package com.erp.notification.domain.owner.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PushNotificationMessage {

  private Long instituteId;

  private String id;
  private String name;
  private String data;
  private long reconnectTime;
  private String comment;

}
