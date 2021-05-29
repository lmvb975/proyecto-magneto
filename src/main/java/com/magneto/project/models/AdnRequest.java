package com.magneto.project.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class AdnRequest {

    private String[] dna;
}
