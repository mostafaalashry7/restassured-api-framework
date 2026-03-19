package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class testDataReader {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T readJson(String filePath, Class<T> clazz) {
        try {
            return objectMapper.readValue(new File(filePath), clazz);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read test data from: " + filePath, e);
        }
    }

    public static Map<String, Object> convertObjectToMap(Object object) {
        return objectMapper.convertValue(object, new TypeReference<Map<String, Object>>() {});
    }
}