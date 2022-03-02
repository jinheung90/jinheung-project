package com.jinheung.project.domain.signal.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.Principal;

@Getter
@Setter

@NoArgsConstructor
public class StompPrincipal implements Principal {
    private String name;

    StompPrincipal(String name) { this.name = name; }

    @Override
    public String getName() { return name;}
}

