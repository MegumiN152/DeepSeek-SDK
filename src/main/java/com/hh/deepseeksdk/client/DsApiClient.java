package com.hh.deepseeksdk.client;


/**
 * @author 黄昊
 * @version 1.0
 * 调用第三方接口客户端
 **/
import com.google.gson.Gson;
import com.hh.deepseeksdk.model.ChatRequest;
import com.hh.deepseeksdk.model.DeepseekChatCompletionResponse;
import okhttp3.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DsApiClient {
    private static final String API_URL = "https://api.deepseek.com/chat/completions";
    private String apiKey;
    private OkHttpClient client;
    private MediaType mediaType;

    public DsApiClient(String apiKey) {
        this.apiKey = apiKey;
        this. client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build();
        this.mediaType = MediaType.parse("application/json");
    }
    private String createJsonRequestBody(ChatRequest chatRequest) {
        return "{\n" +
                "  \"messages\": [\n" +
                "    {\n" +
                "      \"content\": \"" + chatRequest.getSysTemContent() + "\",\n" +
                "      \"role\": \"system\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"content\": \""+chatRequest.getUserContent()+"\",\n" +
                "      \"role\": \"user\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"model\": \"" + chatRequest.getModel() + "\",\n" +
                "  \"frequency_penalty\": 0,\n" +
                "  \"max_tokens\": 2048,\n" +
                "  \"presence_penalty\": 0,\n" +
                "  \"stop\": null,\n" +
                "  \"stream\": false,\n" +
                "  \"temperature\": 1,\n" +
                "  \"top_p\": 1,\n" +
                "  \"logprobs\": false,\n" +
                "  \"top_logprobs\": null\n" +
                "}";
    }


    public DeepseekChatCompletionResponse getChatCompletion(ChatRequest chatRequest) throws IOException {
        String jsonRequestBody = createJsonRequestBody(chatRequest);
        RequestBody body = RequestBody.create(mediaType, jsonRequestBody);
        Request request = new Request.Builder()
                .url(API_URL)
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("Authorization", "Bearer " + apiKey)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody  = response.body().string();
                Gson gson=new Gson();
                return gson.fromJson(responseBody, DeepseekChatCompletionResponse.class);
            } else {
                throw new IOException("Request failed: " + response.code() + "\n" + response.body().string());
            }
        }
    }

}

