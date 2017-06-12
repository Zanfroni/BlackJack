package com.T2IntroES;

import java.util.ArrayList;

/**
 * Created by Octavio on 5/31/2017.
 */
public class Jogador {
    private Carta[] mao;
    private Carta[] segundaMao;

    public Jogador() {
    }

    // Recebe a mão da banca
    public void receberMao(Carta c1, Carta c2){

    }

    // Continua a pedir cartas
    public void hit(){

    }

    //Para de receber cartas
    public void stand(){

    }

    // jogada Split:
    // Se as primeiras 2 cartas do jogador forem de valores iguais, ele pode escolher
    // dividir suas cartas em 2 mãos diferentes então ele pode jogar com as 2 mãos.
    // se ele estoura uma mão ele não sai do jogo, pode jogar até estourar a segunda mão

    // Sai do jogo
    public void surrender(){

    }
}
