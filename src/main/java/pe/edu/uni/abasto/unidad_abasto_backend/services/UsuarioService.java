package pe.edu.uni.abasto.unidad_abasto_backend.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import pe.edu.uni.abasto.unidad_abasto_backend.entities.Usuario;
import pe.edu.uni.abasto.unidad_abasto_backend.repositories.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;
    
    public void iniciarSesion(String username, String password) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByUsername(username);
        if (usuarioOptional.isPresent()) {
            if (usuarioOptional.get().getPassword().equals(password)) {
                System.out.println(username + " ha iniciado sesión correctamente");
            } else {
                throw new RuntimeException("Contraseña incorrecta");
            }
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }
}
