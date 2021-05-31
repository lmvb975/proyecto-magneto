package com.magneto.project.services;

import com.google.gson.Gson;
import com.magneto.project.models.AdnRequest;
import com.magneto.project.models.entities.Adn;
import com.magneto.project.repositories.AdnRepository;
import com.magneto.project.utils.AdnUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.UUID;

@Service
public class MagnetoServiceImpl implements  MagnetoService{

    private static Logger log = LoggerFactory.getLogger(MagnetoServiceImpl.class);

    @Autowired
    private AdnRepository adnRepository;

    /**
     * servicio que valida si un adn es de mutante o humano
     * @param dna
     * @return boolean
     */
    @Override
    public Boolean isMutant(AdnRequest dna) {
        AdnUtils utils = new AdnUtils();
        Boolean esMutante = false;
        if(utils.validarBaseNitrogenada(dna)){
            utils.setLongitud(dna.getDna().length);
            if(utils.validarMatriz(dna)){
                int coincidencias=0;
                char[][] matrizAdn = utils.convertirAdnMatriz(dna.getDna());
                char[][] matrizAdnVertical = utils.girarMatrizDerecha(matrizAdn);

                coincidencias += utils.validarAdnMutante(matrizAdn);
                coincidencias +=utils.validarAdnMutante(matrizAdnVertical);
                coincidencias +=utils.validarDiagonal(matrizAdn);
                coincidencias +=utils.validarDiagonal(matrizAdnVertical);
                esMutante = esAdnMutante(coincidencias);
                guardarAdn(dna.getDna(),esMutante);
                return esMutante;
            }else{
                log.info("adn no cumple regla NxN");
                guardarAdn(dna.getDna(),esMutante);
                return false;
            }
        }else{
            log.info("base nitrogenada invalida");
            guardarAdn(dna.getDna(),esMutante);
            return false;
        }
    }

    /**
     * guarda el adn y la respuesta si es mutante en cloud datastore
     * @param adn
     * @param esMutante
     */
    private void guardarAdn(String[] adn, Boolean esMutante){
        Adn datastoreadn = new Adn();
        datastoreadn.setEsMutante(esMutante);
        String adnJson = new Gson().toJson(adn);
        datastoreadn.setBaseAdn(adnJson);
        datastoreadn.setAdnId(UUID.randomUUID().toString());
        adnRepository.save(datastoreadn);
    }

    /**
     * valida si tiene mas de una coincidencia
     * @param coincidencias
     * @return
     */
    private Boolean esAdnMutante(int coincidencias){
        if(coincidencias>1){
            return true;
        }else{
            return false;
        }
    }






}
