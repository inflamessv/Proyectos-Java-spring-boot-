package com.bolsadeideas.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.form.app.models.domain.Pais;

@Service
public class PaisServiceImp implements PaisService {

	public List<Pais>listaPais;
	
	@Override
	public List<Pais> listar() {
		return this.listaPais = Arrays.asList(
				new Pais(1,"MX","Mexico"),
				new Pais(2,"BE","Belice"),
				new Pais(3,"NI","Nicaragua"),
				new Pais(4,"HO","Honduras"),
				new Pais(4,"GU","Guatemala")
		);
	}

	@Override
	public Pais obtenerPorId(Integer id) {
		Pais resultado = null;
		for (Pais pais : this.listaPais) {
			if(id == pais.getId()) {
				resultado = pais;
				break;
			}
		}
		return resultado;
	}

}
