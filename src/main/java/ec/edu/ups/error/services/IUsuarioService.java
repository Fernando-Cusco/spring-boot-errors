package ec.edu.ups.error.services;

import java.util.List;
import java.util.Optional;

import ec.edu.ups.error.models.domain.Usuario;

public interface IUsuarioService {
    public List<Usuario> listar();

    public Usuario buscarUsuarioPorId(Integer id);

    public Optional<Usuario> buscarUsuarioPorIdOptional(Integer id);
}
