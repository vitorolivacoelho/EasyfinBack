package br.com.fiap.easyfin.service;

import br.com.fiap.easyfin.model.ContaModel;
import br.com.fiap.easyfin.model.UsuarioModel;
import br.com.fiap.easyfin.repository.ContaRepository;
import br.com.fiap.easyfin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ContaModel salvar(ContaModel contaModel) {
        Long idUsuario = contaModel.getUsuario().getIdUsuario();
        UsuarioModel usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + idUsuario));

        contaModel.setUsuario(usuario);
        return contaRepository.save(contaModel);
    }
    public List<ContaModel> listarTodas() {
        return contaRepository.findAll();
    }
    public Optional<ContaModel> buscarPorId(Long id) {
        return contaRepository.findById(id);
    }
    public ContaModel atualizar(Long id, ContaModel contaAtualizada) {
        return contaRepository.findById(id)
                .map(conta -> {
                    Long idUsuario = contaAtualizada.getUsuario().getIdUsuario();
                    UsuarioModel usuario = usuarioRepository.findById(idUsuario)
                            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + idUsuario));
                    conta.setUsuario(usuario);
                    conta.setInstituicao(contaAtualizada.getInstituicao());
                    conta.setSaldo(contaAtualizada.getSaldo());
                    conta.setTipoConta(contaAtualizada.getTipoConta());
                    conta.setStatus(contaAtualizada.getStatus());

                    return contaRepository.save(conta);
                })
                .orElse(null);
    }

    public void deletar(Long id) {
        contaRepository.deleteById(id);
    }
}