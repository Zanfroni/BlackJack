//package com.T2IntroES;

import java.util.Scanner;

/**
 * Classe responsável pela interface com o usuário.
 * @author Guilherme Munaretto
 * @author Octavio Carpez
 */
public class Main {
    private static Blackjack bj= new Blackjack();

    public static void main(String[] args) {
        System.out.println("-#-# Bem-vindo ao 21! -#-#");
        System.out.println("");
        System.out.println("");

        while(true){

            String jogada = exibeMenu();
            String status = bj.rodada(jogada);
            int pontosBanca = bj.getBanca().getMao().getPontos();
            int pontosJogador = bj.getJogador().getPrimeiraMao().getPontos();

            // Caso a mesa tenha vencido
            if (status.equals("Dealer")){
                System.out.println("A mesa é a vencedora, com "+pontosBanca+" pontos a "+pontosJogador);
                bj.salvaJogo("Dealer",pontosBanca);
                break;
            }
            // Caso o jogador tenha vencido
            else if (status.equals("Jogador")){
                System.out.println("O jogador é o vencedor, com "+pontosJogador+" pontos a "+pontosBanca);
                bj.salvaJogo("Jogador",pontosJogador);
                break;
            }
            // Caso tenha dado empate
            else if(status.equals("Empate")){
                System.out.println("O jogo terminou empatado!");
                bj.salvaJogo("Empate",0);
                break;
            }
        }


    }

    private static String exibeMenu(){
        System.out.println("---------------------------- Escolha a sua jogada --------------------------------");
        System.out.println("");
        System.out.println("[hit] - Pede à banca mais uma carta do baralho");
        System.out.println("[stand] - Encerra a rodada. Os pontos então são computados e um vencedor é declarado");
        System.out.println("[surrender] - Desiste da partida. O dealer é automaticamente declarado o vencedor");
        System.out.println("");
        System.out.println("-------------------------------------------------------------------------------------");

        Scanner in = new Scanner(System.in);
        //TODO tratar recebimento de parâmetro incorreto
        String order = in.nextLine();
        return order;
    }
}
