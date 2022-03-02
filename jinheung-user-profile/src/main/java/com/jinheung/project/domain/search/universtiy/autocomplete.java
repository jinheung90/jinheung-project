package com.jinheung.project.domain.search.universtiy;

import java.util.List;
import java.util.Set;

public class autocomplete {
//    public void setUniversityDepartmentAutocomplete() {
//        List<UniversityDepartment> universityDepartments = universityDepartmentRepository.findAll();
//        for (UniversityDepartment u : universityDepartments
//        ) {
//            addWord(u.getDepartmentName());
//        }
//    }
//    //3.5kb
//    public void addWord(final String word) {
//        redisTemplate.opsForZSet().add(UNIVERSITY_DEPARTMENT_REDIS_KEY, word + "%", 0);
//        for (int i = 1; i < word.length(); i++) {
//            redisTemplate.opsForZSet().add(UNIVERSITY_DEPARTMENT_REDIS_KEY, word.substring(0, i - 1), 0);
//        }
//    }
//
//    public Set<String> resultUniversityDepartments(String input) {
//        ZSetOperations<String, String> zSetOperations = redisTemplate.opsForZSet();
//        Long rank = zSetOperations.rank(UNIVERSITY_DEPARTMENT_REDIS_KEY, input);
//        return null;
//    }
}
