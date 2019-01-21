//package com.T2IntroES;
package VinteUm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe que implementa a lógica do jogo Blackjack
 * @author Guilherme Munaretto
 * @author Octavio Carpez
 */
public class Blackjack {
    private static int scoreB = 0;
    private static int scoreJ = 0;
    private Jogador jogador;
    private Baralho baralho;
    private Banca banca;

    /**
     * Método construtor da classe Blackjack
     */
    public Blackjack(){
        this.jogador = new Jogador();
        this.baralho = new Baralho();
        this.banca = new Banca(baralho);
        iniciaJogo();
    }

    /**
     * Retorna uma referência para o jogador da partida
     * @return Uma referência para o jogador da partida
     */
    public Jogador getJogador(){
        return this.jogador;
    }

    /**
     * Retorna uma referência para o dealer da partida
     * @return Uma referência para o dealer da partida
     */
    public Banca getBanca(){
        return this.banca;
    }


    /**
     * Faz a jogada de "hit", responsável por pedir mais cartas
     * @param c A carta a ser adicionada na mão do jogador
     */
    public void hit(Carta c){
        // Adiciona a carta na mão atual
        jogador.getPrimeiraMao().getMao().add(c);
        // Calcula os pontos do jogador ja com a nova carta em sua mão

        if (jogador.getPrimeiraMao().getPontos() > 21){
            jogador.setIsPlaying(false);
        }
    }

    /**
     * Faz uma jogada de "hit" para a banca (Pede uma carta do baralho da banca)
     * @param c A carta a ser adicionada na mão da banca
     */
    private void hitBanca(Carta c){
        // Adiciona a carta na mão atual
        banca.getMao().getMao().add(c);
        // Calcula os pontos do jogador ja com a nova carta em sua mão
        if (banca.getMao().getPontos() > 21){
            banca.setIsPlaying(false);
        }
    }

    /**
     * Faz a jogada stand
     */
    public void stand(){

        // Caso a banca tenha mais pontos que o jogador e não tenha estourado 21 pontos, então ela é o vencedor
        if (banca.getMao().getPontos() > jogador.getPrimeiraMao().getPontos()){
            jogador.setIsPlaying(false);
            return;

        }
        // Caso o jogador tenha mais pontos que a banca e não tenha estourado 21 pontos, a banca deve comprar mais cartas
        else if (jogador.getPrimeiraMao().getPontos() > banca.getMao().getPontos()){
            // Enquanto a banca estiver jogando e tiver menos de 7 cartas na mão
            while(banca.getCount() <= 7 && banca.getIsPlaying()){
                // Compra uma nova carta do baralho
                hitBanca(banca.getBaralho().getCartas().remove(0));
                // Se após comprar, a banca possui mais pontos do que o jogador sem estourar o limite de 21, então ela venceu
                if (banca.getMao().getPontos() > jogador.getPrimeiraMao().getPontos() && banca.getMao().getPontos() <= 21){
                    jogador.setIsPlaying(false);
                    return;
                }
                // Se a banca estourou o limite de 21 pontos, então ela perdeu
                if(banca.getMao().getPontos() > 21){
                    banca.setIsPlaying(false);
                    return;
                }
            }
            banca.setIsPlaying(false);
        }
        // Caso ambos tenham um blackjack, então da empate
        else if(jogador.getPrimeiraMao().getPontos() == 21 && banca.getMao().getPontos() == 21){
            jogador.setIsPlaying(false);
            banca.setIsPlaying(false);
        }

    }

    /**
     * Realiza a jogada "surrender", fazendo o jogador desistir da partida e o dealer ser o vencedor
     */
    public void surrender(){
        jogador.setIsPlaying(false);
    }

    /**
     * Verifica e retorna o ganhador de uma rodada
     * @return Uma string contendo um texto indicativo sobre o vencedor da rodada
     */
    private String verificaGanhador(){
        if(jogador.getIsPlaying()){
            if (banca.getMao().getPontos() == 21){
                jogador.setIsPlaying(false);
            }
            if (banca.getMao().getPontos() == 21 && jogador.getPrimeiraMao().getPontos() == 21) {
                return "Empate";
            }
            if (banca.getMao().getPontos() > 21){
                banca.setIsPlaying(false);
            }
            if(jogador.getPrimeiraMao().getPontos() == 21){
                banca.setIsPlaying(false);
            }
            if(jogador.getPrimeiraMao().getPontos() > 21){
                jogador.setIsPlaying(false);
            }
        }

        // Caso de empate
        if (!jogador.getIsPlaying() && !banca.getIsPlaying()){
            return "Empate";
        }
        // Caso o jogador tenha vencido
        else if (jogador.getIsPlaying() && !banca.getIsPlaying()){
            return "Blackjack.Jogador";
        }
        // Caso a mesa tenha vencido
        else if(!jogador.getIsPlaying() && banca.getIsPlaying()){
            return "Dealer";
        }
        else{
            return "Ok";
        }
    }

    /**
     * Método que executa a lógica de uma rodada no jogo 21
     * @param jogada é a próxima jogada que o jogador deseja executar
     * @return Uma string contendo o status atual do jogo
     */
    public String rodada(String jogada){

        String statusJogo = verificaGanhador();
        // Verifica se o jogo ja terminou no inicio
        if(!statusJogo.equals("Ok")){
            return statusJogo;
        }


        // Caso a jogada seja um hit
        if(jogada.equals("hit")){
            // Verifica o status do jogo (antes de fazer a jogada)
            statusJogo = verificaGanhador();
            // Se for diferente de "ok", retorna o nome do vencedor
            if(!statusJogo.equals("Ok")){
                return statusJogo;
            }

            // Da uma carta ao jogador
            hit(banca.getBaralho().getCartas().remove(0));

            // Verifica o status do jogo (depois de fazer a jogada)
            statusJogo = verificaGanhador();
            mostraCartas();
            // Se for diferente de "ok", retorna o nome do vencedor
            if(!statusJogo.equals("Ok")){
                return statusJogo;
            }
        }

        // Caso a jogada seja um stand
        else if(jogada.equals("stand")){
            // Verifica o status do jogo (antes de fazer a jogada)
            statusJogo = verificaGanhador();
            // Se for diferente de "ok", retorna o nome do vencedor
            if(!statusJogo.equals("Ok")){
                return statusJogo;
            }

            stand();

            // Verifica o status do jogo (antes de fazer a jogada)
            statusJogo = verificaGanhador();
            mostraCartas();
            // Se for diferente de "ok", retorna o nome do vencedor
            if(!statusJogo.equals("Ok")){
                return statusJogo;
            }

        }

        // Caso a jogada seja um surrender
        else if (jogada.equals("surrender")){
            mostraCartas();
            return "Surrender";
        }
        
        else if(jogada.equals("score")){
            amostraScore();
        }

        // Caso o jogador deseje salvar o progresso atual
        else if(jogada.equals("save")){
            salvaJogo();
        }
        
        // Caso o jogador decida carregar um jogo salvo
        else if(jogada.equals("load")){
            try {
                carregaJogo();
            } catch (Exception e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
        
        // Caso o jogador decida sair do jogo
        else if(jogada.equals("quit")){
            System.out.print("Você deseja salvar o seu progresso? [sim/nao]");
            Scanner in = new Scanner(System.in);
            boolean flag = false;
            while(!flag){
                String opcao = in.next();
                if(opcao.equals("sim") || opcao.equals("nao")){
                    if (opcao.equals("sim")){
                        salvaJogo();
                        flag = true;
                    }
                    else{
                        flag = true;
                    }
                }
            }
            System.exit(0);
        }
        else {
            System.out.println("Comando Inválido. Por favor, digite uma jogada válida.");
        }
        return "";
    }

    /**
     * Método que distribui as cartas iniciais e inicia o jogo
     */
    private String iniciaJogo(){
        // Se as mãos da banca e do jogador estiverem vazias, dou as cartas iniciais
        if (jogador.getPrimeiraMao().getMao().size() == 0 && banca.getMao().getMao().size() == 0){
            // Retira 2 cartas do baralho da banca e adiciona na mão do jogador
            jogador.getPrimeiraMao().getMao().add(banca.getBaralho().getCartas().remove(0));
            jogador.getPrimeiraMao().getMao().add(banca.getBaralho().getCartas().remove(0));
            // Retira 2 cartas do baralho da banca e adiciona na mão da banca
            banca.getMao().getMao().add(banca.getBaralho().getCartas().remove(0));
            banca.getMao().getMao().add(banca.getBaralho().getCartas().remove(0));
        }
        // Verificando se há um ganhador no inicio da partida
        String status = verificaGanhador();
        // Se o status for diferente de Ok, retorna ele mesmo
        if (!status.equals("Ok")){
            return status;
        }
        return "";
    }
    
    public void aumentaScoreB(){
        scoreB++;
    }
    
    public void aumentaScoreJ(){
        scoreJ++;
    }
    
    public void carregaScoreB(int score){
        scoreB = score;
    }
    
    public void carregaScoreJ(int score){
        scoreJ = score;
    }
    
    public void amostraScore(){
        System.out.println("\n");
        System.out.println("SCORE TOTAL");
        System.out.println("===========");
        System.out.println("BANCA: " + scoreB);
        System.out.println("JOGADOR: " + scoreJ);
    }

    /**
     * Imprime no console as cartas contidas na mão do dealer e do jogador
     * @requires
     */
    public void mostraCartas(){
        int player = 0;
        // Imprime as cartas da mão do jogador
        System.out.println("--------------------------------------------------------------");
        System.out.println("Mão do Jogador: ");
        for(Carta c : jogador.getPrimeiraMao().getMao()){
            System.out.println("["+c.getValor()+" de "+c.getNaipe()+"]");
            player += c.getValorNumerico();
        }
        System.out.println("Total de Pontos do Jogador: " + player);
        System.out.println("--------------------------------------------------------------");

        System.out.println("");

        // Imprime as cartas da mão do dealer
        System.out.println("--------------------------------------------------------------");

        System.out.println("Mão do Dealer: ");
        int dealer = 0;
        for(Carta c : banca.getMao().getMao()){
            System.out.println("["+c.getValor()+" de "+c.getNaipe()+"]");
            dealer += c.getValorNumerico();
        }
        System.out.println("Total de Pontos da Banca : " + dealer);
        System.out.println("--------------------------------------------------------------");
    }

    /**
     * Método utilizado no final de cada partida para imprimir em um arquivo o vencedor e a sua quantia de pontos
     */
    public void salvaJogo() {

        try {


            File file = new File("progresso.txt");
            BufferedWriter br = new BufferedWriter(new FileWriter(file));

            //TODO Padrão; J:PontosJogador
            //TODO Naipe1;Carta1
            //TODO ...
            //TODO (espaço em branco)

            //TODO Padrão; B:PontosBanca
            //TODO Naipe1;Carta1
            //TODO ...
            //TODO (espaço em branco)

            br.write("J " + scoreJ);
            br.newLine();
            for (Carta c : jogador.getPrimeiraMao().getMao()) {
                br.write(c.getNaipe() + " " + c.getValor());
                br.newLine();
            }
            
            br.write("Separar");
            br.newLine();
            
            br.write("B " + scoreB);
            br.newLine();
            for (Carta c : banca.getMao().getMao()) {
                br.write(c.getNaipe() +" "+ c.getValor());
                br.newLine();
            }
            
            br.write("Separar");
            br.newLine();
            
            for(int i = 0; i < baralho.getSize(); i++){
                br.write(baralho.getCartas().get(i).getNaipe() + " " + baralho.getCartas().get(i).getValor());
                br.newLine();
            }
            br.write("End This");
            
            br.flush();
            br.close();
            System.out.println("PROGRESSO SALVO COM SUCESSO!!!");
            System.out.println("");
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }
    }


    public void carregaJogo() throws FileNotFoundException{
        File file = new File("progresso.txt");
        Scanner in = new Scanner(file);
        banca.limpaMao();
        jogador.limpaMao();
        baralho.limpaCartas();
        while(in.hasNextLine()){
            String linha = in.nextLine();
            String[] linhaS = linha.split(" ");
            if(linhaS[0].equals("J")){
                carregaScoreJ(Integer.parseInt(linhaS[1]));
                linha = in.nextLine();
                while(!linha.equals("Separar")){
                    linhaS = linha.split(" ");
                    if(linhaS[1].equals("K") || (linhaS[1].equals("J")) ||
                      (linhaS[1].equals("Q"))){
                        Carta c = new Carta(linhaS[0],linhaS[1],10);
                        jogador.getPrimeiraMao().getMao().add(c);
                    }else if(linhaS[1].equals("A")){
                        Carta c = new Carta(linhaS[0],linhaS[1],1);
                        jogador.getPrimeiraMao().getMao().add(c);
                    }else{
                        Carta c = new Carta(linhaS[0],linhaS[1],Integer.parseInt(linhaS[1]));
                        jogador.getPrimeiraMao().getMao().add(c);
                    }
                    linha = in.nextLine();
                }
            }
            else if(linhaS[0].equals("B")){
                carregaScoreB(Integer.parseInt(linhaS[1]));
                linha = in.nextLine();
                while(!linha.equals("Separar")){
                    linhaS = linha.split(" ");
                    if(linhaS[1].equals("K") || (linhaS[1].equals("J")) ||
                      (linhaS[1].equals("Q"))){
                        Carta c = new Carta(linhaS[0],linhaS[1],10);
                        banca.getMao().getMao().add(c);
                    }else if(linhaS[1].equals("A")){
                        Carta c = new Carta(linhaS[0],linhaS[1],1);
                        banca.getMao().getMao().add(c);
                    }else{
                        Carta c = new Carta(linhaS[0],linhaS[1],Integer.parseInt(linhaS[1]));
                        banca.getMao().getMao().add(c);
                    }
                    linha = in.nextLine();
                }
            }
            else{
                if(linhaS[0].equals("End")) break;
                if(linhaS[1].equals("K") || (linhaS[1].equals("J")) ||
                  (linhaS[1].equals("Q"))){
                    Carta c = new Carta(linhaS[0],linhaS[1],10);
                    baralho.getCartas().add(c);
                }else if(linhaS[1].equals("A")){
                    Carta c = new Carta(linhaS[0],linhaS[1],1);
                    baralho.getCartas().add(c);
                }else{
                    Carta c = new Carta(linhaS[0],linhaS[1],Integer.parseInt(linhaS[1]));
                    baralho.getCartas().add(c);
                }
            }
        }
        Collections.reverse(jogador.getPrimeiraMao().getMao());
        Collections.reverse(banca.getMao().getMao());
        Collections.reverse(baralho.getCartas());
        System.out.println("");
        System.out.println("JOGO CARREGADO COM SUCESSO!!!");
        System.out.println("");
    }


    /**
     * Método que reseta o estado da partida
     */
    public void reset(){
            this.jogador = new Jogador();
            this.baralho = new Baralho();
            this.banca = new Banca(baralho);
            iniciaJogo();
    }

}