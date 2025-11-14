package br.com.fiap.easyfin.controller;

import br.com.fiap.easyfin.model.UsuarioModel;
import br.com.fiap.easyfin.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> listarTodas() {
        return ResponseEntity.ok(usuarioService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioModel> buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> criar(@RequestBody UsuarioModel usuarioModel) {
        UsuarioModel novoUsuario = usuarioService.salvar(usuarioModel);
        return ResponseEntity.status(201).body(novoUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioModel> atualizar(@PathVariable Long id, @RequestBody UsuarioModel usuarioAtualizado) {
        UsuarioModel usuario = usuarioService.atualizar(id, usuarioAtualizado);

        return (usuario != null) ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}