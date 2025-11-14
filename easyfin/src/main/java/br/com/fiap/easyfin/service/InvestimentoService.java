package br.com.fiap.easyfin.service;

import br.com.fiap.easyfin.model.InvestimentoModel;
import br.com.fiap.easyfin.model.UsuarioModel;
import br.com.fiap.easyfin.repository.InvestimentosRepository;
import br.com.fiap.easyfin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestimentoService {

    @Autowired
    private InvestimentosRepository investimentosRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public InvestimentoModel salvar(InvestimentoModel investimentoModel) {
        Long idUsuario = investimentoModel.getUsuario().getIdUsuario();
        UsuarioModel usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + idUsuario));
        investimentoModel.setUsuario(usuario);
        return investimentosRepository.save(investimentoModel);
    }
    public List<InvestimentoModel> listarTodas() {
        return investimentosRepository.findAll();
    }
    public Optional<InvestimentoModel> buscarPorId(Long id) {
        return investimentosRepository.findById(id);
    }
    public InvestimentoModel atualizar(Long id, InvestimentoModel investimentoAtualizado) {
        return investimentosRepository.findById(id)
                .map(investimento -> {
                    Long idUsuario = investimentoAtualizado.getUsuario().getIdUsuario();
                    UsuarioModel usuario = usuarioRepository.findById(idUsuario)
                            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + idUsuario));
                    investimento.setUsuario(usuario);
                    investimento.setTipoInvestimento(investimentoAtualizado.getTipoInvestimento());
                    investimento.setValorInvestimento(investimentoAtualizado.getValorInvestimento());
                    investimento.setDataAplicacao(investimentoAtualizado.getDataAplicacao());
                    investimento.setDataExpiracao(investimentoAtualizado.getDataExpiracao());
                    investimento.setCodigoTicker(investimentoAtualizado.getCodigoTicker());
                    investimento.setInstituicao(investimentoAtualizado.getInstituicao());
                    investimento.setQuantidadeCotas(investimentoAtualizado.getQuantidadeCotas());

                    return investimentosRepository.save(investimento);
                })
                .orElse(null);
    }

    public void deletar(Long id) {
        investimentosRepository.deleteById(id);
    }
}