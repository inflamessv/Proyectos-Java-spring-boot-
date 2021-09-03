package com.bolsadeideas.springboot.form.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.form.app.models.domain.Roles;

@Service
public class RolesServiceImp implements RolesService {

	public List<Roles>roles = new ArrayList<Roles>();
	
	
	public RolesServiceImp() {
	   roles.add(new Roles(1,"ROLE_ADMIN","Administracion"));
	   roles.add(new Roles(2,"ROLE_USER","Usuarios"));
	   roles.add(new Roles(3,"ROLE_MODERATOR","Moderador"));
	}

	@Override
	public List<Roles> listar() {
		return roles;
	}

	@Override
	public Roles obtenerPorId(Integer id) {
		
		Roles resultado=new Roles();
		for(Roles rol : roles) {
			if(rol.getId() == id) {
				resultado = rol;
				break;
			}
		}
		
		return resultado;
	}

}
