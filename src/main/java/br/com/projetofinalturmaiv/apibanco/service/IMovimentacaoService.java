package br.com.projetofinalturmaiv.apibanco.service;

import java.util.ArrayList;

import br.com.projetofinalturmaiv.apibanco.model.Conta;
import br.com.projetofinalturmaiv.apibanco.model.Movimentacao;

public interface IMovimentacaoService {

	public Movimentacao cadastrarNova(Movimentacao nova);

	public ArrayList<Movimentacao> recuperarTodasPorConta(Conta c);
	
	public boolean transferirValores(int contaOrigem, int contaDestino, double valor);

}
