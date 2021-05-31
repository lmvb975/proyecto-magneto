package com.magneto.project.services;

import com.google.common.collect.Lists;
import com.magneto.project.models.StatsResponse;
import com.magneto.project.models.entities.Adn;
import com.magneto.project.repositories.AdnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatsServiceImpl implements  StatsService{

    @Autowired
    private AdnRepository adnRepository;

    /**
     * obtiene las estadisticas de adn registrados
     * @return StatsResponse
     */
    @Override
    public StatsResponse obtenerStats() {

        List<Adn> adnList = Lists.newArrayList(adnRepository.findAll());

        List<Adn> mutantes = adnList
                .stream()
                .filter(adn -> adn.getEsMutante()==true)
                .collect(Collectors.toList());

        List<Adn> humanos = adnList.stream()
                .filter(adn -> adn.getEsMutante()==false)
                .collect(Collectors.toList());

        StatsResponse response = new StatsResponse();
        response.setCount_mutant_dna(mutantes.size());
        response.setCount_human_dna(humanos.size());
        response.setRatio((mutantes.size()==0 ?0.0:(double) mutantes.size()/(double)humanos.size()));
        return response;
    }





}
