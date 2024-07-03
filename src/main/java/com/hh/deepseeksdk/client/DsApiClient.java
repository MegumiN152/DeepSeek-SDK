package com.hh.deepseeksdk.client;


/**
 * @author 黄昊
 * @version 1.0
 * 调用第三方接口客户端
 **/
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hh.deepseeksdk.commtant.DsCommtant;
import com.hh.deepseeksdk.model.ChatRequest;
import com.hh.deepseeksdk.model.DeepseekChatCompletionResponse;
import com.hh.deepseeksdk.model.SendMessage;
import okhttp3.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.hh.deepseeksdk.commtant.DsCommtant.API_URL;

public class DsApiClient {
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
    public String createJsonRequestBody(ChatRequest chatRequest,SendMessage sendMessage) {
        ChatRequest defaults = ChatRequest.createWithDefaults(chatRequest,sendMessage);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(defaults);
    }


    public DeepseekChatCompletionResponse getChatCompletion(ChatRequest chatRequest, SendMessage sendMessage) throws IOException {
        String jsonRequestBody = createJsonRequestBody(chatRequest,sendMessage);
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

