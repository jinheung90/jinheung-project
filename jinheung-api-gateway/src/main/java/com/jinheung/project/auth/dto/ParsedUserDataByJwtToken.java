package com.jinheung.project.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
public class ParsedUserDataByJwtToken {
    private Long userId;
    private List<String> authorities;
    private Date expiration;
}
