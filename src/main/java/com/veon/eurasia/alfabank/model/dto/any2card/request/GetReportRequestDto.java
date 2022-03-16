package com.veon.eurasia.alfabank.model.dto.any2card.request;

import java.time.LocalDateTime;

public class GetReportRequestDto {
//  Reqid String Да Id во внешней системе
//  Systemcode String Нет Код внешней системы
//  Login String Да Логин партнера
//  Password String Да Пароль партнера
//  DtBeg DateTime Нет Дата начала отчета
//  DtEnd DateTime Нет Дата окончания отчета
//  ReqId String Нет Id во внешней системе
//  SessionCode String Нет Код сессии


  private String reqId;
  private String systemCode;
  private LocalDateTime dtBeg;
  private LocalDateTime dtEnd;
//  private String reqId;
  private String sessionCofe;
}
