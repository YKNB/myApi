package com.myYoutube;

import com.myYoutube.scopes.videos.storage.StorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class YoutubeSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(YoutubeSearchApplication.class, args);
    }

}
