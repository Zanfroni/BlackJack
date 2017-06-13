//package T2/BlackJack;

import java.util.*;

/**
 * Classe responsável por realizar todas as operações pertinentes ao baralho
 * @author Guilherme Munaretto
 * @author Octavio Carpez
 */
public class Baralho {

    private ArrayList<Carta> baralho;

    /**
     * Método construtor da classe Baralho
     */
    public Baralho() {
        baralho = new ArrayList<Carta>();
        fill();
        // Embaralhando o baralho
        Collections.shuffle(baralho);
    }

    /**
     * Método privado que preenche o baralho com as cartas
     */
    private void fill(){
        // Verificando se o baralho não está completo
        if (baralho.size() >= 52){
            return;
        }

        String[] naipes = {"Copas", "Espada", "Ouro", "Paus"};
        String[] valores = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        int indexNaipes = 0;
        int indexValores = 0;


        // Enquanto ainda tenho naipes para inserir
        while(indexNaipes <= 3){
            // Se já inseri todas as cartas de um naipe, pula para o próximo
            if (indexValores == 13){
                indexNaipes++;
                indexValores = 0;
            }
            // Caso especial: Inserindo um Ás (valor default é 1)
            if(valores[indexValores].equals("A")){
                baralho.add(new Carta(naipes[indexNaipes],valores[indexValores],1));
                indexValores++;
            }
            // Caso especial: Inserindo um valete, rei ou dama (valor é 10)
            else if (valores[indexValores].equals("J") || valores[indexValores].equals("Q") || valores[indexValores].equals("K")){
                baralho.add(new Carta(naipes[indexNaipes],valores[indexValores],10));
                indexValores++;
            }else{
                baralho.add(new Carta(naipes[indexNaipes],valores[indexValores],Integer.parseInt(valores[indexValores])));
                indexValores++;
            }

        }
    }

    /**
     * Retorna uma referência para um objeto do tipo baralho
     * @return Uma referência para um objeto do tipo baralho
     */
    public ArrayList<Carta> getBaralho(){ return baralho;}

    /**
     * Retorna a quantidade de cartas no baralho
     * @return Um inteiro contendo a quantidade de cartas no baralho
     */
    public int getSize(){
        return baralho.size();
    }

}
