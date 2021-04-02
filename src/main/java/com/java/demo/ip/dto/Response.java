package com.java.demo.ip.dto;

/**
 * 
 * @author AdrianRojas
 * 
 * Dto que contiene la información de la respuesta de servicio consulta información ip
 * en caso de ocurrir un error se retorna error:true , se especifica el error en message y el body 
 * es null, cuando es correcta se retorna error:false y la información en object body.
 *
 */
public class Response {

	private String status;
	private boolean error;
	private String message;
	private Object body;

	public Response() {

	}

	public Response(String status, boolean error, String message, Object body) {
		super();
		this.status = status;
		this.error = error;
		this.message = message;
		this.body = body;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getBody() {
		return body;
	}

	public void setBody(Object body) {
		this.body = body;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}

}
