package com.myYoutube.scopes.elasticsearch;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.RequestOptions;

import java.io.IOException;

public class ElasticsearchIndexer {
    private RestHighLevelClient client;

    public ElasticsearchIndexer(RestHighLevelClient client) {
        this.client = client;
    }

    public void createIndex(String indexName) throws IOException {
        CreateIndexRequest request = new CreateIndexRequest(indexName);
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);

        if (response.isAcknowledged()) {
            System.out.println("Index " + indexName + " créé avec succès.");
        } else {
            System.out.println("Erreur lors de la création de l'index " + indexName + ".");
        }
    }
}
