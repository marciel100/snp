package br.com.caelum.vraptor.seguranca;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.caelum.vraptor.model.Usuario;

@Named
@SessionScoped
public class UsuarioLogado {
private Usuario usuario;
	
	public void fazLogin(Usuario usuario){
		 this.usuario = usuario;
	}
	
	public void desloga(){
		this.usuario = null;
	}
	
	public boolean islogado(){
		return this.usuario != null;
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
