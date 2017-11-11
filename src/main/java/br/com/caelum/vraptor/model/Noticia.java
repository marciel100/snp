package br.com.caelum.vraptor.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Noticia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	private String titulo;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Calendar publicacao;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Calendar vencimento;
	
	@NotEmpty
	private String resumo;
	
	@NotEmpty
	private String conteudo;
	
	@ManyToOne
	private Autor autor;
	
	@ManyToOne
	private Perfil perfil;

}
