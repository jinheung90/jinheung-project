package com.jinheung.project.utils;

import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public abstract class CustomQueryDslSupportMethods {
    public  <T> Page<T> getPage(JPAQuery<T> query, PageRequest pageRequest) {

        List<T> resultList = query
            .offset(pageRequest.getOffset())
            .limit(pageRequest.getPageSize())
            .fetch();

        Long totalCount = query.fetchCount();
        return new PageImpl<T>(resultList, pageRequest, totalCount);
    }
}
