package com.erp.notification.domain.auth.command.mapper;

import com.erp.notification.domain.auth.command.dto.AuthCacheDto;
import com.erp.notification.domain.auth.command.dto.CreateAuthRequest;
import com.erp.notification.domain.auth.command.dto.CreateAuthResponse;
import java.util.UUID;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthMapper {

  // 인증 정보 생성
  AuthCacheDto createAuthToDto(CreateAuthRequest req);
  CreateAuthResponse createAuthToResponse(UUID authKey);
}
