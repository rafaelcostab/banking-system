package business;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GerenciadoraClientesTest_Ex1 {

	@Test
	public void testPesquisaCliente() {

		// criando alguns clientes
		Client client01 = new Client(1, "Gustavo Farias", 31, "gugafarias@gmail.com", 1, true);
		Client client02 = new Client(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2, true);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Client> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(client01);
		clientesDoBanco.add(client02);
		
		ClientManager gerClientes = new ClientManager(clientesDoBanco);
		
		Client client = gerClientes.find(1);
		
		assertThat(client.getId(), is(1));
		assertThat(client.getEmail(), is("gugafarias@gmail.com"));
		
	}

}
