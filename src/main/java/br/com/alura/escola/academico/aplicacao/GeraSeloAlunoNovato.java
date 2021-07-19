package br.com.alura.escola.academico.aplicacao;

import br.com.alura.escola.academico.dominio.aluno.AlunoMatriculado;
import br.com.alura.escola.gamificacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gamificacao.dominio.selo.Selo;
import br.com.alura.escola.shared.dominio.CPF;
import br.com.alura.escola.shared.dominio.evento.Evento;
import br.com.alura.escola.shared.dominio.evento.Ouvinte;
import br.com.alura.escola.shared.dominio.evento.TipoDeEvento;

public class GeraSeloAlunoNovato extends Ouvinte {
	
	private final RepositorioDeSelos repositorioDeSelos;

	public GeraSeloAlunoNovato(RepositorioDeSelos repositorioDeSelos) {
		this.repositorioDeSelos = repositorioDeSelos;
	}

	protected void reageAo(Evento evento) {
		CPF cpfDoAluno = (CPF) evento.informacoes().get("cpf");
		Selo novato = new Selo(cpfDoAluno, "Novato");
		repositorioDeSelos.adicionar(novato);
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		//return evento instanceof AlunoMatriculado;
		return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
	}

}
