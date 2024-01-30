package com.testing.model.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.*;

@Converter(autoApply = true)
public class ProductCategoryConverter implements AttributeConverter<ProductCategory, String> {
 
    @Override
    public String convertToDatabaseColumn(ProductCategory productCategory) {
        if (productCategory == null) {
            return null;
        }
        return productCategory.getCategory();
    }

    @Override
    public ProductCategory convertToEntityAttribute(String category) {
        if (category == null) {
            return null;
        }

        return Stream.of(ProductCategory.values())
          .filter(c -> c.getCategory().equals(category))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}

