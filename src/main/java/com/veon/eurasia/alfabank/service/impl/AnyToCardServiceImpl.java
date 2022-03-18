package com.veon.eurasia.alfabank.service.impl;

import com.veon.eurasia.alfabank.client.AnyToCardClient;
import com.veon.eurasia.alfabank.enums.TransactionStatus;
import com.veon.eurasia.alfabank.mapper.AnyToCardMapper;
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
import com.veon.eurasia.alfabank.utils.CardUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AnyToCardServiceImpl implements AnyToCardService {

  private final AnyToCardClient anyToCardClient;
  private final AnyToCardMapper anyToCardMapper;

  public CalculateFeeResponseDto calculateFee(CalculateFeeRequestDto calculateFeeRequestDto) {

    var calculateFeeRequest =
            anyToCardMapper.toCalculateFeeRequest(calculateFeeRequestDto);

    if (log.isDebugEnabled()) {
      log.debug("calulateFeeRequest : [reqId: {}, pan : {}, currency: {}, amount: {}]",
              calculateFeeRequest.getReqId(),
              CardUtils.getMaskedPan(calculateFeeRequest.getCardDestinationPan()),
              calculateFeeRequest.getCurrencyId(), calculateFeeRequest.getAmount());
    }

    var responseObject =
            anyToCardClient.calculateFee(calculateFeeRequest);
    if (responseObject.getCode() != TransactionStatus.SUCCESS.getCode()) {
      return anyToCardMapper
              .toCalculateFeeResponseDto(responseObject.getCode(),
              responseObject.getMessage(),
              TransactionStatus.findTransactionFromStatusCode(responseObject.getCode()));
    }

    return anyToCardMapper
            .toCalculateFeeResponseDto(responseObject.getResponse(),
                    TransactionStatus.SUCCESS);
  }

  @Override
  public CompletePaymentResponseDto
      completePayment(CompletePaymentRequestDto completePaymentRequestDto) {
    var completePaymentRequest =
            anyToCardMapper.toCompletePaymentRequest(completePaymentRequestDto);

    if (log.isDebugEnabled()) {
      log.debug("completePaymentRequest: [{}]", completePaymentRequest);
    }
    
    var responseObject =
            anyToCardClient.completePayment(completePaymentRequest);

    if (responseObject.getCode() != TransactionStatus.SUCCESS.getCode()) {
      var transactionStatus = getStatusTransaction(
              new GetStatusTransactionRequestDto(
                      completePaymentRequest.getReqId(),
                      completePaymentRequest.getSessionCode()));

      return anyToCardMapper.toCompletePaymentResponseDto(transactionStatus.getStatusCode(),
              transactionStatus.getMessage(),
              TransactionStatus.findTransactionFromStatusCode(transactionStatus.getStatusCode()));
    }
    return anyToCardMapper
            .toCompletePaymentResponseDto(responseObject.getResponse(),
                    TransactionStatus.SUCCESS);
  }

  @Override
  public GetStatusTransactionResponseDto
      getStatusTransaction(GetStatusTransactionRequestDto getStatusTransactionRequestDto) {
    var request =
            anyToCardMapper.toGetStatusTransactionRequest(getStatusTransactionRequestDto);

    if (log.isDebugEnabled()) {
      log.debug("statusTransactionRequest : [{}]", request);
    }

    var responseObject = anyToCardClient.getStatusTransaction(request);

    if (responseObject.getCode() != TransactionStatus.SUCCESS.getCode()) {
      return anyToCardMapper.toGetStatusTransactionResponseDto(
              responseObject.getCode(), responseObject.getMessage(),
              TransactionStatus.findTransactionFromStatusCode(responseObject.getCode()),
              null, null);
    }

    return anyToCardMapper.toGetStatusTransactionResponseDto(responseObject.getCode(),
            null, TransactionStatus.findTransactionFromStatusCode(
                    responseObject.getResponse().getStatus()),
            responseObject.getResponse().getReqidrp().getValue(),
            responseObject.getResponse().getSessioncoderp().getValue());
  }

  @Override
  public GetBalanceResponseDto getBalance(String reqId) {
    var request = anyToCardMapper.toGetBalanceRequest(reqId);

    if (log.isDebugEnabled()) {
      log.debug("getBalanceRequest : [{}]", request);
    }

    var result = anyToCardClient.getBalance(request);
    if (result.getCode() != TransactionStatus.SUCCESS.getCode()) {
      return anyToCardMapper.toGetBalanceResponseDto(result.getCode(),
                result.getMessage(), TransactionStatus
                        .findTransactionFromStatusCode(result.getCode()));
    }

    return anyToCardMapper.toGetBalanceResponseDto(result.getResponse(),
              TransactionStatus.SUCCESS);
  }

  @Override
  public GetReportResponseDto getReport(GetReportRequestDto getReportRequestDto) {
    var request = anyToCardMapper.toGetReportRequest(getReportRequestDto);

    if (log.isDebugEnabled()) {
      log.info("getReportRequest : [{}]", request);
    }

    var result = anyToCardClient.getReport(request);

    if (result.getCode() != TransactionStatus.SUCCESS.getCode()) {
      return anyToCardMapper.toGetReportResponseDto(
              result.getCode(), result.getMessage(),
              TransactionStatus.findTransactionFromStatusCode(result.getCode())
      );
    }

    return anyToCardMapper
            .toGetReportResponseDto(result.getResponse(), TransactionStatus.SUCCESS);
  }
}
