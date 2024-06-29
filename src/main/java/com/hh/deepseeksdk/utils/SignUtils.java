package com.hh.deepseeksdk.utils;


import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * @author 黄昊
 * @version 1.0
 **/
public class SignUtils {
    public static  String genSign(String object,String secretKey){
        //使用SHA256算法的Disgeter
        Digester md5=new Digester(DigestAlgorithm.SHA256);
        //构建签名内容，将哈希映射转换为字符串并拼接密钥
        String content=object+"."+secretKey;
        //计算签名的摘要并返回摘要的十六进制表示形式
        return md5.digestHex(content);
    }
}
