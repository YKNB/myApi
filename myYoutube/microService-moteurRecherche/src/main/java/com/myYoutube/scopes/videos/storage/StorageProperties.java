package com.myYoutube.scopes.videos.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "/Users/mac/Documents/Cours_ETNA/TIC-YOUTUBE/myYoutubeV2/mono/backend/upload-dir";

    public String getLocation() {
        return location.toString();}

    public void setLocation(String location) {
        this.location = location.toString();
    }

}