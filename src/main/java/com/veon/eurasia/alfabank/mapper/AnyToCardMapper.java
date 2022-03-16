package com.veon.eurasia.alfabank.mapper;

import com.veon.eurasia.alfabank.model.dto.any2card.request.CalculateFeeRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.request.CompletePaymentRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.request.GetStatusTransactionRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.CalculateFeeResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.CompletePaymentResponseDto;
import com.veon.eurasia.alfabank.model.enums.TransactionStatus;
import com.veon.eurasia.alfabank.model.request.any2card.CalculateFeeRequest;
import com.veon.eurasia.alfabank.model.request.any2card.CompletePaymentRequest;
import com.veon.eurasia.alfabank.model.request.any2card.GetStatusTransactionRequest;
import org.datacontract.schemas._2004._07.p2pserver.CalculatedFeeResponce;
import org.datacontract.schemas._2004._07.p2pserver.CompletePaymentResponce;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring", uses = {ConverterMapper.class})
public interface AnyToCardMapper{
    //CalculateFee
    CalculateFeeRequest toCalculateFeeRequest(
            CalculateFeeRequestDto calculateFeeRequestDto);

    CalculateFeeResponseDto toCalculateFeeResponseDto(
            CalculatedFeeResponce calculatedFeeResponce,
            TransactionStatus status);

    CalculateFeeResponseDto toCalculateFeeResponseDto(
            Integer statusCode, String message,
            Optional<TransactionStatus> status);

    //CompletePayment
    CompletePaymentRequest toCompletePaymentRequest(
            CompletePaymentRequestDto completePaymentRequestDto);

    CompletePaymentResponseDto toCompletePaymentResponseDto(
            CompletePaymentResponce completePaymentResponce,
            TransactionStatus status);

    CompletePaymentResponseDto toCompletePaymentResponseDto(
            Integer statusCode, String message,
            Optional<TransactionStatus> status);

    //GetStatusTransaction
    GetStatusTransactionRequest toGetStatusTransactionRequest(
            GetStatusTransactionRequestDto getStatusTransactionRequestDto
    );

}
