package br.com.projetofinalturmaiv.apibanco.service;

import java.util.ArrayList;

import br.com.projetofinalturmaiv.apibanco.model.Movimentacao;

public interface IMovimentacaoService {

	public ArrayList<Movimentacao> recuperarTodas();

	public Movimentacao cadastrarNova(Movimentacao nova);

}
