package com.T2IntroES;

/**
 * Created by Octavio on 5/30/2017.
 */
public class Carta {
    private String naipe;
    private String valor;

    public Carta(String naipe, String valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    public String getNaipe() {
        return naipe;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "naipe='" + naipe + '\'' +
                ", valor='" + valor + '\'' +
                '}';
    }
}
