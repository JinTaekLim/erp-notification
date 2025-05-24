package com.erp.notification.domain.owner.common.mapper;

import com.erp.notification.domain.owner.dto.PushNotificationMessage;
import org.mapstruct.Mapper;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.SseEventBuilder;

@Mapper(componentModel = "spring")
public interface OwnerSseMapper {

  default SseEventBuilder sseEventBuilder(PushNotificationMessage msg) {
    return SseEmitter.event()
        .id(msg.getId())
        .name(msg.getName())
        .data(msg.getData())
        .reconnectTime(msg.getReconnectTime())
        .comment(msg.getComment());
  };
}
