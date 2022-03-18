package com.veon.eurasia.alfabank.model;

import lombok.Builder;
import lombok.Getter;
import org.datacontract.schemas._2004._07.p2pserver.BaseResponse;

@Getter
@Builder
public class ResponseObject<T extends BaseResponse> {
  private final T response;
  private final int code;
  private final String message;
}
