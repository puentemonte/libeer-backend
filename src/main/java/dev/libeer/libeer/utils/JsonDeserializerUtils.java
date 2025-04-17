package dev.libeer.libeer.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;


@Slf4j
public class JsonDeserializerUtils {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String loadJsonFromFile(final String filePath) {
        try {
            final InputStream jsonInputStream = JsonDeserializerUtils.class.getResourceAsStream(filePath);
            Assertions.assertNotNull(jsonInputStream);
            return IOUtils.toString(jsonInputStream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            Assertions.fail(String.format("could not load json from file %s", filePath));
            throw new RuntimeException(e);
        }
    }

    public static <T> List<T> createListFromString(final String json, final Class<T> clazz) {
        objectMapper.registerModule(new JavaTimeModule());
        final CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);
        try {
            return objectMapper.readValue(json, collectionType);
        } catch (JsonProcessingException e) {
            log.error("Error while reading json:\n" + "{}\n" + "of class: {}", json, clazz);
            throw new RuntimeException(e);
        }
    }


}
