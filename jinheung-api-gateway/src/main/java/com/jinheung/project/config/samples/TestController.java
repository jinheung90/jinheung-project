package com.jinheung.project.config.samples;

/*
import com.windfally.wolfplanet.errorHandling.customRuntimeException.RuntimeExceptionWithCode;
import com.windfally.wolfplanet.errorHandling.errorEnums.LoginErrorCode;
//import com.windfally.wolfplanet.login.auth.web.userDetail.CustomUserDetail;
import com.windfally.wolfplanet.login.dto.LoginDto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final Environment env;

    @GetMapping("/testb")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<?> cityAlarm(Principal principal)  {
        UsernamePasswordAuthenticationToken user = (UsernamePasswordAuthenticationToken)principal;
        CustomUserDetail userDetail = (CustomUserDetail)user.getPrincipal();
        logger.info(String.valueOf(userDetail.getPK()));
        return ResponseEntity.ok(2);
    }

    @GetMapping("/testException")
    //@PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<?> test(Principal principal)  {

        throw new RuntimeExceptionWithCode(LoginErrorCode.NOT_EXIST_USER);

    }

    @GetMapping("/profile")
    public String profile() {
        List<String> profiles = Arrays.asList(env.getActiveProfiles());
        List<String> realProfiles = Arrays.asList("real","real1","real2");
        String defaultProfile = profiles.isEmpty()? "default" : profiles.get(0);
        return profiles.stream()
            .filter(realProfiles::contains)
            .findAny()
            .orElse(defaultProfile);
    }
}*/
