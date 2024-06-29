package com.hh.deepseeksdk.model;

import java.util.List;

public class DeepseekChatCompletionResponse {

    private String id;
    private List<Choice> choices;
    private long created;
    private String model;
    private String object;
    private Usage usage;

    // Getters and setters
    // ...


    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public Usage getUsage() {
        return usage;
    }

    public void setUsage(Usage usage) {
        this.usage = usage;
    }

    // Inner class getters and setters
    public static class Choice {
        private String finishReason;
        private int index;
        private Message message;
        private LogProbs logprobs;

        public String getFinishReason() {
            return finishReason;
        }

        public void setFinishReason(String finishReason) {
            this.finishReason = finishReason;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }

        public LogProbs getLogprobs() {
            return logprobs;
        }

        public void setLogprobs(LogProbs logprobs) {
            this.logprobs = logprobs;
        }

        public static class Message {
            private String content;
            private String role;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }
        }

        public static class LogProbs {
            private List<Object> content;

            public List<Object> getContent() {
                return content;
            }

            public void setContent(List<Object> content) {
                this.content = content;
            }
        }
    }

    public static class Usage {
        private int completionTokens;
        private int promptTokens;
        private int totalTokens;

        public int getCompletionTokens() {
            return completionTokens;
        }

        public void setCompletionTokens(int completionTokens) {
            this.completionTokens = completionTokens;
        }

        public int getPromptTokens() {
            return promptTokens;
        }

        public void setPromptTokens(int promptTokens) {
            this.promptTokens = promptTokens;
        }

        public int getTotalTokens() {
            return totalTokens;
        }

        public void setTotalTokens(int totalTokens) {
            this.totalTokens = totalTokens;
        }
    }
}
