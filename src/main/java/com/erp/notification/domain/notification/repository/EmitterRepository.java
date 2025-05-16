package com.erp.notification.domain.notification.repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Repository
@RequiredArgsConstructor
public class EmitterRepository {

  private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();

  public void save(String id, SseEmitter emitter) {
    emitters.put(id, emitter);
  }

  public Optional<SseEmitter> findById(String userId) {
    return Optional.ofNullable(emitters.get(userId));
  }
}