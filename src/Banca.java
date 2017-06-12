package com.T2IntroES;

/**
 * Created by Octavio on 5/31/2017.
 */
public class Banca {
    private Carta furo;
    private Carta gameCard;
    private int count;
    private int current;

    private Baralho baralho;

    public Banca(Baralho baralho) {
        this.baralho = baralho;
        count  = baralho.getSize();
        current  = 0;
    }

    // Pega a primeira carta disponivel se o baralho nao "acabou"
    public Carta getCarta(){
        return null;
    }

    // Jogada hold, Se a banca começa com uma carta de valor 10 ou um ás na gameCard
    // a banca permite aos jogadores "segurarem" sua mão contra um possível blackjack
    public boolean hold(){
        boolean hold = false;
        return hold;
    }

}

