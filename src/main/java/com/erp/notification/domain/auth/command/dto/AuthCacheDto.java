package com.erp.notification.domain.auth.command.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthCacheDto {

  private Long instituteId;
  private Long accountId;
  private LocalDateTime createTime;

}
