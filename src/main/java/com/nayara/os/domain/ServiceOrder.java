package com.nayara.os.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nayara.os.domain.enums.Priority;
import com.nayara.os.domain.enums.Status;

@Entity(name = "serviceorder")
public class ServiceOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy - HH:mm")
	private LocalDateTime created_at;
	
	@JsonFormat(pattern = "dd/MM/yyyy - HH:mm")
	private LocalDateTime closed_on;
	
	@NotEmpty(message = "Campo não pode ser vazio")
	private String obeservations;
	private Integer priority;
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "technique_id")
	private Technique technique;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public ServiceOrder() {
		
	}

	public ServiceOrder(Integer id, Priority priority, String obeservations, Status status, Technique technique, Client client) {
		super();
		this.id = id;
		this.setCreated_at(LocalDateTime.now());
		this.priority = (priority == null) ? 0 : priority.getCod();
		this.obeservations = obeservations;
		this.status = (status == null) ? 0 : status.getCod();
		this.technique = technique;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getClosed_on() {
		return closed_on;
	}

	public void setClosed_on(LocalDateTime closed_on) {
		this.closed_on = closed_on;
	}

	public Priority getPriority() {
		return Priority.toEnum(this.priority);
	}

	public void setPriority(Priority priority) {
		this.priority = priority.getCod();
	}

	public String getObeservations() {
		return obeservations;
	}

	public void setObeservations(String obeservations) {
		this.obeservations = obeservations;
	}

	public Status getStatus() {
		return Status.toEnum(this.status);
	}

	public void setStatus(Status status) {
		this.status = status.getCod();
	}

	public Technique getTechnique() {
		return technique;
	}

	public void settechnique(Technique technique) {
		this.technique = technique;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceOrder other = (ServiceOrder) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
