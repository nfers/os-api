package com.nayara.os.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "technique")
public class Technique extends Person implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@OneToMany(mappedBy = "technique")
	private List<ServiceOrder> list = new ArrayList<>();
	
	public Technique() {
		super();

	}

	public Technique(Integer id, String name, String cpf, String phone) {
		super(id, name, cpf, phone);
	}

	public List<ServiceOrder> getList() {
		return list;
	}

	public void setList(List<ServiceOrder> list) {
		this.list = list;
	}

}
