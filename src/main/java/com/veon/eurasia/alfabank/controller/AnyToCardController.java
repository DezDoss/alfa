package com.veon.eurasia.alfabank.controller;

import com.veon.eurasia.alfabank.model.dto.any2card.request.CalculateFeeRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.request.CompletePaymentRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.CalculateFeeResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.CompletePaymentResponseDto;
import com.veon.eurasia.alfabank.service.AnyToCardService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/any2card")
public class AnyToCardController {

  private final AnyToCardService service;

  @SneakyThrows
  @GetMapping("/check")
  public CalculateFeeResponseDto check(@Valid @RequestBody CalculateFeeRequestDto requestDto) {
        return service.calculateFee(requestDto);
  }

  @GetMapping("/complete")
  public CompletePaymentResponseDto completePayment(@Valid @RequestBody CompletePaymentRequestDto completePaymentRequestDto) {
    return service.completePayment(completePaymentRequestDto);
  }
}
