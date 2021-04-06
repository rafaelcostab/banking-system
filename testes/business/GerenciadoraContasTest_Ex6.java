package business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais opera��es
 * sobre contas, realizadas pela classe {@link GerenciadoraContas}.
 * 
 * @author Gustavo Farias
 * @date 21/01/2035 
 */
public class GerenciadoraContasTest_Ex6 {

	private GerenciadoraContas gerContas;
	
	/**
	 * Teste b�sico da transfer�ncia de um valor da conta de um cliente para outro,
	 * estando ambos os clientes ativos e havendo saldo suficiente para tal transfer�ncia
	 * ocorrer com sucesso.
	 * 
	 * @author Gustavo Farias
	 * @date 21/01/2035
	 */
	@Test
	public void testTransfereValor() {

		/* ========== Montagem do cen�rio ========== */
		
		// criando alguns clientes
		int idConta01 = 1;
		int idConta02 = 2;
		CurrentAcount conta01 = new CurrentAcount(idConta01, 200, true);
		CurrentAcount conta02 = new CurrentAcount(idConta02, 0, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<CurrentAcount> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);

		/* ========== Execu��o ========== */
		boolean sucesso = gerContas.transfereValor(idConta01, 100, idConta02);
		
		/* ========== Verifica��es ========== */
		assertTrue(sucesso);
		assertThat(conta02.getBalance(), is(100.0));
		assertThat(conta01.getBalance(), is(100.0));
	}
	
	/**
	 * Teste b�sico da tentativa de transfer�ncia de um valor da conta de um cliente para outro
	 * quando n�o h� saldo suficiente.
	 * 
	 * @author Gustavo Farias
	 * @date 21/01/2035
	 */
	@Test
	public void testTransfereValor_SaldoInsuficiente() {

		/* ========== Montagem do cen�rio ========== */
		
		// criando alguns clientes
		int idConta01 = 1;
		int idConta02 = 2;
		CurrentAcount conta01 = new CurrentAcount(idConta01, 100, true);
		CurrentAcount conta02 = new CurrentAcount(idConta02, 0, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<CurrentAcount> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new GerenciadoraContas(contasDoBanco);

		/* ========== Execu��o ========== */
		boolean sucesso = gerContas.transfereValor(idConta01, 200, idConta02);
		
		/* ========== Verifica��es ========== */
		assertTrue(sucesso);
		assertThat(conta01.getBalance(), is(-100.0));
		assertThat(conta02.getBalance(), is(200.0));
	}

}
//Manuten��o de Testes