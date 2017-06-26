import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class BaralhoTeste {
	
	private Baralho baralho;
	
	@Before
	public void iniciar(){
		baralho = new Baralho();
	}

	@Test
	public void construtorTeste() {
		//garanta que a referência criada não seja null
		assertNotNull(baralho);
	}
	
	@Test
	public void getSizeTeste(){
		assertEquals(52, baralho.getSize());
	}
	
	@Test
	public void getCartasTeste(){
		assertNotNull(baralho.getCartas());
	}
	
	@Test
	public void fillTeste() {
		ArrayList<Carta> cards = baralho.getCartas();
		//garanta que tenha 52 cartas no baralho
		assertEquals(52, cards.size());
		/*
		 * Testes para ver se o baralho contém as cartas corretas.
		 * Devido a aleatoriedade do método shuffle, esse teste só irá funcionar
		 * se o método shuffle estiver "comentado" no construtor do Baralho
		 */
		String[] naipes = {"Copas", "Espada", "Ouro", "Paus"};
        	String[] valores = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        	int indexNaipes = 0;
        	int indexValores = 0;
		for(int i = 0; i < 52; i++){
			if (indexValores == 13){
               		 	indexNaipes++;
               		 	indexValores = 0;
           		 }
            		if(indexNaipes == 4) break;
            		//Garanta que o naipe seja igual
           		 assertTrue(cards.get(i).getNaipe().equals(naipes[indexNaipes]));
            		//Garanta que o valor numérico seja igual
            		assertTrue(cards.get(i).getValor().equals(valores[indexValores]));
           		 indexValores++;
		}
	}
}
