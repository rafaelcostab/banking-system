package business;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais opera��es
 * sobre clientes, realizadas pela classe {@link ClientManager}.
 * 
 * @author Rafael Costa
 * @date 27/03/2021
 */
public class GerenciadoraClientesTest_Ex10 {

	private ClientManager gerClientes;
	private int idCLiente01 = 1;
	private	int idCLiente02 = 2;
	
	@Before
	public void setUp() {
	
		/* ========== Montagem do cen�rio ========== */
		
		// criando alguns clientes
		Client client01 = new Client(idCLiente01, "Rafael Costa", 31, "gugafarias@gmail.com", 1, true);
		Client client02 = new Client(idCLiente02, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Client> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(client01);
		clientesDoBanco.add(client02);
		
		gerClientes = new ClientManager(clientesDoBanco);
	}

	@After
	public void tearDown() {
		gerClientes.clear();
	}
	
	/**
	 * Teste b�sico da pesquisa de um cliente a partir do seu ID.
	 * 
	 * @author Rafael Costa
	 * @date 27/03/2021
	 */
	@Test
	public void testPesquisaCliente() {

		/* ========== Execu��o ========== */
		Client client = gerClientes.findClient(idCLiente01);
		
		/* ========== Verifica��es ========== */
		assertThat(client.getId(), is(idCLiente01));
		
	}
	
	/**
	 * Teste b�sico da pesquisa por um cliente que n�o existe.
	 * 
	 * @author Rafael Costa
	 * @date 27/03/2021
	 */
	@Test
	public void testPesquisaClienteInexistente() {

		/* ========== Execu��o ========== */
		Client client = gerClientes.findClient(1001);
		
		/* ========== Verifica��es ========== */
		assertNull(client);
		
	}
	
	/**
	 * Teste b�sico da remo��o de um cliente a partir do seu ID.
	 * 
	 * @author Rafael Costa
	 * @date 27/03/2021
	 */
	@Test
	public void testRemoveCliente() {
		
		/* ========== Execu��o ========== */
		boolean clienteRemovido = gerClientes.removeClient(idCLiente02);
		
		/* ========== Verifica��es ========== */
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getBankClients().size(), is(1));
		assertNull(gerClientes.findClient(idCLiente02));
		
	}
	
	/**
	 * Teste da tentativa de remo��o de um cliente inexistente.
	 * 
	 * @author Rafael Costa
	 * @date 27/03/2021
	 */
	@Test
	public void testRemoveClienteInexistente() {

	
		/* ========== Execu��o ========== */
		boolean clienteRemovido = gerClientes.removeClient(1001);
		
		/* ========== Verifica��es ========== */
		assertThat(clienteRemovido, is(false));
		assertThat(gerClientes.getBankClients().size(), is(2));
		
	}
	
	/**
	 * Valida��o da idade de um cliente quando a mesma est� no intervalo permitido.
	 * 
	 * @author Rafael Costa
	 * @throws AgeNotAllowedException
	 * @date 27/03/2021
	 */
	@Test
	public void testClienteIdadeAceitavel() throws AgeNotAllowedException {

		/* ========== Montagem do Cen�rio ========== */		
		Client client = new Client(1, "Gustavo", 25, "guga@gmail.com", 1, true);
		
		/* ========== Execu��o ========== */
		boolean idadeValida = gerClientes.validateAge(client.getAge());
		
		/* ========== Verifica��es ========== */
		assertTrue(idadeValida);	
	}
	
	/**
	 * Valida��o da idade de um cliente quando a mesma est� no intervalo permitido.
	 * 
	 * @author Rafael Costa
	 * @throws AgeNotAllowedException
	 * @date 27/03/2021
	 */
	@Test
	public void testClienteIdadeAceitavel_02() throws AgeNotAllowedException {

		/* ========== Montagem do Cen�rio ========== */		
		Client client = new Client(1, "Gustavo", 18, "guga@gmail.com", 1, true);
		
		/* ========== Execu��o ========== */
		boolean idadeValida = gerClientes.validateAge(client.getAge());
		
		/* ========== Verifica��es ========== */
		assertTrue(idadeValida);	
	}
	
	/**
	 * Valida��o da idade de um cliente quando a mesma est� no intervalo permitido.
	 * 
	 * @author Rafael Costa
	 * @throws AgeNotAllowedException
	 * @date 27/03/2021
	 */
	@Test
	public void testClienteIdadeAceitavel_03() throws AgeNotAllowedException {

		/* ========== Montagem do Cen�rio ========== */		
		Client client = new Client(1, "Gustavo", 65, "guga@gmail.com", 1, true);
		
		/* ========== Execu��o ========== */
		boolean idadeValida = gerClientes.validateAge(client.getAge());
		
		/* ========== Verifica��es ========== */
		assertTrue(idadeValida);	
	}
	
	/**
	 * Valida��o da idade de um cliente quando a mesma est� abaixo intervalo permitido.
	 * 
	 * @author Rafael Costa
	 * @throws AgeNotAllowedException
	 * @date 27/03/2021
	 */
	@Test
	public void testClienteIdadeAceitavel_04() throws AgeNotAllowedException {

		/* ========== Montagem do Cen�rio ========== */		
		Client client = new Client(1, "Gustavo", 17, "guga@gmail.com", 1, true);

		/* ========== Execu��o ========== */
		try {
			gerClientes.validateAge(client.getAge());
			fail();
		} catch (Exception e) {
			/* ========== Verifica��es ========== */
			assertThat(e.getMessage(), is(AgeNotAllowedException.MSG_IDADE_INVALIDA));
		}	
	}
	
	/**
	 * Valida��o da idade de um cliente quando a mesma est� acima intervalo permitido.
	 * 
	 * @author Rafael Costa
	 * @throws AgeNotAllowedException
	 * @date 27/03/2021
	 */
	@Test
	public void testClienteIdadeAceitavel_05() throws AgeNotAllowedException {
		
		/* ========== Montagem do Cen�rio ========== */		
		Client client = new Client(1, "Gustavo", 66, "guga@gmail.com", 1, true);
		/* ========== Execu��o ========== */
		try {
			gerClientes.validateAge(client.getAge());
			fail();
		} catch (Exception e) {
			/* ========== Verifica��es ========== */
			assertThat(e.getMessage(), is(AgeNotAllowedException.MSG_IDADE_INVALIDA));
		}	
	}
	
}

// Valores Limites