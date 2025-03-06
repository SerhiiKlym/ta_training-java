package com.epam.training.serhii_klymenko.task1.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JsonDataUtility {
    private static final String JSON_FILE_PATH = "src/test/resources/test-data.json";

    public static Map<String, String> getTestData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(JSON_FILE_PATH), new TypeReference<>() {
        });
    }
}