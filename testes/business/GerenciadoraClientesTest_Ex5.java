package business;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Classe de teste criada para garantir o funcionamento das principais opera��es
 * sobre clientes, realizadas pela classe {@link GerenciadoraClientes}.
 * 
 * @author Gustavo Farias
 * @date 21/01/2035 
 */
public class GerenciadoraClientesTest_Ex5 {

	private GerenciadoraClientes gerClientes;

	/**
	 * Teste b�sico da pesquisa de um cliente a partir do seu ID.
	 * 
	 * @author Gustavo Farias
	 * @date 21/01/2035
	 */
	@Test
	public void testPesquisaCliente() {

		/* ========== Montagem do cen�rio ========== */
		
		// criando alguns clientes
		int idCLiente01 = 1;
		int idCLiente02 = 2;
		Client client01 = new Client(idCLiente01, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Client client02 = new Client(idCLiente02, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Client> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(client01);
		clientesDoBanco.add(client02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);

		/* ========== Execu��o ========== */
		Client client = gerClientes.pesquisaCliente(idCLiente01);
		
		/* ========== Verifica��es ========== */
		assertThat(client.getId(), is(idCLiente01));
		
	}
	
	/**
	 * Teste b�sico da remo��o de um cliente a partir do seu ID.
	 * 
	 * @author Gustavo Farias
	 * @date 21/01/2035
	 */
	@Test
	public void testRemoveCliente() {

		/* ========== Montagem do cen�rio ========== */
		
		// criando alguns clientes
		int idCLiente01 = 1;
		int idCLiente02 = 2;
		Client client01 = new Client(idCLiente01, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Client client02 = new Client(idCLiente02, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 1, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Client> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(client01);
		clientesDoBanco.add(client02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
		/* ========== Execu��o ========== */
		boolean clienteRemovido = gerClientes.removeCliente(idCLiente02);
		
		/* ========== Verifica��es ========== */
		assertThat(clienteRemovido, is(true));
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		assertNull(gerClientes.pesquisaCliente(idCLiente02));
		
	}
	
}
