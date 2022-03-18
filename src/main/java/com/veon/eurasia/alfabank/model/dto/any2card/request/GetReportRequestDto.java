package com.veon.eurasia.alfabank.model.dto.any2card.request;

import com.veon.eurasia.alfabank.model.dto.BaseRequestDto;
import java.util.Date;
import lombok.Getter;

@Getter
public class GetReportRequestDto extends BaseRequestDto {

  private Date dtBeg;
  private Date dtEnd;
  private String sessionCode;
}