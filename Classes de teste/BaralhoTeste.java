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
		//garanta que tenha 52 cartas no baralho
		//assertEquals(52, baralho.getCartas().size());
		/*
		 * Testes para ver se o baralho contém as cartas corretas.
		 * Como teste de exaustão não é algo prático, serão testados apenas
		 * se os valores extremos (A e K) e o meio termo (7) 
		 * junto com os quatro naipes estão presentes no baralho
		 */
		//Carta c1 = new Carta("Copas", "A", 1);
		//Carta c2 = new Carta("Copas", "7", 7);
		//Carta c3 = new Carta("Copas", "K", 10);
		//Carta c4 = new Carta("Espada", "A", 1);
		//Carta c5 = new Carta("Espada", "7", 7);
		//Carta c6 = new Carta("Espada", "K", 10);
		//Carta c7 = new Carta("Ouro", "A", 1);
		//Carta c8 = new Carta("Ouro", "7", 7);
		//Carta c9 = new Carta("Ouro", "K", 10);
		//Carta c10 = new Carta("Paus", "A", 1);
		//Carta c11 = new Carta("Paus", "7", 7);
		//Carta c12 = new Carta("Paus", "K", 10);
		//assertTrue(baralho.getCartas().contains(c1));
	}

}
