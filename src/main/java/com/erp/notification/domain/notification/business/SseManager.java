package com.erp.notification.domain.notification.business;

import com.erp.notification.domain.cache.CacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.SseEventBuilder;

@Component
@RequiredArgsConstructor
public class SseManager {

  private final CacheRepository<SseEmitter> cacheRepository;

  public SseEmitter getOrSave(String id, SseEmitter emitter) {
    return cacheRepository.get(id).orElseGet(() -> {
      cacheRepository.save(id, emitter);
      return emitter;
    });
  }

  public SseEmitter findById(String id) {
    return cacheRepository.get(id).orElseThrow(
        () -> new RuntimeException("잘못된 연결 요청입니다.")
    );
  }

  public void send(SseEmitter emitter, String message) {
    try {
      emitter.send(message);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public void send(SseEmitter emitter, SseEventBuilder message) {
    try {
      emitter.send(message);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
