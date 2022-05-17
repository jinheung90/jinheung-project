package com.jinheung.project.config;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories(
    basePackages = "com.jinheung.project.domain.product.es.repository"
)

public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

    @Value("${spring.elasticsearch.rest.uris}")
    private String[] uris;
    @Value("${spring.elasticsearch.rest.username}")
    private String username;
    @Value("${spring.elasticsearch.rest.password}")
    private String password;

    @Override
    @Bean
    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
            .connectedTo(uris) // 여기부분은 내가 노드로 쓸 포트연걸을 다 해놓는 부분
            .withBasicAuth(username,password)
            .build();
        return RestClients.create(clientConfiguration).rest();
    }
}
