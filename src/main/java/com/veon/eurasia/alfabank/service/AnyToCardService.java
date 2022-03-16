package com.veon.eurasia.alfabank.service;

import com.veon.eurasia.alfabank.model.dto.any2card.request.CalculateFeeRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.request.CompletePaymentRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.request.GetStatusTransactionRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.CalculateFeeResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.CompletePaymentResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.GetStatusTransactionResponseDto;
import com.veon.eurasia.alfabank.model.request.any2card.*;

public interface AnyToCardService {
  CalculateFeeResponseDto calculateFee(CalculateFeeRequestDto calculateFeeRequestdto);

  CompletePaymentResponseDto completePayment(CompletePaymentRequestDto completePaymentRequestDto);

  GetStatusTransactionResponseDto getStatusTransaction(GetStatusTransactionRequestDto getStatusTransactionRequestDto);

  void getBalance(GetBalanceRequest getBalanceRequest);

  void getReport(GetReportRequest getReportRequest);
}
