package lesson_2.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class DownloadService {
    private final HttpClient httpClient = HttpClient.newHttpClient();

    public Path downloadFile(String sourceUri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest
                .newBuilder()
                .uri(URI.create(sourceUri))
                .GET()
                .build();

        String fileName = sourceUri.substring(sourceUri.lastIndexOf("/") + 1);

        HttpResponse<InputStream> response = httpClient.send(request, responseInfo ->
                HttpResponse.BodySubscribers.ofInputStream());

        Path targetPath = Path.of("src/main/resources", fileName);
        Files.copy(response.body(), targetPath, StandardCopyOption.REPLACE_EXISTING);
        return targetPath;
    }
}
