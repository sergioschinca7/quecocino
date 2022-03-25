package com.quecomemos.usuario;

import com.quecomemos.Errores.ErrorServicio;
import com.quecomemos.roles.Role;
import com.quecomemos.roles.RolesRepositorio;

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

@Service
public class PersonaServicioImpl implements PersonaServicio, UserDetailsService {

    @Autowired
    private RolesRepositorio rolesRepositorio;

    @Autowired
    private PersonaRepositorio personaRepositorio;

    @Override
    public Persona validarPersona(Persona persona, String contrasena2) throws ErrorServicio {

        Persona p = buscarPorUsuario(persona.getNombreUsuario());


        if (persona.getNombre().isEmpty() || persona.getNombre() == null || persona.getNombre().length() < 3) {
            throw new ErrorServicio(" El nombre no puede estar vacío o tener menos de 3 caracteres");
        }
        if (persona.getApellido().isEmpty() || persona.getApellido() == null) {
            throw new ErrorServicio(" El apellido no puede estar vacío");
        }
        if (persona.getNombre().equalsIgnoreCase(persona.getApellido())) {
            throw new ErrorServicio("Nombre y Apellido no pueden ser iguales");
        }
        if (persona.getNombreUsuario().isEmpty() || persona.getNombreUsuario() == null) {
            throw new ErrorServicio("El nombre de usuario no puede estar vacío");
        }

        if (contrasena2 == null) {

            throw new ErrorServicio(" La contraseña no puede ser nula");

        }
        if (persona.getContrasena().isEmpty() || persona.getContrasena() == null) {

            throw new ErrorServicio(" La contraseña no puede ser nula");

        }
        if (!(contrasena2.equals(persona.getContrasena()))) {

            throw new ErrorServicio(" La contraseñas tienen que ser iguales");

        }


        return persona;

    }

    @Override
    public Persona guardar(Persona persona, String contrasena2) throws ErrorServicio {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Persona personaFinal = validarPersona(persona, contrasena2);

        personaFinal.setContrasena(encoder.encode(personaFinal.getContrasena()));
        Role role = new Role(1, "ROLE_USER");

        rolesRepositorio.save(role);

        personaFinal.setRol(role);
        return personaRepositorio.save(personaFinal);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Persona persona = personaRepositorio.findByNombreUsuario(username);

        List<GrantedAuthority> auth = new ArrayList();
        auth.add(new SimpleGrantedAuthority(persona.getRol().getRol()));

        return new User(persona.getNombreUsuario(), persona.getContrasena(), auth);

    }

    @Override
    public Persona findByNombre(String nombre) {

        return personaRepositorio.findByNombre(nombre);

    }

    @Override
    public Persona buscarPorUsuario(String nombreUsuario) throws ErrorServicio {
        Persona p = personaRepositorio.findByNombreUsuario(nombreUsuario);

        if (p != null) {
            throw new ErrorServicio("El nombre de usuario ya existe");
        }

        return p;
    }

}
