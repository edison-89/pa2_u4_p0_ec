package com.uce.edu.demo.repository.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "persona")
@NamedQuery(name = "Persona.buscarPorCedula", query = "SELECT p FROM Persona p WHERE p.cedula = :datoCedula")
@NamedQuery(name = "Persona.buscarPorNombreApellido", query = "SELECT p FROM Persona p WHERE p.nombre = :datoNombre AND p.apellido = :datoApellido")

@NamedNativeQueries({
		@NamedNativeQuery(name = "Persona.buscarPorCedulaNative", query = "SELECT * FROM persona WHERE pers_cedula = :datoCedula", resultClass = Persona.class),
		@NamedNativeQuery(name = "Persona.buscarPorCedulaNativeApellido", query = "SELECT * FROM persona WHERE pers_cedula = :datoCedula", resultClass = Persona.class) })

public class Persona {

	@Id
	@Column(name = "pers_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pers_id_seq")
	@SequenceGenerator(name = "pers_id_seq", sequenceName = "pers_id_seq", allocationSize = 1)
	private Integer id;

	@Column(name = "pers_nombre")
	private String nombre;

	@Column(name = "pers_cedula")
	private String cedula;

	@Column(name = "pers_apellido")
	private String apellido;

	@Column(name = "pers_genero")
	private String genero;

	// SET y GET

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", cedula=" + cedula + ", apellido=" + apellido
				+ ", genero=" + genero + "]";
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
}
