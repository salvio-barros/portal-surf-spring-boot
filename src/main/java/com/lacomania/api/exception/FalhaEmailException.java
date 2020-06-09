package com.lacomania.api.exception;

public class FalhaEmailException extends RuntimeException {

	 private static final long serialVersionUID = 1L;
	    private String mensagem;

	    protected FalhaEmailException() {
	        super();
	    }

	    public FalhaEmailException(String mensagem, Throwable cause) {
	        super(mensagem, cause);
	        this.setMensagem(mensagem);
	    } 

	    public FalhaEmailException(String mensagem) {
	        super(mensagem);
	        this.setMensagem(mensagem);
	    } 

	    public String getMensagem() {
	        return mensagem;
	    }

	    public void setMensagem(String mensagem) {
	        this.mensagem = mensagem;
	    }

	
}
