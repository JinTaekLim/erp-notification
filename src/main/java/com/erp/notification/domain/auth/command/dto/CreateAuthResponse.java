package com.erp.notification.domain.auth.command.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateAuthResponse {

  private String authKey;

}
