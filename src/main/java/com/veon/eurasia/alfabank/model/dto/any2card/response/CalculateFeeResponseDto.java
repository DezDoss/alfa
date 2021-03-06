package com.veon.eurasia.alfabank.model.dto.any2card.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.veon.eurasia.alfabank.model.dto.BaseResponseDto;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class CalculateFeeResponseDto extends BaseResponseDto {
  private String sessionCode;
  private Long currencyId;
  private BigDecimal fee;
  private String sourceCardCountry;
  private String destinationCardCountry;
}
