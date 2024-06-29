# DeepSeek-SDK
---
用于调用DeepSeek大模型的SDK

目前还没上传到maven中央仓库，而且这只是最初版本

本人小菜鸟一个，我是看到官方只有api调用，没有SDK才做的

（一堆bug没修，功能也没完善）

# 快速开始
---
1、 引入SDK
```java
<dependency>
    <groupId>com.yucongming</groupId>
    <artifactId>yucongming-java-sdk</artifactId>
    <version>0.0.3</version>
</dependency>
```
2、 在DeepSeek官方平台获取相关的api-key
![image-20240629130634938](C:\Users\ybb\AppData\Roaming\Typora\typora-user-images\image-20240629130634938.png)
3、初始化DsApiClient对象
 通过配置注入对象
    修改配置：
 ```java
 dsapi:
   client:
     api-key: 你的api-key
 ```

   使用客户端对象：

```java
@Resource
private DsApiClient client;
```
4、构造请求参数

   ```java
   ChatRequest chatRequest = new ChatRequest();
   //填具体内容
   chatRequest.setUserContent("请你实现快速排序的代码");
   //指定身份
   chatRequest.setSysTemContent("假如你是一位Java大神");
   //选择AI模型
   chatRequest.setModel(CommonConstant.DS_CHAT_MODEL);
   ```

5、获取响应结果

```java
DeepseekChatCompletionResponse chatCompletion = dsApiClient.getChatCompletion(chatRequest);    System.out.println(chatCompletion.getChoices().get(0).getMessage().getContent());
```

