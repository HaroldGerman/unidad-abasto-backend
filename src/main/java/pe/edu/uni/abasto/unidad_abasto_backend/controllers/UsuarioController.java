package pe.edu.uni.abasto.unidad_abasto_backend.controllers;

import  lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.uni.abasto.unidad_abasto_backend.dto.LoginRequest;
import pe.edu.uni.abasto.unidad_abasto_backend.dto.RegistroRequest;
import pe.edu.uni.abasto.unidad_abasto_backend.entities.Usuario;
import pe.edu.uni.abasto.unidad_abasto_backend.services.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest datos) {
        try {
            Usuario usuario = usuarioService.iniciarSesion(datos.getUsername(), datos.getPassword());
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @PostMapping("/registro")
    public ResponseEntity<?> registrar(@RequestBody RegistroRequest datos) {
        try {
            Usuario usuarioGuardado = usuarioService.registrar(datos);
            return ResponseEntity.ok(usuarioGuardado);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
