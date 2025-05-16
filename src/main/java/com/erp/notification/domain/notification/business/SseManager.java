package com.erp.notification.domain.notification.business;

import com.erp.notification.domain.notification.repository.EmitterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
@RequiredArgsConstructor
public class SseManager {

  private final EmitterRepository emitterRepository;

  public SseEmitter getOrSave(String id, SseEmitter emitter) {
    return emitterRepository.findById(id).orElseGet(() -> {
      emitterRepository.save(id, emitter);
      return emitter;
    });
  }

  public SseEmitter findById(String id) {
    return emitterRepository.findById(id).orElseThrow(
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
}
