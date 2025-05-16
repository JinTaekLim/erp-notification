package com.erp.notification.domain.owner.controller;

import com.erp.notification.domain.owner.service.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequestMapping("/notification/owner")
@RequiredArgsConstructor
public class OwnerController {

  private final OwnerService ownerService;

  @GetMapping("/connect/{instituteId}")
  public SseEmitter connect(@PathVariable String instituteId) {
    return ownerService.connect(instituteId);
  }

  // note. 테스트용 | 이후 제거 예정
  @PostMapping("/send")
  public void send(String instituteId, String message) {
    ownerService.send(instituteId, message);
  }
}
