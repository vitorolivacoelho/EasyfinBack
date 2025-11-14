package br.com.fiap.easyfin.service;

import br.com.fiap.easyfin.model.MetaModel;
import br.com.fiap.easyfin.model.UsuarioModel;
import br.com.fiap.easyfin.repository.MetaRepository;
import br.com.fiap.easyfin.repository.UsuarioRepository; // Import necessário
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MetaService {

    @Autowired
    private MetaRepository metaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public MetaModel salvar(MetaModel metaModel) {
        Long idUsuario = metaModel.getUsuario().getIdUsuario();
        UsuarioModel usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + idUsuario));
        metaModel.setUsuario(usuario);
        return metaRepository.save(metaModel);
    }

    public List<MetaModel> listarTodas() {
        return metaRepository.findAll();
    }

    public Optional<MetaModel> buscarPorId(Long id) {
        return metaRepository.findById(id);
    }

    // Método ATUALIZAR ajustado
    public MetaModel atualizar(Long id, MetaModel metaAtualizada) {
        return metaRepository.findById(id)
                .map(meta -> {
                    Long idUsuario = metaAtualizada.getUsuario().getIdUsuario();
                    UsuarioModel usuario = usuarioRepository.findById(idUsuario)
                            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + idUsuario));
                    meta.setUsuario(usuario);
                    meta.setNomeMeta(metaAtualizada.getNomeMeta());
                    meta.setValorObjetivo(metaAtualizada.getValorObjetivo());
                    meta.setValorInicial(metaAtualizada.getValorInicial());
                    meta.setDataFinalMeta(metaAtualizada.getDataFinalMeta());
                    meta.setDataInicioMeta(metaAtualizada.getDataInicioMeta());
                    meta.setDescricao(metaAtualizada.getDescricao());
                    meta.setStatus(metaAtualizada.getStatus());
                    return metaRepository.save(meta);
                })
                .orElse(null);
    }
    public void deletar(Long id) {
        metaRepository.deleteById(id);
    }
}