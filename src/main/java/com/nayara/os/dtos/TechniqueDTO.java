package com.nayara.os.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;

import com.nayara.os.domain.Technique;

public class TechniqueDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@NotEmpty(message = "Campo nome precisa ser informado")
	private String name;
	
	@NotEmpty(message = "Campo CPF precisa ser informado")
	@CPF
	private String cpf;

	@NotEmpty(message = "Campo Telefone precisa ser informado")
	private String phone;

	public TechniqueDTO() {
		super();
	
	}

	public TechniqueDTO(Technique obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
		this.cpf = obj.getCpf();
		this.phone = obj.getPhone();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public String getPhone() {
		return phone;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
