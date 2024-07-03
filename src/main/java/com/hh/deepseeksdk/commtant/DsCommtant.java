package com.hh.deepseeksdk.commtant;

/**
 * @author 黄昊
 * @version 1.0
 **/
public class DsCommtant {
    // 系统角色，用于指定 ai 角色
    public static final String SYSTEM_ROLE = "system";
    // 指定给 ai 的内容
    public static final String USER_ROLE = "user";
    // 对话模型
    public static final String CHAT_MODEL = "deepseek-chat";
    // 代码模型
    public static final String CODE_MODEL = "deepseek-coder";

    //允许穿的最大token为2048
    public static  final int MAX_TOKEN=2048;
    // 介于 -2.0 和 2.0 之间的数字。如果该值为正，
    // 那么新 token 会根据其在已有文本中的出现频率受到相应的惩罚，降低模型重复相同内容的可能性。
    public static final double FREQUENCY_PENALTY = 0;

    public static final double PRESENCE_PENALTY=0;
    public static final Object STOP = null;
    // 如果设置为 true，将会以 SSE（server-sent events）的形式以流式发送消息增量。消息流以 data: [DONE] 结尾。
    public static final boolean STREAM = false;
    // 采样温度，介于 0 和 2 之间。更高的值，如 0.8，会使输出更随机，而更低的值，如 0.2，会使其更加集中和确定。
    public static final double TEMPERATURE = 1;
    // 作为调节采样温度的替代方案，模型会考虑前 top_p 概率的 token 的结果。
    // 所以 0.1 就意味着只有包括在最高 10% 概率中的 token 会被考虑。
    // 我们通常建议修改这个值或者更改 temperature，但不建议同时对两者进行修改。
    public static final double TOP_P = 1;
    // 是否返回所输出 token 的对数概率。如果为 true，则在 message 的 content 中返回每个输出 token 的对数概率。
    public static final boolean LOGPROBS = false;
    // 一个介于 0 到 20 之间的整数 N，指定每个输出位置返回输出概率 top N 的 token，且返回这些 token 的对数概率。指定此参数时，logprobs 必须为 true。
    public static final Integer TOP_LOGPROBS = null;
    // API URL
    public static final String API_URL = "https://api.deepseek.com/chat/completions";
}
