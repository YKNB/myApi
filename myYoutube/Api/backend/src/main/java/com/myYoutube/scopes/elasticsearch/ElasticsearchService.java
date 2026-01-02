package com.myYoutube.scopes.elasticsearch;

import com.myYoutube.scopes.videos.entities.Video;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ElasticsearchService {
    public final RestHighLevelClient client;

    public ElasticsearchService(RestHighLevelClient client) {
        this.client = client;
    }

    public void addVideoToIndex(Video video) throws IOException {
        IndexRequest request = new IndexRequest("videos");
        request.id(String.valueOf(video.getId()));
        request.source(video.toJson(), XContentType.JSON);

        client.index(request, RequestOptions.DEFAULT);
    }

    public void updateVideo(String id, Video video) throws IOException {
        UpdateRequest request = new UpdateRequest("videos", "videos", id);
        request.doc(video.toJson(), XContentType.JSON);

        client.update(request, RequestOptions.DEFAULT);
    }

    public void deleteVideo(String id) throws IOException {
        DeleteRequest request = new DeleteRequest("videos", "video", id);

        RequestOptions options = RequestOptions.DEFAULT;
        client.delete(request, options);
    }

    public List<Video> searchVideos(String searchTerm) throws IOException {
        SearchRequest request = new SearchRequest("videos");

        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.matchQuery("title", searchTerm));

        request.source(sourceBuilder);

        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        return getVideos(response);
    }

    private List<Video> getVideos(SearchResponse response) {
        SearchHit[] hits = response.getHits().getHits();
        List<Video> videos = new ArrayList<>();

        for (SearchHit hit : hits) {
            Map<String, Object> sourceAsMap = hit.getSourceAsMap();
            Video video = new Video();
            video.setId(Long.parseLong(hit.getId()));
            video.setTitle((String) sourceAsMap.get("title"));
            video.setDescription((String) sourceAsMap.get("description"));
            //etc.
            videos.add(video);
        }

        return videos;
    }

    public List<Video> extractVideosFromSearchResponse(SearchResponse response) {
        return getVideos(response);
    }


}
