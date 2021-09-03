package com.bolsadeideas.springboot.form.app.services;
import com.bolsadeideas.springboot.form.app.models.domain.*;

import java.util.List;

import org.springframework.stereotype.Component;


public interface RolesService {
	
	public List<Roles>listar();
	public Roles obtenerPorId(Integer id);
}
