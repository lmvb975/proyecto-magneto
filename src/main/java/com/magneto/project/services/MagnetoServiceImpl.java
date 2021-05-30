package com.magneto.project.services;

import com.magneto.project.models.AdnRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class MagnetoServiceImpl implements  MagnetoService{

    /**
     *
     * @param dna
     * @return
     */
    @Override
    public Boolean isMutant(AdnRequest dna) {

        Boolean esMutante = false;
        int coincidencias=0;

        //Validar coincidencias de adn Horizontal
        for (String a:dna.getDna()) {
            coincidencias +=validarAdnMutante(a);
        }

        //guardar variable longitud de la matriz
        int longitud = dna.getDna().length;

        //convertir String[] a char[][]
        char[][] adnToChar = new char[longitud][longitud];
        for (int i = 0; i < longitud; i++) {
            adnToChar[i] = dna.getDna()[i].toCharArray();
        }

        //Rotar matriz a la derecha
        char[][] adnVertical = new char[longitud][longitud];
        for (int x=0;x<longitud;x++) {
            for (int y=0;y<longitud;y++) {
                adnVertical[y][longitud-1-x] = adnToChar[x][y];
            }
        }

        //Validar coincidencias de adn Vertical
        for (char[] c:adnVertical) {
            coincidencias +=validarAdnMutante(String.valueOf(c));
        }

        //Diagonal izquierda a derecha
        char[][] adnDiagonalIDA = new char[longitud][longitud];
        char[][] adnDiagonalIDB = new char[longitud][longitud];
        for (int x=0;x<longitud;x++) {
            for (int y=0;y<longitud-x;y++) {
                adnDiagonalIDA[x][y] = adnToChar[x+y][y];
                if(x!=0){
                    adnDiagonalIDB[x][y] = adnToChar[y][y+x];
                }
            }
        }
        //Diagonal derecha a izquierda, recorremos con la matriz girada a la derecha
        char[][] adnDiagonalDIA = new char[longitud][longitud];
        char[][] adnDiagonalDIB = new char[longitud][longitud];
        for (int x=0;x<longitud;x++) {
            for (int y=0;y<longitud-x;y++) {
                adnDiagonalDIA[x][y] = adnVertical[x+y][y];
                if(x!=0){
                    adnDiagonalDIB[x][y] = adnVertical[y][y+x];
                }
            }
        }

        //Validar coincidencias de adn Diagonal
        for (char[] c:adnDiagonalIDA) {
            coincidencias +=validarAdnMutante(String.valueOf(c));
        }
        for (char[] c:adnDiagonalIDB) {
            coincidencias +=validarAdnMutante(String.valueOf(c));
        }
        for (char[] c:adnDiagonalDIA) {
            coincidencias +=validarAdnMutante(String.valueOf(c));
        }
        for (char[] c:adnDiagonalDIB) {
            coincidencias +=validarAdnMutante(String.valueOf(c));
        }
        System.out.println("COINCIDENCIAS: "+coincidencias);
        return validarMatriz(dna);
    }




    private int validarAdnMutante(String cadena){
        int coincidencias=0;
        if(cadena.contains("AAAA")){
            System.out.println("Contiene AAAA");
            coincidencias++;
        }
        if(cadena.contains("TTTT")){
            System.out.println("Contiene TTTT");
            coincidencias++;
        }
        if(cadena.contains("CCCC")){
            System.out.println("Contiene CCCC");
            coincidencias++;
        }
        if(cadena.contains("GGGG")){
            System.out.println("Contiene GGGG");
            coincidencias++;
        }
        return coincidencias;
    }

    /**
     *
     * @param dna
     * @return
     */
    private Boolean validarMatriz(AdnRequest dna){
        Boolean esValida = true;
        int longitud = dna.getDna().length;
        for (String a:dna.getDna()) {
            if(a.length() != longitud){
                esValida = false;
                System.out.println("Matriz invalida");
                break;
            }
        }
        return esValida;
    }

    /**
     *
     * @param dna
     * @return
     */
    private Boolean validarBaseNitrogenada(AdnRequest dna){
        Boolean esValida = true;
        Pattern pat = Pattern.compile("(A|T|C|G)+");
        for (String a:dna.getDna()) {
            Matcher mat = pat.matcher(a.toUpperCase());
            if (mat.matches()==false) {
                System.out.println(a+" :NO coincide");
                esValida = false;
                break;
            } else {
                System.out.println(a+" :coincide");
            }
        }
        return esValida;
    }

}
