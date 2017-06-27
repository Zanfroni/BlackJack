package VinteUm;//package com.T2IntroES;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe responsável pela interface com o usuário.
 * @author Guilherme Munaretto
 * @author Octavio Carpez
 */
public class Main {

    private static String trigger;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("-#-# Bem-vindo ao 21! -#-#");
        System.out.println("");
        System.out.println("");
        Scanner in = new Scanner(System.in);
        System.out.println("PRESSIONE UM BOTÃO PARA CONTINUAR");
        String l = in.nextLine();
        String comando = exibeInicio();
        if(comando.equals("quit")){
            System.out.println("");
            System.out.println("");
            System.out.println("Saindo....");
            System.exit(0);
        }
        Blackjack bj= new Blackjack();
        if(comando.equals("load")) bj.carregaJogo();
        
        while(true){
            System.out.println("");
            System.out.println("PRESSIONE UM BOTÃO PARA CONTINUAR");
            trigger = in.nextLine();
            System.out.println("\n\n\n\n\n");
            bj.mostraCartas();
            String jogada = exibeMenu();
            String status = bj.rodada(jogada);
            int pontosBanca = bj.getBanca().getMao().getPontos();
            int pontosJogador = bj.getJogador().getPrimeiraMao().getPontos();

            // Caso a mesa tenha vencido
            if (status.equals("Dealer")){
                System.out.println("A mesa é a vencedora, com "+pontosBanca+" pontos a "+pontosJogador);
                bj.reset();
                bj.aumentaScoreB();
                bj.amostraScore();
                continue;
            }
            //Caso o jogador desista
            if (status.equals("Surrender")){
                System.out.println("A mesa é a vencedora por desistência do jogador");
                bj.reset();
                bj.aumentaScoreB();
                bj.amostraScore();
                continue;
            }
            // Caso o jogador tenha vencido
            else if (status.equals("Blackjack.Jogador")){
                System.out.println("O jogador é o vencedor, com "+pontosJogador+" pontos a "+pontosBanca);
                bj.reset();
                bj.aumentaScoreJ();
                bj.amostraScore();
                continue;
            }
            // Caso tenha dado empate
            else if(status.equals("Empate")){
                System.out.println("O jogo terminou empatado!");
                bj.amostraScore();
                bj.reset();
                continue;
            }
        }
    }
    
    private static String exibeInicio(){
        while(true){
            System.out.println("---------------------------- O que desejas fazer --------------------------------");
            System.out.println("");
            System.out.println("[new] - inicia um novo jogo");
            System.out.println("[load] - carrega um jogo já existente");
            System.out.println("[quit] - sair do jogo");
            Scanner in = new Scanner(System.in);
            String order = in.nextLine().toLowerCase();
            if((order.equals("new")) || (order.equals("load")) || (order.equals("quit"))){
                System.out.println("\n\n\n\n\n");
                return order;
            }
            System.out.println("");
            System.out.println("AVISO!!!");
            System.out.println("Comando inexistente, tente novamente!!!");
            System.out.println("PRESSIONE UM BOTÃO PARA CONTINUAR");
            String trigger = in.nextLine();
            System.out.println("\n\n\n\n\n");
        }
    }

    private static String exibeMenu(){
        while(true){
            System.out.println("---------------------------- Escolha a sua jogada --------------------------------");
            System.out.println("");
            System.out.println("[hit] - Pede à banca mais uma carta do baralho");
            System.out.println("[stand] - Encerra a rodada. Os pontos então são computados e um vencedor é declarado");
            System.out.println("[surrender] - Desiste da partida. O dealer é automaticamente declarado o vencedor");
            System.out.println("[score] - Amostra score atual");
            System.out.println("[save] - Salva o resultado da partida e os scores");
            System.out.println("[load] - carrega um jogo já existente");
            System.out.println("[quit] - Sai da partida");
            System.out.println("");
            System.out.println("-------------------------------------------------------------------------------------");
            Scanner in = new Scanner(System.in);
            String order = in.nextLine().toLowerCase();
            if((order.equals("hit")) || (order.equals("stand")) || (order.equals("surrender"))
                 || (order.equals("score")) || (order.equals("save")) || (order.equals("load"))
                 || (order.equals("quit"))){
                System.out.println("\n\n\n\n\n");
                return order;
            }
            System.out.print ('\f');
            System.out.println("");
            System.out.println("AVISO!!!");
            System.out.println("Comando inexistente, tente novamente!!!");
            System.out.println("PRESSIONE UM BOTÃO PARA CONTINUAR");
            System.out.println("");
            trigger = in.nextLine();
        }
    }
}