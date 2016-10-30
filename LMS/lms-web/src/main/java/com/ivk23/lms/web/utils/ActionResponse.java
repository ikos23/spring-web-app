package com.ivk23.lms.web.utils;

import java.util.ArrayList;
import java.util.List;

public class ActionResponse {

	public static final ActionResponse EMPTY_200_RESPONSE = new ActionResponse().withCode(200)
			.withMessage("Successfull response !");

	private int httpStatusCode;
	private String message;

	private final List<Error> errors = new ArrayList<>();

	public ActionResponse() {
		super();
	}

	/**
	 * Add error. Param can't be null !
	 * 
	 * @param e
	 */
	public ActionResponse addError(Error e) {
		if (e != null) {
			errors.add(e);
		}
		return this;
	}

	public boolean hasErrors() {
		return errors.size() > 0;
	}

	public int getHttpStatusCode() {
		return httpStatusCode;
	}

	public ActionResponse withCode(int httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
		return this;
	}

	public String getMessage() {
		return message;
	}

	public ActionResponse withMessage(String message) {
		this.message = message;
		return this;
	}

	public List<Error> getErrors() {
		return errors;
	}

	@Override
	public String toString() {
		return "ActionResponse [httpStatusCode=" + httpStatusCode + ", message=" + message + ", errors=" + errors + "]";
	}

}
