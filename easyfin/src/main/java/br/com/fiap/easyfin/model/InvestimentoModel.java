package br.com.fiap.easyfin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_investimentos")
public class InvestimentoModel {

    @Id
    @SequenceGenerator(
            name = "SEQ_INVESTIMENTOS",
            sequenceName = "SEQ_INVESTIMENTOS",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INVESTIMENTOS")
    @Column(name = "id_investimento")
    private Long idInvestimento;

    @Column(name = "tipo_investimento", nullable = false, length = 100)
    private String tipoInvestimento;

    @Column(name = "valor_investimento", nullable = false)
    private Long valorInvestimento;

    @Column(name = "data_aplicacao", nullable = false)
    private LocalDate dataAplicacao;

    @Column(name = "data_expiracao")
    private LocalDate dataExpiracao;

    @Column(name = "codigo_ticker", length = 20)
    private String codigoTicker;

    @Column(name = "instituicao", nullable = false, length = 100)
    private String instituicao;

    @Column(name = "quantidade_cotas", nullable = false)
    private int quantidadeCotas;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private UsuarioModel usuario;

    public InvestimentoModel() {}

    public InvestimentoModel(Long idInvestimento, String tipoInvestimento, Long valorInvestimento, LocalDate dataAplicacao, LocalDate dataExpiracao, String codigoTicker, String instituicao, int quantidadeCotas, UsuarioModel usuario) {
        this.idInvestimento = idInvestimento;
        this.tipoInvestimento = tipoInvestimento;
        this.valorInvestimento = valorInvestimento;
        this.dataAplicacao = dataAplicacao;
        this.dataExpiracao = dataExpiracao;
        this.codigoTicker = codigoTicker;
        this.instituicao = instituicao;
        this.quantidadeCotas = quantidadeCotas;
        this.usuario = usuario;
    }

    public Long getIdInvestimento() {
        return idInvestimento;
    }

    public void setIdInvestimento(Long idInvestimento) {
        this.idInvestimento = idInvestimento;
    }

    public String getTipoInvestimento() {
        return tipoInvestimento;
    }

    public void setTipoInvestimento(String tipoInvestimento) {
        this.tipoInvestimento = tipoInvestimento;
    }

    public Long getValorInvestimento() {
        return valorInvestimento;
    }

    public void setValorInvestimento(Long valorInvestimento) {
        this.valorInvestimento = valorInvestimento;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public String getCodigoTicker() {
        return codigoTicker;
    }

    public void setCodigoTicker(String codigoTicker) {
        this.codigoTicker = codigoTicker;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public int getQuantidadeCotas() {
        return quantidadeCotas;
    }

    public void setQuantidadeCotas(int quantidadeCotas) {
        this.quantidadeCotas = quantidadeCotas;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}