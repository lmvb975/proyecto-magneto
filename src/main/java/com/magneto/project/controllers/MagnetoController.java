package com.magneto.project.controllers;

import com.magneto.project.models.AdnRequest;
import com.magneto.project.models.StatsResponse;
import com.magneto.project.services.MagnetoService;
import com.magneto.project.services.StatsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MagnetoController {

    private static Logger log = LoggerFactory.getLogger(MagnetoController.class);

    @Autowired
    private MagnetoService magnetoService;

    @Autowired
    private StatsService statsService;

    @PostMapping("/mutant")
    public ResponseEntity<Boolean> validarADN(@RequestBody AdnRequest dna){
        if(magnetoService.isMutant(dna)){
            log.info("Es Mutante !");
            return ResponseEntity.status(HttpStatus.OK).body(true);
        }else{
            log.info("Es Humano !");
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(false);
        }
    }

    @GetMapping("/stats")
    public ResponseEntity<StatsResponse> statsAdn(){
        return ResponseEntity.status(HttpStatus.OK).body(statsService.obtenerStats());
    }

}
