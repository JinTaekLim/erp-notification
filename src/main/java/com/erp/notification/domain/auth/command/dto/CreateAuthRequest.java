package com.erp.notification.domain.auth.command.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateAuthRequest {

  private Long instituteId;
  private Long accountId;

}
