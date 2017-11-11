package br.com.caelum.vraptor.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.caelum.vraptor.model.Usuario;

@RequestScoped
public class UsuarioDao {
private EntityManager manager;
	
	public UsuarioDao(){}
	
	@Inject
	public UsuarioDao(EntityManager manager){
		this.manager = manager;
		
	}
	
	public void adiciona(Usuario usuario){
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
	}
		
	public List<Usuario> lista(){
		TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u", Usuario.class);
		
		return query.getResultList();
	}

	public Usuario busca(String login, String senha) {
		try {
			TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u "
					+ " where u.login = :login and u.senha = :senha", Usuario.class);
			query.setParameter("login", login);
			query.setParameter("senha", senha);
			
			return query.getSingleResult();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

		
	}

}
