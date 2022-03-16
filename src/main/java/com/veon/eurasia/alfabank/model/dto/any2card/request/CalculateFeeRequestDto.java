package com.veon.eurasia.alfabank.model.dto.any2card.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
public class CalculateFeeRequestDto {

  @NotBlank
  private String reqId;
  private String systemCode;
  @NotBlank
  private String cardDestinationPan;
  @Min(1)
  private BigDecimal amount;
  @NotNull
  private Long currencyId;
}