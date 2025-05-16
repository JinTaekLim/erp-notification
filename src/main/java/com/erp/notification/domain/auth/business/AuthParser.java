package com.erp.notification.domain.auth.business;

import com.erp.notification.domain.auth.command.dto.AuthCacheDto;
import com.erp.notification.domain.auth.command.dto.CreateAuthRequest;
import com.erp.notification.domain.auth.command.dto.CreateAuthResponse;
import com.erp.notification.domain.auth.command.mapper.AuthMapper;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthParser {

  private final AuthMapper authMapper;

  public AuthCacheDto createAuthToDto(CreateAuthRequest req) {
    return authMapper.createAuthToDto(req);
  };

  public CreateAuthResponse createAuthToResponse(UUID uuid) {
    return authMapper.createAuthToResponse(uuid);
  };

}
