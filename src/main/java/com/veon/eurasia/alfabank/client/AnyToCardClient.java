package com.veon.eurasia.alfabank.client;

import com.veon.eurasia.alfabank.model.ResponseObject;
import com.veon.eurasia.alfabank.model.request.any2card.CalculateFeeRequest;
import com.veon.eurasia.alfabank.model.request.any2card.CompletePaymentRequest;
import com.veon.eurasia.alfabank.model.request.any2card.GetBalanceRequest;
import com.veon.eurasia.alfabank.model.request.any2card.GetReportRequest;
import com.veon.eurasia.alfabank.model.request.any2card.GetStatusTransactionRequest;
import com.veon.eurasia.alfabank.utils.AlfaBankUtils;
import org.datacontract.schemas._2004._07.p2pserver.CalculatedFeeResponce;
import org.datacontract.schemas._2004._07.p2pserver.CompletePaymentResponce;
import org.datacontract.schemas._2004._07.p2pserver.GetBalanceResponse;
import org.datacontract.schemas._2004._07.p2pserver.GetReportResponse;
import org.datacontract.schemas._2004._07.p2pserver.GetStatusTransactionResponce;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.tempuri.CalculateFeeResponse;
import org.tempuri.CompletePaymentResponse;
import org.tempuri.GetStatusTransactionResponse;
import org.tempuri.ObjectFactory;

@Service
public class AnyToCardClient extends AlfaBankClientHelper {

  private final AlfaBankUtils alfaBankUtils;
  private final ObjectFactory rootObjectFactory;
  private final WebServiceTemplate webServiceTemplate;

  public AnyToCardClient(AlfaBankUtils alfaBankUtils,
                         @Qualifier("rootObjectFactory")
                                        ObjectFactory rootObjectFactory,
                         @Qualifier("anyToCardServiceTemplate")
                                        WebServiceTemplate webServiceTemplate,
                         Jaxb2Marshaller jaxb2Marshaller) {
    super(jaxb2Marshaller);
    this.alfaBankUtils = alfaBankUtils;
    this.webServiceTemplate = webServiceTemplate;
    this.rootObjectFactory = rootObjectFactory;
  }

  public ResponseObject<CalculatedFeeResponce>
      calculateFee(CalculateFeeRequest calculateFeeRequest) {
    var calculateFee = rootObjectFactory.createCalculateFee();
    alfaBankUtils.fillCredentials(calculateFeeRequest);
    calculateFee.setCalculateFeeRequest(rootObjectFactory
            .createCalculateFeeCalculateFeeRequest(marshalAndToString(calculateFeeRequest)));

    var response = (CalculateFeeResponse) webServiceTemplate.marshalSendAndReceive(calculateFee);

    return ResponseObject.<CalculatedFeeResponce>builder()
            .code(response.getCalculateFeeResult().getValue().getCode())
            .message(response.getCalculateFeeResult().getValue().getMessage().getValue())
            .response((CalculatedFeeResponce)
                    response.getCalculateFeeResult().getValue().getResultObject().getValue())
            .build();
  }

  public ResponseObject<CompletePaymentResponce>
      completePayment(CompletePaymentRequest completePaymentRequest) {
    var completePayment = rootObjectFactory.createCompletePayment();
    alfaBankUtils.fillCredentials(completePaymentRequest);
    completePayment.setCompletePaymentRequest(rootObjectFactory
            .createCompletePaymentCompletePaymentRequest(
                    marshalAndToString(completePaymentRequest)));

    var response = (CompletePaymentResponse)
            webServiceTemplate.marshalSendAndReceive(completePayment);

    return ResponseObject.<CompletePaymentResponce>builder()
            .code(response.getCompletePaymentResult().getValue().getCode())
            .message(response.getCompletePaymentResult().getValue().getMessage().getValue())
            .response((CompletePaymentResponce)
                    response.getCompletePaymentResult().getValue().getResultObject().getValue())
            .build();
  }

  public ResponseObject<GetStatusTransactionResponce>
      getStatusTransaction(GetStatusTransactionRequest getStatusTransactionRequest) {
    var statusTransaction = rootObjectFactory.createGetStatusTransaction();
    alfaBankUtils.fillCredentials(getStatusTransactionRequest);
    statusTransaction.setGetStatusTransactionRequest(rootObjectFactory
            .createGetStatusTransactionGetStatusTransactionRequest(
                    marshalAndToString(getStatusTransactionRequest)));

    var response = (GetStatusTransactionResponse)
            webServiceTemplate.marshalSendAndReceive(statusTransaction);

    return ResponseObject.<GetStatusTransactionResponce>builder()
            .code(response.getGetStatusTransactionResult().getValue().getCode())
            .message(response.getGetStatusTransactionResult().getValue().getMessage().getValue())
            .response((GetStatusTransactionResponce)
                    response.getGetStatusTransactionResult()
                            .getValue().getResultObject().getValue())
            .build();
  }

  public ResponseObject<GetBalanceResponse> getBalance(GetBalanceRequest getBalanceRequest) {
    var getBalance = rootObjectFactory.createGetBalance();
    alfaBankUtils.fillCredentials(getBalanceRequest);
    getBalance.setGetBalanceRequest(rootObjectFactory
            .createGetBalanceGetBalanceRequest(marshalAndToString(getBalanceRequest)));

    var response = (org.tempuri.GetBalanceResponse)
            webServiceTemplate.marshalSendAndReceive(getBalance);

    return ResponseObject.<GetBalanceResponse>builder()
            .code(response.getGetBalanceResult().getValue().getCode())
            .message(response.getGetBalanceResult().getValue().getMessage().getValue())
            .response((GetBalanceResponse)
                    response.getGetBalanceResult().getValue().getResultObject().getValue())
            .build();
  }

  public ResponseObject<GetReportResponse> getReport(GetReportRequest getReportRequest) {

    var getReport = rootObjectFactory.createGetReport();
    alfaBankUtils.fillCredentials(getReportRequest);
    getReport.setGetReportRequest(rootObjectFactory
            .createGetReportGetReportRequest(marshalAndToString(getReportRequest)));

    var response = (org.tempuri.GetReportResponse)
            webServiceTemplate.marshalSendAndReceive(getReport);

    return ResponseObject.<GetReportResponse>builder()
            .code(response.getGetReportResult().getValue().getCode())
            .message(response.getGetReportResult().getValue().getMessage().getValue())
            .response((GetReportResponse)
                    response.getGetReportResult().getValue().getResultObject().getValue())
            .build();
  }
}
