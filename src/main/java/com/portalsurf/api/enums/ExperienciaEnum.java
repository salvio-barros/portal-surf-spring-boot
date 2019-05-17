package com.portalsurf.api.enums;

public enum ExperienciaEnum {

	UM_A_CINCO_ANOS(1,"1 a 5 anos"),
	CINCO_A_DEZ_ANOS(2,"5 a 10 anos"),
	ACIMA_DEZ_ANOS(3, "Acima de 10 anos");
	
	 private ExperienciaEnum(Integer id, String descricao) {
	        this.id = id;
	        this.descricao = descricao;
	    }
	
	private final Integer id;
    private final String descricao;
    
	public Integer getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
    
    
}
