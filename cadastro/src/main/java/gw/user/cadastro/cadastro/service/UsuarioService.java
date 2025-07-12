package gw.user.cadastro.cadastro.service;

import gw.user.cadastro.cadastro.model.Usuario;
import gw.user.cadastro.cadastro.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public Usuario AddUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> GetAllUsers() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> GetUserById(Long id) {
        return usuarioRepository.findById(id);
    }

    public void DeleteUserById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public void UpdateUserById(Long id, Usuario usuario) {
        usuario.setId(id);
        usuarioRepository.save(usuario);
    }
}
