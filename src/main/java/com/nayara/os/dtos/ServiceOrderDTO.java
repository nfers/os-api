package com.nayara.os.dtos;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.nayara.os.domain.Client;
import com.nayara.os.domain.ServiceOrder;
import com.nayara.os.domain.Technique;
import com.nayara.os.domain.enums.Priority;
import com.nayara.os.domain.enums.Status;

public class ServiceOrderDTO  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private LocalDateTime created_at;
	private LocalDateTime closed_on;	
	private String obeservations;
	private Integer priority;
	private Integer status;
	private Integer technique;
	private Integer client;
	
	public ServiceOrderDTO() {
		super();
	}

	public ServiceOrderDTO(ServiceOrder obj) {
		this.id = obj.getId();
		this.created_at = obj.getCreated_at();
		this.closed_on = obj.getClosed_on();
		this.obeservations = obj.getObeservations();
		this.priority = obj.getPriority().getCod();
		this.status = obj.getStatus().getCod();
		this.technique = obj.getTechnique().getId();
		this.client = obj.getClient().getId();
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

	public String getObeservations() {
		return obeservations;
	}

	public void setObeservations(String obeservations) {
		this.obeservations = obeservations;
	}

	public Priority getPriority() {
		return Priority.toEnum(this.priority);
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Status getStatus() {
		return Status.toEnum(this.status);
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getTechnique() {
		return technique;
	}

	public void setTechnique(Integer technique) {
		this.technique = technique;
	}

	public Integer getClient() {
		return client;
	}

	public void setClient(Integer client) {
		this.client = client;
	}
	
	
	
}
