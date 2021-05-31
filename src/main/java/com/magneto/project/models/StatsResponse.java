package com.magneto.project.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatsResponse {

    private int count_mutant_dna;
    private int count_human_dna;
    private double ratio;
}
