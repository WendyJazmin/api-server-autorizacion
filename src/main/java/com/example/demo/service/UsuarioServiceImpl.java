package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IUsuarioRepository;
import com.example.demo.repository.modelo.Usuario;

//IMPORTACIÓN ESTATICA
import static java.util.Collections.emptyList;

@Service
public class UsuarioServiceImpl implements UserDetailsService {//no se crea la interface UsuarioService

	@Autowired
	private IUsuarioRepository iUsuarioRepository; 
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = this.iUsuarioRepository.consultarPorNombre(username);
		
		return new User(usuario.getNombre(),usuario.getPassword(),emptyList());//se tiene que hacer la importación estatica
	}

}
