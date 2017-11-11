package br.com.caelum.vraptor.seguranca;

import javax.inject.Inject;

import br.com.caelum.vraptor.controller.LoginController;
import br.com.caelum.vraptor.seguranca.Open;
import br.com.caelum.vraptor.seguranca.UsuarioLogado;
import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@Intercepts
public class AutorizacaoInterceptor {
	private UsuarioLogado usuarioLogado;
	private Result result;
	private ControllerMethod method;
	
	public AutorizacaoInterceptor() {
		// TODO Auto-generated constructor stub... construtor sem argumentos... aula3 20m52s
	}
	
	@Inject
	public AutorizacaoInterceptor(UsuarioLogado usuarioLogado, Result result, ControllerMethod method){
		this.result = result;
		this.usuarioLogado = usuarioLogado;
		this.method = method;
	}
	
	@Accepts
	public boolean accept(){
		return !method.containsAnnotation(Open.class);
		
	}
	
	@AroundCall
	public void intercept(SimpleInterceptorStack stack){
		if (usuarioLogado.islogado()){
		stack.next(); //se o usuário estiver logado
		}else{
			result.redirectTo(LoginController.class).form();
		}
	}

}
