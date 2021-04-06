package business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais opera��es
 * sobre contas, realizadas pela classe {@link AccountManager}.
 * 
 * @author Gustavo Farias
 * @date 21/01/2035 
 */
public class AccountManagerTest_Ex4 {

	private AccountManager gerContas;
	
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
		CurrentAccount conta01 = new CurrentAccount(1, 200, true);
		CurrentAccount conta02 = new CurrentAccount(2, 0, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<CurrentAccount> contasDoBanco = new ArrayList<>();
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		gerContas = new AccountManager(contasDoBanco);

		/* ========== Execu��o ========== */
		boolean sucesso = gerContas.transferValue(1, 100, 2);
		
		/* ========== Verifica��es ========== */
		assertTrue(sucesso);
		assertThat(conta02.getBalance(), is(100.0));
	}

}

// Documenta��o e coment�rios