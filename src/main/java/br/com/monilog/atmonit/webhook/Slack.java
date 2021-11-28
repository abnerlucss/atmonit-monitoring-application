package br.com.monilog.atmonit.webhook;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class Slack {

    private static final byte[] decodedBytes = Base64.getUrlDecoder().decode("aHR0cHM6Ly9ob29rcy5zbGFjay5jb20vc2VydmljZXMvVDAyUEgzNUJYNFkvQjAyTlRKVjhNTDIvYWltMGlUT1RRODhpYVcxVE1mZ2xESFZT");
    private static final String decodedUrl = new String(decodedBytes);

    private static HttpClient client = HttpClient.newHttpClient();
    private static final String URL = decodedUrl;

    public static void sendMessage(JSONObject content) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder(
                        URI.create(URL))
                .header("accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(content.toString()))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(String.format("Status: %s", response.statusCode()));
        System.out.println(String.format("Response: %s", response.body()));
    }
}
