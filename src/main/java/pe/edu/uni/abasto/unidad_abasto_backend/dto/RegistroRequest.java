package pe.edu.uni.abasto.unidad_abasto_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegistroRequest {
    private String username;
    private String password;
    private String rol;

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRol() { return rol; }

    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setRol(String rol) { this.rol = rol; }


}
