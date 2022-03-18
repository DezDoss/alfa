package com.veon.eurasia.alfabank.model.dto.any2card.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.veon.eurasia.alfabank.model.dto.BaseResponseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetStatusTransactionResponseDto extends BaseResponseDto {
  private String reqidrp;
  private String sessioncoderp;
}
