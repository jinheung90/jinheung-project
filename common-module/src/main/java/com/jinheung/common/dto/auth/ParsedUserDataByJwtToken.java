package com.jinheung.common.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ParsedUserDataByJwtToken {
    private Long userId;
    private List<String> authorities;
    private Date expiration;
}
