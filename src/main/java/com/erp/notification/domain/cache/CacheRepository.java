package com.erp.notification.domain.cache;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;

@Component
public class CacheRepository<T> {

  private final Map<String, T> map = new ConcurrentHashMap<>();

  public void save(String key, T value) {
    map.put(key, value);
  }

  public Optional<T> get(String key) {
    return Optional.ofNullable(map.get(key));
  }

  public void delete(String key) {
    map.remove(key);
  }
}
