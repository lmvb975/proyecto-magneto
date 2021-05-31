package com.magneto.project.utils;

import com.magneto.project.models.AdnRequest;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdnUtils {

    @Setter
    int longitud;

    /**
     * gira la matriz de adn hacia la derecha para validar verticales y diagonal derecha-izq
     * @param matriz
     * @return char[][]
     */
    public char[][] girarMatrizDerecha(char[][] matriz){
        char[][] adnVertical = new char[longitud][longitud];
        for (int x=0;x<longitud;x++) {
            for (int y=0;y<longitud;y++) {
                adnVertical[y][longitud-1-x] = matriz[x][y];
            }
        }
        return adnVertical;
    }

    /**
     * convierte String[] a char[][]
     * @param dna
     * @return char[][]
     */
    public char[][] convertirAdnMatriz(String[] dna){
        char[][] adnToChar = new char[longitud][longitud];
        for (int i = 0; i < longitud; i++) {
            adnToChar[i] = dna[i].toCharArray();
        }
        return adnToChar;
    }

    /**
     * valida coincidencias en las diagonales
     * @param adnMatriz
     * @return numero de coincidencias
     */
    public int validarDiagonal(char[][] adnMatriz){
        int conteo = 0;
        char[][] adnDiagonalIDA = new char[longitud][longitud];
        char[][] adnDiagonalIDB = new char[longitud][longitud];
        for (int x=0;x<longitud;x++) {
            for (int y=0;y<longitud-x;y++) {
                adnDiagonalIDA[x][y] = adnMatriz[x+y][y];
                if(x!=0){
                    adnDiagonalIDB[x][y] = adnMatriz[y][y+x];
                }
            }
        }
        conteo +=validarAdnMutante(adnDiagonalIDA);
        conteo +=validarAdnMutante(adnDiagonalIDB);
        return conteo;
    }

    /**
     * valida las coincidencias de adn mutante
     * @param cadenaAdn
     * @return numero de coincidencias
     */
    public int validarAdnMutante(char[][] cadenaAdn){
        int coincidencias=0;
        for (char[] str:cadenaAdn) {
            if(String.valueOf(str).contains("AAAA")){
                coincidencias++;
            }
            if(String.valueOf(str).contains("TTTT")){
                coincidencias++;
            }
            if(String.valueOf(str).contains("CCCC")){
                coincidencias++;
            }
            if(String.valueOf(str).contains("GGGG")){
                coincidencias++;
            }
        }
        return coincidencias;
    }

    /**
     *valida que la matriz de adn tenga un tamanio NxN
     * @param dna
     * @return true,false si la matriz es valida
     */
    public Boolean validarMatriz(AdnRequest dna){
        Boolean esValida = true;
        int longitud = dna.getDna().length;
        for (String a:dna.getDna()) {
            if(a.length() != longitud){
                esValida = false;
                break;
            }
        }
        return esValida;
    }

    /**
     * valida que la matriz de adn contenga solo los caracteres (A,T,C,G)
     * @param dna
     * @return true,false si la matriz es valida
     */
    public Boolean validarBaseNitrogenada(AdnRequest dna){
        Boolean esValida = true;
        Pattern pat = Pattern.compile("(A|T|C|G)+");
        for (String a:dna.getDna()) {
            Matcher mat = pat.matcher(a.toUpperCase());
            if (mat.matches()==false) {
                esValida = false;
                break;
            }
        }
        return esValida;
    }
}
