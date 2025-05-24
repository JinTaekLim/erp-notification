package com.erp.notification.config.rabbitMq;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class RabbitMqConfigValues {

  private final String createAuthName;
  private final String createAuthExchange;

  private final String pushNotificationName;
  private final String pushNotificationExchange;

  public RabbitMqConfigValues(RabbitMqProperties rabbitMqProperties) {
    this.createAuthName = rabbitMqProperties.getQueues().get(0).getName().getFirst();
    this.createAuthExchange = rabbitMqProperties.getQueues().get(0).getExchange();

    this.pushNotificationName = rabbitMqProperties.getQueues().get(1).getName().getFirst();
    this.pushNotificationExchange = rabbitMqProperties.getQueues().get(1).getExchange();


  }

}
