package com.jinheung.project.gateway;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomLog {
    private String userId;
    private String message;
    private String method;
    private String queryString;
    private String requestUrl;
    private String host;
    private String userAgent;
}
