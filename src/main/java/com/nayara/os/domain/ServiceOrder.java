package com.nayara.os.domain;

import java.time.LocalDateTime;

import com.nayara.os.domain.enums.Priority;
import com.nayara.os.domain.enums.Status;

public class ServiceOrder {

	private Integer id;
	private LocalDateTime created_at;
	private LocalDateTime closed_on;
	private String obeservations;
	private Integer priority;
	private Integer status;
	private Technique tecnhinque;
	private Client client;

	public ServiceOrder() {
		super();
		this.setCreated_at(LocalDateTime.now());
		this.setPriority(Priority.LOW);
		this.setStatus(Status.OPEN);
	}

	public ServiceOrder(Integer id, LocalDateTime created_at, Priority priority,
			String obeservations, Status status, Technique tecnhinque, Client client) {
		super();
		this.id = id;
		this.setCreated_at(LocalDateTime.now());
		this.priority = (priority == null) ? 0 : priority.getCod();
		this.obeservations = obeservations;
		this.status = (status == null) ? 0 : status.getCod();
		this.tecnhinque = tecnhinque;
		this.client = client;
	}

	public Integer getId() {
		return id;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public LocalDateTime getClosed_on() {
		return closed_on;
	}

	public Priority getPriority() {		
		return Priority.toEnum(this.priority);
	}

	public String getObeservations() {
		return obeservations;
	}

	public Status getStatus() {
	return Status.toEnum(this.priority);
	}

	public Technique getTecnhinque() {
		return tecnhinque;
	}

	public Client getClient() {
		return client;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public void setClosed_on(LocalDateTime closed_on) {
		this.closed_on = closed_on;
	}

	public void setPriority(Priority priority) {
		this.priority = priority.getCod();
	}

	public void setObeservations(String obeservations) {
		this.obeservations = obeservations;
	}

	public void setStatus(Status status) {
		this.status = status.getCod();
	}

	public void setTecnhinque(Technique tecnhinque) {
		this.tecnhinque = tecnhinque;
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
