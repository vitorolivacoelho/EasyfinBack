package br.com.fiap.easyfin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tbl_meta_financeira")
public class MetaModel {

    @Id
    @SequenceGenerator(
            name = "SEQ_META_FINANCEIRA",
            sequenceName = "SEQ_META_FINANCEIRA",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_META_FINANCEIRA")
    @Column(name = "id_meta")
    private Long idMeta;

    @Column(name = "nome_meta", nullable = false, length = 100)
    private String nomeMeta;

    @Column(name = "valor_objetivo", nullable = false)
    private int valorObjetivo;

    @Column(name = "valor_inicial", nullable = false)
    private int valorInicial;

    @Column(name = "data_final_meta", nullable = false)
    private LocalDate dataFinalMeta;

    @Column(name = "data_inicio_meta", nullable = false)
    private LocalDate dataInicioMeta;

    @Column(name = "descricao", length = 255)
    private String descricao;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private UsuarioModel usuario;

    public MetaModel() {}

    public MetaModel(Long idMeta, String nomeMeta, int valorObjetivo, int valorInicial, LocalDate dataFinalMeta, LocalDate dataInicioMeta, String descricao, String status, UsuarioModel usuario) {
        this.idMeta = idMeta;
        this.nomeMeta = nomeMeta;
        this.valorObjetivo = valorObjetivo;
        this.valorInicial = valorInicial;
        this.dataFinalMeta = dataFinalMeta;
        this.dataInicioMeta = dataInicioMeta;
        this.descricao = descricao;
        this.status = status;
        this.usuario = usuario;
    }

    public Long getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(Long idMeta) {
        this.idMeta = idMeta;
    }

    public String getNomeMeta() {
        return nomeMeta;
    }

    public void setNomeMeta(String nomeMeta) {
        this.nomeMeta = nomeMeta;
    }

    public int getValorObjetivo() {
        return valorObjetivo;
    }

    public void setValorObjetivo(int valorObjetivo) {
        this.valorObjetivo = valorObjetivo;
    }

    public int getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
    }

    public LocalDate getDataFinalMeta() {
        return dataFinalMeta;
    }

    public void setDataFinalMeta(LocalDate dataFinalMeta) {
        this.dataFinalMeta = dataFinalMeta;
    }

    public LocalDate getDataInicioMeta() {
        return dataInicioMeta;
    }

    public void setDataInicioMeta(LocalDate dataInicioMeta) {
        this.dataInicioMeta = dataInicioMeta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }
}