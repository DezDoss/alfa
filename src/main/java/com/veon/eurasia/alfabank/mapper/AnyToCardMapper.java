package com.veon.eurasia.alfabank.mapper;

import static com.veon.eurasia.alfabank.utils.XmlCalendarUtils.toZonedDt;

import com.veon.eurasia.alfabank.enums.TransactionStatus;
import com.veon.eurasia.alfabank.model.dto.any2card.request.CalculateFeeRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.request.CompletePaymentRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.request.GetReportRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.request.GetStatusTransactionRequestDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.CalculateFeeResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.CompletePaymentResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.GetBalanceResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.GetReportResponseDto;
import com.veon.eurasia.alfabank.model.dto.any2card.response.GetStatusTransactionResponseDto;
import com.veon.eurasia.alfabank.model.request.any2card.CalculateFeeRequest;
import com.veon.eurasia.alfabank.model.request.any2card.CompletePaymentRequest;
import com.veon.eurasia.alfabank.model.request.any2card.GetBalanceRequest;
import com.veon.eurasia.alfabank.model.request.any2card.GetReportRequest;
import com.veon.eurasia.alfabank.model.request.any2card.GetStatusTransactionRequest;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBElement;
import org.datacontract.schemas._2004._07.p2pserver.ArrayOfTrans;
import org.datacontract.schemas._2004._07.p2pserver.CalculatedFeeResponce;
import org.datacontract.schemas._2004._07.p2pserver.CompletePaymentResponce;
import org.datacontract.schemas._2004._07.p2pserver.GetBalanceResponse;
import org.datacontract.schemas._2004._07.p2pserver.GetReportResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        uses = {ExtractMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AnyToCardMapper {

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

  GetStatusTransactionResponseDto toGetStatusTransactionResponseDto(
        Integer statusCode, String message, Optional<TransactionStatus> status,
        String reqIdrp, String sessioncoderp);

  //GetBalance
  GetBalanceRequest toGetBalanceRequest(String reqId);

  GetBalanceResponseDto toGetBalanceResponseDto(GetBalanceResponse getBalanceResponse,
                                              TransactionStatus status);

  GetBalanceResponseDto toGetBalanceResponseDto(Integer statusCode, String message,
                                              Optional<TransactionStatus> status);

  //GetReport
  GetReportRequest toGetReportRequest(GetReportRequestDto getReportRequestDto);

  GetReportResponseDto toGetReportResponseDto(Integer statusCode,
                                            String message,
                                            Optional<TransactionStatus> status);

  @Mapping(source = "getReportResponse.trans", target = "trans")
  GetReportResponseDto toGetReportResponseDto(
      GetReportResponse getReportResponse, TransactionStatus status);

  default List<GetReportResponseDto.Tran> map(JAXBElement<ArrayOfTrans> arrayOfTrans) {
    if (arrayOfTrans.getValue() != null) {
      return arrayOfTrans.getValue().getTrans().stream().map(tran -> {
        var tranDto = new GetReportResponseDto.Tran();
        tranDto.setDt(toZonedDt(tran.getDt()).toLocalDateTime());
        tranDto.setArnRrn(tran.getArnRrn().getValue());
        tranDto.setSessionCode(tran.getSessionCode().getValue());
        tranDto.setCardDestinationPan(tran.getCardDestinationPan().getValue());
        tranDto.setTerminalNumber(tran.getTerminalNumber().getValue());
        tranDto.setAmount(tran.getAmount());

        return tranDto;
      }).collect(Collectors.toList());
    }

    return Collections.EMPTY_LIST;
  }
}
