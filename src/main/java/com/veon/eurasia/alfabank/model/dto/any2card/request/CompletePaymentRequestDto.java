package com.veon.eurasia.alfabank.model.dto.any2card.request;

import com.veon.eurasia.alfabank.model.dto.BaseRequestDto;
import javax.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CompletePaymentRequestDto extends BaseRequestDto {
  @NotBlank
  private String sessionCode;
  private String nameRecipient;
  private String surnameRecipient;
  private String edTransId;
}
