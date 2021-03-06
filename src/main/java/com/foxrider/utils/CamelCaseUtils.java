package com.foxrider.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class CamelCaseUtils {

    private static final String camelAndPascalCasePattern = "^([a-z][a-z0-9]+|[A-Z][a-z0-9]+)((\\d)|([A-Z0-9][a-z0-9]+))*$";
    private String selectedText;

    public boolean isCamelCase() {
        return selectedText.matches(camelAndPascalCasePattern);
    }

    public String divideCamelCaseIntoLowerCaseWordsOrDefault() {
        if (!isCamelCase()) {
            log.info("CamelCaseUtils. Text {} is not camelcase", selectedText);
            return selectedText;
        }

        StringBuilder builder = new StringBuilder(selectedText);
        for (int i = 0; i < builder.length(); i++) {
            if (Character.isUpperCase(builder.charAt(i)) && i != 0) {
                builder.insert(i, " ");
                i++;
            }
        }
        return builder.toString();
    }
}
