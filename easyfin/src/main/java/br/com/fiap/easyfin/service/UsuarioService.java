package br.com.fiap.easyfin.service;

import br.com.fiap.easyfin.model.UsuarioModel;
import br.com.fiap.easyfin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioModel salvar(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    public List<UsuarioModel> listarTodas() {
        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public UsuarioModel atualizar(Long id, UsuarioModel usuarioAtualizado) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(usuarioAtualizado.getNome());
                    usuario.setEmail(usuarioAtualizado.getEmail());
                    usuario.setSenha(usuarioAtualizado.getSenha());
                    usuario.setCpf(usuarioAtualizado.getCpf());
                    usuario.setTelefone(usuarioAtualizado.getTelefone());
                    usuario.setDataNascimento(usuarioAtualizado.getDataNascimento());
                    usuario.setEndereco(usuarioAtualizado.getEndereco());

                    return usuarioRepository.save(usuario);
                })
                .orElse(null);
    }
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}