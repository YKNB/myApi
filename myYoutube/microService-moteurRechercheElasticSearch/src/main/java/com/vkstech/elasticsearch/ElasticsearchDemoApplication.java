package com.vkstech.elasticsearch;

import com.vkstech.elasticsearch.videos.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
@Import(ConversionConfig.class)
public class ElasticsearchDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(ElasticsearchDemoApplication.class, args);
    }

}

