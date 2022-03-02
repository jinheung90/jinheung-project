package com.jinheung.project.utils;

import com.google.gson.Gson;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CommonFunctions {

    public static Cookie getCookieByName(String name, HttpServletRequest request) {
        Cookie cookies[] = request.getCookies();

        for (Cookie cookie : cookies) {
            if(cookie.getName().equals(name)) {
                return cookie;
            }
        }
        return null;
    }


    public static String customDateFormat(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    public static String INPUT_DATE_FORMAT = "yyyyMMdd";

    public static <T> List<T> stringToArray(String s, Class<T[]> clazz) {
        T[] arr = new Gson().fromJson(s, clazz);
        return Arrays.asList(arr);
    }



    public static String generateUpperLettersAndNum(int size) {
        final int leftLimit = 48; // numeral '0'
        final int rightLimit = 90; // letter 'z'
        final int targetStringLength = size;

        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> ((i >= 48 && i <= 57) || (i >= 65 && i <= 90))) // 10 이후의 특수문자 제거 문자 사이의 특수문자 제거
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static long getUserIdByAuth() {

        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated() && !name.equals("anonymousUser")) {
            return Long.parseLong(name);
        } else {
            return 0;
        }
    }

    public static String checkStringWhenNullReturnEmptyString(String string) {
        String str = string;
        if(str == null) {
            return "";
        }
        return str;
    }

    public static Integer timeToMin(LocalDateTime localDateTime) {
        return localDateTime.getHour() * 60 + localDateTime.getMinute();
    }




}
