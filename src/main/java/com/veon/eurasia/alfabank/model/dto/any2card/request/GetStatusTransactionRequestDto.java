package com.veon.eurasia.alfabank.model.dto.any2card.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class GetStatusTransactionRequestDto {
  @NotBlank
  private String reqId;
  private String systemCode;
  @NotBlank
  private String sessionCode;
  private String reqIdRq;
  private String sessionCodeRq;
}
