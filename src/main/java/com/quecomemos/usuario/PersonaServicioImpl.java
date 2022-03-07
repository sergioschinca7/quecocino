/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.quecomemos.usuario;

import com.quecomemos.Errores.ErrorServicio;
import com.quecomemos.login.Role;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Sergio
 */
@Service
public class PersonaServicioImpl implements PersonaServicio, UserDetailsService {

    @Autowired
    private PersonaRepositorio personaRepositorio;

    @Override
    public Persona validarPersona(Persona persona, String contrasena2) throws ErrorServicio {

        if (persona.getNombre().isEmpty() || persona.getNombre() == null || persona.getNombre().length() < 3) {
            throw new ErrorServicio(" El nombre no puede estar vacío o tener menos de 3 caracteres");
        }
        if (persona.getApellido().isEmpty() || persona.getApellido() == null) {
            throw new ErrorServicio(" El apellido no puede estar vacío");
        }

        if (contrasena2 == null) {

            throw new ErrorServicio(" La contraseña no puede ser nula");

        }
        if (persona.getContrasena() == null) {

            throw new ErrorServicio(" La contraseña no puede ser nula");

        }
        if (!(contrasena2.equals(persona.getContrasena()))) {

            throw new ErrorServicio(" La contraseña tienen que ser iguales");

        }
        
        

        return persona;

    }

    @Override
    public Persona guardar(Persona persona, String contrasena2) throws ErrorServicio {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Persona personaFinal = validarPersona(persona, contrasena2);

        personaFinal.setContrasena(encoder.encode(personaFinal.getContrasena()));
        personaFinal.setRol(new Role(1, "user"));
        return personaRepositorio.save(personaFinal);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Persona persona = findByNombre(username);
        
        List<GrantedAuthority> auth = new ArrayList();
        auth.add(new SimpleGrantedAuthority(persona.getRol().getRol()));
        
        return new User(persona.getNombre(), persona.getContrasena(), auth);       

    }

    @Override
    public Persona findByNombre(String nombre) {
        
        return personaRepositorio.findByNombre(nombre);

    }
    
    
    

}
