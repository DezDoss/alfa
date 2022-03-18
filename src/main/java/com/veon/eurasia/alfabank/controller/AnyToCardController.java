package com.veon.eurasia.alfabank.controller;

import com.veon.eurasia.alfabank.model.dto.any2card.request.CalculateFeeRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.request.CompletePaymentRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.request.GetReportRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.request.GetStatusTransactionRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.CalculateFeeResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.CompletePaymentResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.GetBalanceResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.GetReportResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.GetStatusTransactionResponseDto;
import com.veon.eurasia.alfabank.service.AnyToCardService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/any2card")
public class AnyToCardController {

  private final AnyToCardService service;

  @GetMapping("/check")
  public CalculateFeeResponseDto
      calculateFee(@Valid @RequestBody CalculateFeeRequestDto requestDto) {
    return service.calculateFee(requestDto);
  }

  @GetMapping("/complete")
  public CompletePaymentResponseDto
      completePayment(@Valid @RequestBody CompletePaymentRequestDto completePaymentRequestDto) {
    return service.completePayment(completePaymentRequestDto);
  }

  @GetMapping("/status")
  public GetStatusTransactionResponseDto
      getTransactionStatus(@Valid @RequestBody
                                 GetStatusTransactionRequestDto getStatusTransactionRequestDto) {
    return service.getStatusTransaction(getStatusTransactionRequestDto);
  }

  @GetMapping("/balance/{reqId}")
  public GetBalanceResponseDto getBalance(@PathVariable("reqId") String reqId) {
    return service.getBalance(reqId);
  }

  @GetMapping("/report")
  public GetReportResponseDto
      getReport(@Valid @RequestBody GetReportRequestDto reportRequestDto) {
    return service.getReport(reportRequestDto);
  }
}
