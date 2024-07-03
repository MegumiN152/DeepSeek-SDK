package com.hh.deepseeksdk.model;

import com.hh.deepseeksdk.commtant.DsCommtant;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class ChatRequest {
    private List<Message> messages;
    private String model;
    private double frequency_penalty;
    private int max_tokens;
    private double presence_penalty;
    private Object stop;
    private boolean stream;
    private double temperature;
    private double top_p;
    private boolean logprobs;
    private Integer top_logprobs;
     // 静态方法，用于创建一个包含默认值的 ChatRequest 实例
    public static ChatRequest createWithDefaults(ChatRequest chatRequest,SendMessage sendMessage) {
        if (chatRequest == null) {
            chatRequest = new ChatRequest();
        }
        chatRequest.setModel(Optional.ofNullable(chatRequest.getModel()).orElse(DsCommtant.CHAT_MODEL));  // 或者 DsCommtant.CODE_MODEL
        if (chatRequest.getFrequency_penalty()==0.0){
            chatRequest.setFrequency_penalty(DsCommtant.FREQUENCY_PENALTY);
        }
       if (chatRequest.getMax_tokens()==0){
           chatRequest.setMax_tokens(DsCommtant.MAX_TOKEN);
       }
        if (chatRequest.getPresence_penalty()==0.0){
            chatRequest.setPresence_penalty(DsCommtant.PRESENCE_PENALTY);
        }
        if (chatRequest.getStop()==null){
            chatRequest.setStop(DsCommtant.STOP);
        }
        if (chatRequest.getTemperature()==0.0){
            chatRequest.setTemperature(DsCommtant.TEMPERATURE);
        }
       if (chatRequest.getTop_p()==0.0){
           chatRequest.setTop_p(DsCommtant.TOP_P);
       }
       if (chatRequest.getTop_logprobs()==null){
           chatRequest.setTop_logprobs(DsCommtant.TOP_LOGPROBS);
       }
        chatRequest.setMessages(new ArrayList<>());

        Message systemMessage = new Message();
        systemMessage.setRole(DsCommtant.SYSTEM_ROLE);
        systemMessage.setContent(sendMessage.getSystemMessage());
        chatRequest.getMessages().add(systemMessage);

        Message userMessage = new Message();
        userMessage.setRole(DsCommtant.USER_ROLE);
        userMessage.setContent(sendMessage.getUserMessage());
        chatRequest.getMessages().add(userMessage);
        return chatRequest;
    }
}

