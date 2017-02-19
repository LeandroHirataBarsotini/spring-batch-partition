package br.com.teste.spring_batch.listeners;

import java.util.List;

import org.springframework.batch.core.ItemWriteListener;

import br.com.teste.spring_batch.model.Usuario;

public class CustomItemWriterListener implements ItemWriteListener<Usuario> {

	public void beforeWrite(List<? extends Usuario> items) {
		System.out.println("beforeWrite - total de linhas para escrver: " + items.size());
	}

	@Override
	public void afterWrite(List<? extends Usuario> items) {
		System.out.println("afterWrite - total de linhas escritas: " + items.size());
	}

	@Override
	public void onWriteError(Exception exception, List<? extends Usuario> items) {
		System.out.println("onWriteError: " + exception.getMessage());
	}
	
}
