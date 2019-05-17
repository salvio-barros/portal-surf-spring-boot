package com.portalsurf.api.enums;

public enum FaseEnum {

	CONCEPCAO(0, "Estágio Inicial"),
	SHAPING(1, "Fase de Shapping"),
	PINTURA(2,"Fase de Pintura"),
	LAMINACAO(3,"Fase de Laminação"),
	POLIMENTO(4,"Fase de Polimento"),
	FINALIZADO(5, "Finalizado");
	
	private FaseEnum(Integer id, String descricao) {
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
