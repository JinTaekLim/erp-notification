package com.erp.notification.domain.auth.business;

import com.erp.notification.domain.auth.command.dto.AuthCacheDto;
import com.erp.notification.domain.cache.CacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthCacheManager {

  private final long EXPIRE_SECONDS = 30L;

  private final CacheRepository<AuthCacheDto> cacheRepository;

  public void save(String key, AuthCacheDto authCacheDto) {
    cacheRepository.save(key, authCacheDto);
  }
}
