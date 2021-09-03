package com.bolsadeideas.springboot.form.app.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.relation.Role;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.form.app.editor.NombreMayusculaEditor;
import com.bolsadeideas.springboot.form.app.editor.PaisPropertyEditor;
import com.bolsadeideas.springboot.form.app.editor.RolesEditor;
import com.bolsadeideas.springboot.form.app.models.domain.Pais;
import com.bolsadeideas.springboot.form.app.models.domain.Roles;
import com.bolsadeideas.springboot.form.app.models.domain.Usuario;
import com.bolsadeideas.springboot.form.app.services.PaisService;
import com.bolsadeideas.springboot.form.app.services.RolesService;
import com.bolsadeideas.springboot.form.app.validations.UsuarioValidador;

@Controller
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	UsuarioValidador validator;
	
	@Autowired
	PaisService paisService;
	
	@Autowired
	PaisPropertyEditor paisEditor;
	
	@Autowired
	RolesService rolService;
	
	@Autowired
	RolesEditor rolEditor;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validator);
		SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy-MM-dd");
		//no permite que otro formato venga en la fecha
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class,"fechaNacimiento", new CustomDateEditor(dateFormat, false));
	
		binder.registerCustomEditor(String.class,"nombre", new NombreMayusculaEditor());
		
		binder.registerCustomEditor(Pais.class, "pais", paisEditor);
		
		binder.registerCustomEditor(Roles.class, "roles", rolEditor);
	}
	
	@GetMapping({"/form",""})
	public String form(Model model) {
		Usuario usuario =new Usuario();
		usuario.setNombre("giovanni");
		usuario.setApellido("arevalo");
		usuario.setIdentificador("111.233.333-K");
		usuario.setValorSecreto("algun valor secreto !********");
		usuario.setHabilitar(true);
		usuario.setRoles(Arrays.asList(new Roles(2,"usuario","ROLE_USER")));
		model.addAttribute("usuario",usuario );
		return "form";
	}
	
	//si el pojo tiene el mismo nombre como el name del formulario no es necesario el @RequestParam
	
	@PostMapping("/form")
	public String resultado(@Valid Usuario usuario,BindingResult results,SessionStatus status,Model model
			/*@RequestParam String username
			@RequestParam String password
			@RequestParam String email*/) {
	
		//validator.validate(usuario, results);
		if(results.hasErrors()) {
			model.addAttribute("titulo","Resultado Form" );
			/*
			Map<String,String> errores = new HashMap<>();
	
			results.getFieldErrors().forEach(err ->{
				errores.put(err.getField(), 
						"El campo ".concat(err.getField())
						.concat(" ")
						.concat(err.getDefaultMessage()));
			});
			model.addAttribute("error", errores);
			*/
			return "form";
		}
		
		
		return "redirect:/ver";
	}
	
	@GetMapping("/ver")
	public String ver(@SessionAttribute(name = "usuario",required = false) Usuario usuario,Model model,SessionStatus status) {
		
		if(usuario == null) {
			return "redirect:/form";
		}
		model.addAttribute("titulo","Resultado Form" );
		status.setComplete();
		return "resultado";
	}
	
	
	@ModelAttribute("listaPaises")
	public List<Pais>listaPaises(){
		return paisService.listar();
		
	}
	
	@ModelAttribute("paises")
	public List<String>paises(){
		return Arrays.asList("Mexico","Belice","Nicaragua","Honduras","Guatemala");
	}
	
	@ModelAttribute("paisesMap")
	public Map<String,String>paisesMap(){
		Map<String,String>paises=new HashMap<String, String>();
		paises.put("MX", "Mexico");
		paises.put("BE", "Belice");
		paises.put("NI", "Nicaragua");
		paises.put("HO", "Honduras");
		paises.put("GU", "Guatemala");
		return paises;
	}
	
	@ModelAttribute("rolesListString")
	public List<String>listaRolesString(){
		List<String>roles=new ArrayList<>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		roles.add("ROLE_MODERATOR");
		return roles;
	}
	
	@ModelAttribute("listaRolesMap")
	public Map<String,String>listaRolesMap(){
		Map<String,String>roles=new HashMap<String,String>();
		roles.put("ROLE_ADMIN", "Administrador");
		roles.put("ROLE_USER", "Usuarios");
		roles.put("ROLE_MODERATOR", "Moderador");
		return roles;
	}
	
	@ModelAttribute("listaRoles")
	public List<Roles>listaRoles(){
		return rolService.listar();
	}
	
	@ModelAttribute("listaGeneros")
	public List<String>listaGeneros(){
		return Arrays.asList("hombre","mujer");
	}
}
