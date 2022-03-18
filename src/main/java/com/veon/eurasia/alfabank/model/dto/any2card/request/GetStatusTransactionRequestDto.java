package com.veon.eurasia.alfabank.model.dto.any2card.request;

import com.veon.eurasia.alfabank.model.dto.BaseRequestDto;
import javax.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class GetStatusTransactionRequestDto extends BaseRequestDto {

  @NotBlank
  private String sessionCode;
  private String reqIdRq;
  private String sessionCodeRq;

  public GetStatusTransactionRequestDto(String reqId, String sessionCode) {
    super(reqId);
    this.sessionCode = sessionCode;
  }
}
