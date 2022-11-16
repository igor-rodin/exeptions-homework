package lesson_2.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lesson_2.Book;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Book> readJsonFileAsList(Path fileName) throws IOException {
        if (!Files.exists(fileName)) {
            throw new RuntimeException(String.format("Файл %s не существует", fileName));
        }

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return  objectMapper.readValue(fileName.toFile(), new TypeReference<>() {});
    }
}
