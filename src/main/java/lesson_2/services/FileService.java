package lesson_2.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson_2.Book;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class FileService {
    public List<Book> readJsonFileAsList(Path fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return  objectMapper.readValue(fileName.toFile(), new TypeReference<>() {});
    }
}
