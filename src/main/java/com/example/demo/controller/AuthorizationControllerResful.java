package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.security.JwUtils;
import com.example.demo.service.to.UsuarioTo;

@RestController
@RequestMapping("/autorizaciones")
public class AuthorizationControllerResful {
	
	@Autowired
	private AuthenticationManager  authenticationManager;
	
	@Autowired
	private JwUtils jwt;
	
	@GetMapping(path="/jwt", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String obtenerToken(@RequestBody UsuarioTo usuario) {
		
		//Autorizacion
		//Validar el usuario y el password sean correctos
		//si es correcta la autenticacion retorna token
		System.out.println(usuario);
		this.autentication(usuario.getNombre(), usuario.getPassword());
		return this.jwt.buildTokenJwt(usuario.getNombre());
	}
	
	public void autentication(String usuario, String password) {
		UsernamePasswordAuthenticationToken usuarioToken = new UsernamePasswordAuthenticationToken(usuario,password);
		Authentication autenticacion= this.authenticationManager.authenticate(usuarioToken);
		SecurityContextHolder.getContext().setAuthentication(autenticacion); 
	}

}
