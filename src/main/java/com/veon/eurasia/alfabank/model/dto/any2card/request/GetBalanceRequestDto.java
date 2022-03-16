package com.veon.eurasia.alfabank.model.dto.any2card.request;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class GetBalanceRequestDto {
  @NotBlank
  private String reqId;
}
