package ec.edu.ups.error.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ec.edu.ups.error.models.domain.Usuario;

@Service
public class UsuarioService implements IUsuarioService {


    private List<Usuario> usuarios;

    

    public UsuarioService() {
        usuarios = List.of(
            new Usuario(1, "Juan", "Perez"), 
            new Usuario(2, "Pedro", "Gomez"), 
            new Usuario(3, "Maria", "Gonzalez"),
            new Usuario(4, "Fernando", "Cusco")
        );
    }

    @Override
    public List<Usuario> listar() {
        return this.usuarios;
    }

    @Override
    public Usuario buscarUsuarioPorId(Integer id) {
        Usuario usuario = null;
        for (Usuario u: this.usuarios) {
            if (u.getId().equals(id)){
                usuario = u;
                break;
            }
        }
        return usuario;
    }

    @Override
    public Optional<Usuario> buscarUsuarioPorIdOptional(Integer id) {
        Usuario usuario = this.buscarUsuarioPorId(id);
        return Optional.ofNullable(usuario);
    }
    
}
