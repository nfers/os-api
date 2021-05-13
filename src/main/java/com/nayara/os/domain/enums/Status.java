package com.nayara.os.domain.enums;

public enum Status {	

	OPEN(0, "OPEN"),
	INPROGRESS(1, "INPROGRESS"),
	CLOSED(2, "CLOSED");
	
	private Integer cod;
	
	private String description;
	private Status(Integer cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public Integer getCod() {
		return cod;
	}
	public String getDescription() {
		return description;
	}
	
	public static Status toEnum(Integer cod) {
		if(cod == null) {
			return null;
		} 
		
		for(Status x : Status.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Status Inválido" + cod);
		
		}

}