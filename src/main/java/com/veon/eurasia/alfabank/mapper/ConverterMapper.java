package com.veon.eurasia.alfabank.mapper;

import org.mapstruct.Mapper;

import java.util.Optional;
import javax.xml.bind.JAXBElement;

@Mapper(componentModel = "spring")
public interface ConverterMapper {

  default <T> T getValue(JAXBElement<T> element) {
    return element.getValue();
  }

  default <T> T get(Optional<T> element) {
    return element.get();
  }
}
