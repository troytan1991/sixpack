package com.troytan.sixpack;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@MapperScan("com.troytan.sixpack.repository")
@EnableCaching
@EnableScheduling
public class RestApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class, args);
    }

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    /**
     * 配置restTemplate,用于第三方接口调用
     *
     * @author troytan
     * @date 2018年7月24日
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        return restTemplateBuilder.build();
    }

}
