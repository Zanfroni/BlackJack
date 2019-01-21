import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CartaTeste {

	private Carta carta;
	
	@Before
	public void iniciar(){
		carta = new Carta("Copas", "5", 5);
	}
	
	@Test
	public void ConstrutorTeste() {
		//garanta que a refer�ncia criada n�o seja null
		assertNotNull(carta);
	}
	
	@Test
	public void getNaipeTeste(){
		//garanta que o m�todo retorne um objeto n�o vazio
		assertNotNull(carta.getNaipe());
		//garanta que o retorno seja igual ao naipe passado por parametro
		assertEquals("Copas", carta.getNaipe());
	}
	
	@Test
	public void getValorTeste(){
		//garanta que o m�todo retorne um objeto n�o vazio
		assertNotNull(carta.getValor());
		//garanta que o retorno seja igual ao naipe passado por parametro
		assertEquals("5", carta.getValor());
	}
	
	@Test
	public void getValorNumericoTeste(){
		//garanta que o retorno seja igual ao naipe passado por parametro
		assertEquals(5, carta.getValorNumerico());
	}



}
