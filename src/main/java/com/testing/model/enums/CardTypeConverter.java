package com.testing.model.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.*;

@Converter(autoApply = true)
public class CardTypeConverter implements AttributeConverter<CardType, String> {
 
    @Override
    public String convertToDatabaseColumn(CardType cardType) {
        if (cardType == null) {
            return null;
        }
        return cardType.getCardType();
    }

    @Override
    public CardType convertToEntityAttribute(String cardType) {
        if (cardType == null) {
            return null;
        }

        return Stream.of(CardType.values())
          .filter(c -> c.getCardType().equals(cardType))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}
