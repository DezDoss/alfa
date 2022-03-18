package com.veon.eurasia.alfabank.utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public final class XmlCalendarUtils {

  private XmlCalendarUtils() {}

  private static final DatatypeFactory datatypeFactory = DatatypeFactory.newDefaultInstance();

  public static XMLGregorianCalendar fromZonedDt(ZonedDateTime time,
                                                 ZoneId zone) {
    return datatypeFactory.newXMLGregorianCalendar(
            GregorianCalendar.from(time.withZoneSameInstant(zone)));
  }

  public static ZonedDateTime toZonedDt(XMLGregorianCalendar calendar,
                                        ZoneId zone) {
    return ZonedDateTime
            .ofInstant(calendar.toGregorianCalendar().toInstant(), zone);
  }

  public static ZonedDateTime toZonedDt(XMLGregorianCalendar calendar) {
    return toZonedDt(calendar, calendar.toGregorianCalendar().getTimeZone().toZoneId());
  }

}
