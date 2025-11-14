package br.com.fiap.easyfin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_conta_financeira")
public class ContaModel {

    @Id
    @SequenceGenerator(
            name = "SEQ_CONTA_FINANCEIRA",
            sequenceName = "SEQ_CONTA_FINANCEIRA",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONTA_FINANCEIRA")
    @Column(name = "id_conta")
    private Long idConta;

    @Column(name = "instituicao", nullable = false, length = 100)
    private String instituicao;

    @Column(name = "saldo")
    private double saldo;

    @Column(name = "tipo_conta", nullable = false, length = 50)
    private String tipoConta;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false) // Define a FK
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // Evita erros no JSON
    private UsuarioModel usuario;

    public ContaModel() {}

    public ContaModel(Long idConta, String instituicao, double saldo, String tipoConta, String status, UsuarioModel usuario) {
        this.idConta = idConta;
        this.instituicao = instituicao;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.status = status;
        this.usuario = usuario;
    }

    public Long getIdConta() {
        return idConta;
    }

    public void setIdConta(Long idConta) {
        this.idConta = idConta;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
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