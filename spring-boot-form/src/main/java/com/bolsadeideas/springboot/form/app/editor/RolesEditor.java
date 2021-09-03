package com.bolsadeideas.springboot.form.app.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bolsadeideas.springboot.form.app.services.RolesService;

@Component
public class RolesEditor  extends PropertyEditorSupport{

	
	@Autowired
	private RolesService rolService;
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		try {
			Integer id = Integer.parseInt(text);
			setValue(rolService.obtenerPorId(id));
		} catch (NumberFormatException e) {
			setValue(null);
		}
		
	}

	
	
}
