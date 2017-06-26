package Blackjack;//package com.T2IntroES;

/**
 * Classe responsável por armazenar as informações pertinentes à carta
 * @author Guilherme Munaretto
 * @author Octavio Carpez
 */
public class Carta {
    private String naipe;
    private String valor;
    private int valorNumerico;

    public Carta(String naipe, String valor, int valorNumerico) {
        this.naipe = naipe;
        this.valor = valor;
        this.valorNumerico = valorNumerico;
    }

    /**
     * Retorna uma String contendo o naipe da carta
     * @return Uma String contendo o naipe da carta
     */
    public String getNaipe() {
        return naipe;
    }

    /**
     * Retorna uma String contendo o valor da carta
     * @return Uma String contendo o valor da carta
     */
    public String getValor() {
        return valor;
    }

    /**
     * Retorna um inteiro contendo o valor numérico da carta
     * @return Um inteiro contendo o valor numérico da carta
     */
    public int getValorNumerico(){ return valorNumerico; }

    /**
     * Atualiza o valor numérico de uma carta de acordo com o inteiro passado por parâmetro
     * @param valor O valor pelo qual deverá ser atualizado o valor numérico da carta
     */
    public void setValorNumerico(int valor){
        this.valorNumerico = valor;
    }

}
