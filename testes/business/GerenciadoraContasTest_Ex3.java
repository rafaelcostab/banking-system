package business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraContasTest_Ex3 {

	private GerenciadoraContas gerContas;
	
	@Test
	public void testTransfereValor() {

		/* ========== Montagem do cen�rio ========== */
		
		// criando alguns clientes
		CurrentAcount conta01 = new CurrentAcount(1, 200, true);
		CurrentAcount conta02 = new CurrentAcount(2, 0, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<CurrentAcount> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);

		/* ========== Execu��o ========== */
		gerContas.transfereValor(1, 100, 2);
		
		/* ========== Verifica��es ========== */
		assertThat(conta02.getBalance(), is(100.0));
		assertThat(conta01.getBalance(), is(100.0));
	}

}
