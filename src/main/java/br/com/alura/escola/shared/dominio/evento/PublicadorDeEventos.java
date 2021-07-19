package br.com.alura.escola.shared.dominio.evento;

import java.util.List;
import java.util.ArrayList;


public class PublicadorDeEventos {
	
	private List<Ouvinte> ouvintes = new ArrayList<>();
	
	public void adicionar(Ouvinte ouvinte) {
		this.ouvintes.add(ouvinte);
	}
	
	public void publicar(Evento evento) {
		this.ouvintes.forEach(o -> {
			o.processa(evento);
		});
	}
}
