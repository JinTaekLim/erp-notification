package com.erp.notification.domain.auth.service;

import com.erp.notification.domain.auth.business.AuthCacheManager;
import com.erp.notification.domain.auth.business.AuthParser;
import com.erp.notification.domain.auth.command.dto.AuthCacheDto;
import com.erp.notification.domain.auth.command.dto.CreateAuthRequest;
import com.erp.notification.domain.auth.command.dto.CreateAuthResponse;
import com.erp.notification.domain.auth.support.AuthFactory;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

  private final AuthCacheManager authCacheManager;
  private final AuthParser authParser;

  private final AuthFactory authFactory = new AuthFactory();

  public CreateAuthResponse createAuth(CreateAuthRequest req) {

    AuthCacheDto authCacheDto = authParser.createAuthToDto(req);

    UUID uuid = UUID.randomUUID();
    String key = authFactory.getKey(uuid);
    authCacheManager.save(key, authCacheDto);

    return authParser.createAuthToResponse(uuid);
  }
}
