package com.erp.notification.domain.owner.business;

import com.erp.notification.domain.notification.business.SseManager;
import com.erp.notification.domain.owner.support.OwnerSseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Component
@RequiredArgsConstructor
public class OwnerSseManager {

  private final SseManager sseManager;
  private final OwnerSseFactory ownerSseFactory = new OwnerSseFactory();


  public SseEmitter getOrSave(String id) {
    String key = ownerSseFactory.getKey(id);
    SseEmitter emitter = ownerSseFactory.getEmitter();
    return sseManager.getOrSave(key, emitter);
  }

  public void send(String id, String message) {
    String key = ownerSseFactory.getKey(id);
    SseEmitter emitter = sseManager.findById(key);
    sseManager.send(emitter, message);
  }

}
