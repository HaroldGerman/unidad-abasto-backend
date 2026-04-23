package pe.edu.uni.abasto.unidad_abasto_backend.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.edu.uni.abasto.unidad_abasto_backend.dto.RegistroRequest;
import pe.edu.uni.abasto.unidad_abasto_backend.entities.Usuario;
import pe.edu.uni.abasto.unidad_abasto_backend.repositories.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    
    public Usuario iniciarSesion(String username, String password) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByUsername(username);
        if (usuarioOptional.isPresent()) {
            if (usuarioOptional.get().getPassword().equals(password)) {
                System.out.println(username + " ha iniciado sesión correctamente");
                return usuarioOptional.get();
            } else {
                throw new RuntimeException("Contraseña incorrecta");
            }
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    public Usuario registrar(RegistroRequest datos) {
        // Verificamos si el nombre de usuario ya existe para evitar duplicados
        if (usuarioRepository.findByUsername(datos.getUsername()).isPresent()) {
            throw new RuntimeException("El nombre de usuario ya existe");
        }

        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setUsername(datos.getUsername());
        nuevoUsuario.setPassword(datos.getPassword()); // En el futuro aquí se encriptará
        nuevoUsuario.setRol(datos.getRol());

        return usuarioRepository.save(nuevoUsuario);
    }
}
