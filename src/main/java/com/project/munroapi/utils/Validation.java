package com.project.munroapi.utils;

import com.project.munroapi.constants.Constants;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validation {

    private static Map<String, String> errorResponse;
    private static List<String> errorList;

    public static boolean paramsValid(String hill, String height, String alpha, String min, String max, String limit) {
        errorResponse = new HashMap<>();
        errorList = new ArrayList<>();

        if (isPresent(hill)) validateHill(hill);
        if (isPresent(height)) validateHeight(height);
        if (isPresent(alpha)) validateAlpha(alpha);
        if (isPresent(min)) validateMin(min);
        if (isPresent(max)) validateMax(max);
        if (isPresent(limit)) validateLimit(limit);
        if (isPresent(min) && isPresent(max)) validateMinAndMax(min, max);

        return errorList.isEmpty();
    }

    public static ResponseEntity<Object> errorResponse() {
        errorResponse.put(Constants.HTTP_STATUS, HttpStatus.BAD_REQUEST.toString());
        errorResponse.put(Constants.PARAM_ERROR_KEY, errorListBuilder(errorList));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    protected static boolean isPresent(String str) {
        return str != null;
    }

    private static String errorListBuilder(List<String> errors) {
        StringBuilder errorString = new StringBuilder();

        errors.forEach(error -> errorString.append(error).append(", "));

        return errorString.substring(0, errorString.length() - 2);
    }

    private static void validateMinAndMax(String min, String max) {
        boolean bothNumeric = NumberUtils.isParsable(min) && NumberUtils.isParsable(max);
        if (bothNumeric)
            if (Double.parseDouble(min) >= Double.parseDouble(max)) errorList.add(Constants.MIN_GREATER_THAN_OR_EQUAL_TO_MAX_ERROR);
    }

    private static void validateMin(String min) {
        if (!NumberUtils.isParsable(min)) errorList.add(Constants.MIN_ERROR);
    }

    private static void validateMax(String max) {
        if (!NumberUtils.isParsable(max)) errorList.add(Constants.MAX_ERROR);
    }

    private static void validateHill(String hill) {
        if (!hill.equalsIgnoreCase(Constants.MUN) && !hill.equalsIgnoreCase(Constants.TOP) && !hill.equalsIgnoreCase(Constants.ANY))
            errorList.add(Constants.HILL_CATEGORY_ERROR);
    }

    private static void validateHeight(String height) {
        if (!height.equalsIgnoreCase(Constants.ASC) && !height.equalsIgnoreCase(Constants.DESC))
            errorList.add(Constants.HEIGHT_ASC_DESC_ERROR);
    }

    private static void validateAlpha(String alpha) {
        if (!alpha.equalsIgnoreCase(Constants.ASC) && !alpha.equalsIgnoreCase(Constants.DESC))
            errorList.add(Constants.ALPHA_ASC_DESC_ERROR);
    }

    private static void validateLimit(String limit) {
        if (!StringUtils.isNumeric(limit)) errorList.add(Constants.LIMIT_INTEGER_ERROR);
    }
}
