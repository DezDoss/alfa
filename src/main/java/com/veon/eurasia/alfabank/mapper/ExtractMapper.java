package com.veon.eurasia.alfabank.mapper;

import java.util.Optional;
import javax.xml.bind.JAXBElement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExtractMapper {

  default <T> T getValue(JAXBElement<T> element) {
    return element.getValue();
  }

  default <T> T unwrap(Optional<T> element) {
    return element.get();
  }
}
