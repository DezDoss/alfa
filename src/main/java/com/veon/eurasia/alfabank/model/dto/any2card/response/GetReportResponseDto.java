package com.veon.eurasia.alfabank.model.dto.any2card.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.veon.eurasia.alfabank.model.dto.BaseResponseDto;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetReportResponseDto extends BaseResponseDto {

  private List<Tran> trans;

  @Data
  public static class Tran {
    private BigDecimal amount;
    private String arnRrn;
    private String cardDestinationPan;
    private LocalDateTime dt;
    private String sessionCode;
    private String terminalNumber;
  }
}
