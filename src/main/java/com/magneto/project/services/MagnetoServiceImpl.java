package com.magneto.project.services;

import com.magneto.project.models.AdnRequest;
import org.springframework.stereotype.Service;

@Service
public class MagnetoServiceImpl implements  MagnetoService{

    @Override
    public Boolean isMutant(AdnRequest adn) {

        return true;
    }

    private Boolean validarMatriz(){

        return false;
    }

    private Boolean validarBaseNitrogenada(){

        return false;
    }

}
