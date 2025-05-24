package com.erp.notification.domain.owner.listener;

import com.erp.notification.config.rabbitMq.RabbitMqConfigValues;
import com.erp.notification.domain.owner.dto.PushNotificationMessage;
import com.erp.notification.domain.owner.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class OwnerListener {

  private final RabbitMqConfigValues rabbitMqConfigValues;
  private final OwnerService ownerService;

  @RabbitListener(queues = "#{rabbitMqConfigValues.pushNotificationName}")
  public void pushNotification(@Payload PushNotificationMessage msg) {
    ownerService.send(msg);
  }
}
