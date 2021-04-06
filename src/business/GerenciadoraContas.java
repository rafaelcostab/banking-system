package business;

import java.util.List;

/**
 * Classe de neg�cio para realizar opera��es sobre as contas do banco.
 * @author Gustavo Farias
 */
public class GerenciadoraContas {

	private List<CurrentAcount> contasDoBanco;

	public GerenciadoraContas(List<CurrentAcount> contasDoBanco) {
		this.contasDoBanco = contasDoBanco;
	}

	/**
	 * Retorna uma lista com todas as contas do banco.
	 * @return lista com todas as contas do banco
	 */
	public List<CurrentAcount> getContasDoBanco() {
		return contasDoBanco;
	}

	/**
	 * Pesquisa por uma conta a partir do seu ID.
	 * @param idConta id da conta a ser pesquisada
	 * @return a conta pesquisada ou null, caso n�o seja encontrada
	 */
	public CurrentAcount pesquisaConta (int idConta) {

		for (CurrentAcount currentAcount : contasDoBanco) {
			if(currentAcount.getId() == idConta)
				return currentAcount;
		}
		return null;
	}
	
	/**
	 * Adiciona uma nova conta � lista de contas do banco.
	 * @param novaConta nova conta a ser adicionada
	 */
	public void adicionaConta (CurrentAcount novaConta) {
		this.contasDoBanco.add(novaConta);
	}

	/**
	 * Remove conta da lista de contas do banco.
	 * @param idConta ID da conta a ser removida 
	 * @return true se a conta foi removida. False, caso contr�rio.
	 */
	public boolean removeConta (int idConta) {
		
		boolean contaRemovida = false;
		
		for (int i = 0; i < contasDoBanco.size(); i++) {
			CurrentAcount conta = contasDoBanco.get(i);
			if(conta.getId() == idConta){
				contasDoBanco.remove(i);
				break;
			}
		}
		
		return contaRemovida;
	}

	/**
	 * Informa se uma determinada conta est� ativa ou n�o.
	 * @param idConta ID da conta cujo status ser� verificado
	 * @return true se a conta est� ativa. False, caso contr�rio. 
	 */
	public boolean contaAtiva (int idConta) {
		
		boolean contaAtiva = false;
		
		for (int i = 0; i < contasDoBanco.size(); i++) {
			CurrentAcount conta = contasDoBanco.get(i);
			if(conta.getId() == idConta)
				if(conta.isActive()){
					contaAtiva = true;
					break;
				}
		}
		
		return contaAtiva;
	}
	
	/**
	 * Transfere um determinado valor de uma conta Origem para uma conta Destino.
	 * Caso n�o haja saldo suficiente, o valor n�o ser� transferido.
	 * 
	 * @param idContaOrigem conta que ter� o valor deduzido
	 * @param valor valor a ser transferido
	 * @param idContaDestino conta que ter� o valor acrescido
	 * @return true, se a transfer�ncia foi realizada com sucesso.
	 */
	public boolean transfereValor (int idContaOrigem, double valor, int idContaDestino) {
		
		boolean sucesso = false;
		
		CurrentAcount contaOrigem = pesquisaConta(idContaOrigem);
		CurrentAcount contaDestino = pesquisaConta(idContaDestino);
		
//		if(contaOrigem.getSaldo() >= valor){
			contaDestino.setBalance(contaDestino.getBalance() + valor);
			contaOrigem.setBalance(contaOrigem.getBalance() - valor);
			sucesso = true;
//		}
	
		return sucesso;
	}
	
}
