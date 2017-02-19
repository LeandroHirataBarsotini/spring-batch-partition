package br.com.teste.spring_batch.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;

import br.com.teste.spring_batch.model.Usuario;

public class UsuarioProcessor implements ItemProcessor<Usuario, Usuario> {

	@Value("#{stepExecutionContext[name]}")
	private String threadName;

	@Override
	public Usuario process(Usuario item) throws Exception {

		System.out.println("(" + threadName + ")" + " processando : " + item.getCodigo() + " - " + item.getNome());

		return item;
	}

	public String getThreadName() {
		return threadName;
	}

	public void setThreadName(String threadName) {
		this.threadName = threadName;
	}

}
