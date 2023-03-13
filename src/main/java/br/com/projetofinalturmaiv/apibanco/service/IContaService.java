package br.com.projetofinalturmaiv.apibanco.service;

import java.util.ArrayList;

import br.com.projetofinalturmaiv.apibanco.model.Conta;

public interface IContaService {
	public ArrayList<Conta> recuperarTodas();

	public Conta recuperarPeloId(int id);

	public Conta cadastrarNova(Conta conta);
}
