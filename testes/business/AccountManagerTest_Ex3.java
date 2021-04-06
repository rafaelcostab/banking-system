package business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AccountManagerTest_Ex3 {

	private AccountManager gerContas;
	
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
		gerContas.transferValue(1, 100, 2);
		
		/* ========== Verifica��es ========== */
		assertThat(conta02.getBalance(), is(100.0));
		assertThat(conta01.getBalance(), is(100.0));
	}

}
