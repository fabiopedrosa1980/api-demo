package br.com.pedrosa.api.exception;

public class FieldErrorResponse {
	private String fieldName;
	private String errorMessage;
	
	public FieldErrorResponse(String fieldName, String errorMessage) {
		super();
		this.setFieldName(fieldName);
		this.setErrorMessage(errorMessage);
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
