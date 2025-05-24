package com.erp.notification.domain.owner.service;

import com.erp.notification.domain.owner.business.OwnerSseManager;
import com.erp.notification.domain.owner.dto.PushNotificationMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Service
@RequiredArgsConstructor
public class OwnerService {

  private final OwnerSseManager ownerSseManager;

  public SseEmitter connect(String id) {
    return ownerSseManager.getOrSave(id);
  }

  public void send(String id, String message) {
    ownerSseManager.send(id, message);
  }

  public void send(PushNotificationMessage msg) {
    ownerSseManager.send(msg);
  }

}
