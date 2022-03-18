package com.veon.eurasia.alfabank.model.dto.any2card.request;

import com.veon.eurasia.alfabank.model.dto.BaseRequestDto;
import java.math.BigDecimal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;


@Getter
public class CalculateFeeRequestDto extends BaseRequestDto {
  @NotBlank
  private String cardDestinationPan;
  @Min(1)
  private BigDecimal amount;
  @NotNull
  private Long currencyId;
}