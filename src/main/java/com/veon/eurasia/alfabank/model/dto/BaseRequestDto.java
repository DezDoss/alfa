package com.veon.eurasia.alfabank.model.dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BaseRequestDto {
  @NotBlank
  private String reqId;
  private String systemCode;

  public BaseRequestDto(String reqId) {
    this.reqId = reqId;
  }
}
