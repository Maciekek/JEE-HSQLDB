package com.example.jsfdemo.web;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("pinValidator")
public class pinValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		String pin = value.toString();
		FacesMessage message = new FacesMessage();
		if (pin.length() != 4) {
			message.setDetail("Pin musi skladac sie z 4 cyfr");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		} else {
			if (pin.substring(0, 1).equals(pin.substring(1, 2))) {
				message.setDetail("Pierwsze dwie cyfry musza byc rozne!");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}

	}
}
