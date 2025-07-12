package gw.user.cadastro.cadastro.controller;

import gw.user.cadastro.cadastro.model.Usuario;
import gw.user.cadastro.cadastro.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioService usuarioService;
   //localhost:8080/users/criar
    @PostMapping
   public ResponseEntity<Usuario> createUser(@RequestBody Usuario usuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.AddUser(usuario));
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.GetAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Usuario>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.GetUserById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable Long id, @RequestBody Usuario usuario) {
         usuarioService.DeleteUserById(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping
    ResponseEntity<Void> deleteById(@PathVariable Long id) {
      usuarioService.DeleteUserById(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}



