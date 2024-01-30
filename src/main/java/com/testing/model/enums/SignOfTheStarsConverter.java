package com.testing.model.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.*;

@Converter(autoApply = true)
public class SignOfTheStarsConverter implements AttributeConverter<SignOfTheStars, String> {
 
    @Override
    public String convertToDatabaseColumn(SignOfTheStars starSign) {
        if (starSign == null) {
            return null;
        }
        return starSign.getStarSign();
    }

    @Override
    public SignOfTheStars convertToEntityAttribute(String starSign) {
        if (starSign == null) {
            return null;
        }

        return Stream.of(SignOfTheStars.values())
          .filter(c -> c.getStarSign().equals(starSign))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}

