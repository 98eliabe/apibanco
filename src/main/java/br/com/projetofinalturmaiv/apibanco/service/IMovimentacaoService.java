package br.com.projetofinalturmaiv.apibanco.service;

import java.util.ArrayList;

import br.com.projetofinalturmaiv.apibanco.model.Movimentacao;

public interface IMovimentacaoService {

	public Movimentacao cadastrarNova(Movimentacao nova);

	public ArrayList<Movimentacao> recuperarTodas();

}
