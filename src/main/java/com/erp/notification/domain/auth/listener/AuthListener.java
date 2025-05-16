package com.erp.notification.domain.auth.listener;

import com.erp.notification.domain.auth.command.dto.CreateAuthRequest;
import com.erp.notification.domain.auth.command.dto.CreateAuthResponse;
import com.erp.notification.domain.auth.service.AuthService;
import com.erp.notification.util.ObjectMapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuthListener {

  private final AuthService authService;

  @RabbitListener(queues = "notification.create-auth")
  public String createAuth(@Payload CreateAuthRequest req) {
    CreateAuthResponse response = authService.createAuth(req);
    return ObjectMapperUtil.toJson(response);
  }

}
