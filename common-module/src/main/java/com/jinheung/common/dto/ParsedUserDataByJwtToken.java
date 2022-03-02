package com.jinheung.common.dto;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParsedUserDataByJwtToken {
    private Long userId;
    private List<String> authorities;
    private Date expiration;
}
