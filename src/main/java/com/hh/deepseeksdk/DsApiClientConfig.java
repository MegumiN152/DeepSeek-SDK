package com.hh.deepseeksdk;

import com.hh.deepseeksdk.client.DsApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author 黄昊
 * @version 1.0
 **/
@Configuration
@ConfigurationProperties("dsapi.client")
@Data
@ComponentScan
public class DsApiClientConfig {
    private String apiKey;

    @Bean
    public DsApiClient dsApiClient(){
        return new DsApiClient(apiKey);
    }
}
