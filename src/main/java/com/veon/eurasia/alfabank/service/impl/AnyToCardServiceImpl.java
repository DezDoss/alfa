package com.veon.eurasia.alfabank.service.impl;

import com.veon.eurasia.alfabank.mapper.AnyToCardMapper;
import com.veon.eurasia.alfabank.model.dto.any2card.request.CalculateFeeRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.request.CompletePaymentRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.request.GetStatusTransactionRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.CalculateFeeResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.CompletePaymentResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.GetStatusTransactionResponseDto;
import com.veon.eurasia.alfabank.model.enums.TransactionStatus;
import com.veon.eurasia.alfabank.model.request.any2card.*;
import com.veon.eurasia.alfabank.client.AnyToCardClientService;
import com.veon.eurasia.alfabank.service.AnyToCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AnyToCardServiceImpl implements AnyToCardService {

  private final AnyToCardClientService anyToCardQueryService;
  private final AnyToCardMapper anyToCardMapper;

  public CalculateFeeResponseDto calculateFee(CalculateFeeRequestDto calculateFeeRequestDto) {

    var calculateFeeRequest = anyToCardMapper.toCalculateFeeRequest(calculateFeeRequestDto);

    var operationResult = anyToCardQueryService.calculateFee(calculateFeeRequest);
    if (operationResult.getCode() != TransactionStatus.SUCCESS.getCode()) {
      return anyToCardMapper.toCalculateFeeResponseDto(operationResult.getCode(),
              operationResult.getMessage(), TransactionStatus
                      .findTransactionFromStatusCode(operationResult.getCode()));
    }

    return anyToCardMapper.toCalculateFeeResponseDto(operationResult.getResponse(), TransactionStatus.SUCCESS);
  }

  @Override
  public CompletePaymentResponseDto completePayment(CompletePaymentRequestDto completePaymentRequestDto) {
    var completePaymentRequest = anyToCardMapper.toCompletePaymentRequest(completePaymentRequestDto);

    var operationResult = anyToCardQueryService.completePayment(completePaymentRequest);

    if(operationResult.getCode() != TransactionStatus.SUCCESS.getCode()) {
      return anyToCardMapper.toCompletePaymentResponseDto(operationResult.getCode(),
              operationResult.getMessage(), TransactionStatus.findTransactionFromStatusCode(operationResult.getCode()));
    }

    return anyToCardMapper.toCompletePaymentResponseDto(operationResult.getResponse(), TransactionStatus.SUCCESS);
  }

  @Override
  public GetStatusTransactionResponseDto getStatusTransaction(GetStatusTransactionRequestDto getStatusTransactionRequestDto) {
//    var request = anyToCardMapper.toGetStatusTransactionRequest(getStatusTransactionRequestDto);
//
//    var operationResult = anyToCardQueryService.getStatusTransaction(request);
//
//    return anyToCardMapper.toGetStatusTransactionResponseDto(operationResult.getResponse(), TransactionStatus.SUCCESS);

    return null;
  }

  @Override
  public void getBalance(GetBalanceRequest getBalanceRequest) {

  }

  @Override
  public void getReport(GetReportRequest getReportRequest) {

  }
}
