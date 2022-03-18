package com.veon.eurasia.alfabank.service;

import com.veon.eurasia.alfabank.model.dto.any2card.request.CalculateFeeRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.request.CompletePaymentRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.request.GetReportRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.request.GetStatusTransactionRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.CalculateFeeResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.CompletePaymentResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.GetBalanceResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.GetReportResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.GetStatusTransactionResponseDto;

public interface AnyToCardService {
  CalculateFeeResponseDto calculateFee(CalculateFeeRequestDto calculateFeeRequestdto);

  CompletePaymentResponseDto completePayment(CompletePaymentRequestDto completePaymentRequestDto);

  GetStatusTransactionResponseDto
      getStatusTransaction(GetStatusTransactionRequestDto getStatusTransactionRequestDto);

  GetBalanceResponseDto getBalance(String reqId);

  GetReportResponseDto getReport(GetReportRequestDto getReportRequestDto);
}
