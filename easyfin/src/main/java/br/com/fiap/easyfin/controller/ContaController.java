package br.com.fiap.easyfin.controller;

import br.com.fiap.easyfin.model.ContaModel;
import br.com.fiap.easyfin.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
@CrossOrigin(origins = "*")
public class ContaController {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public ResponseEntity<List<ContaModel>> listarTodas() {
        return ResponseEntity.ok(contaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaModel> buscarPorId(@PathVariable Long id) {
        return contaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ContaModel> criar(@RequestBody ContaModel contaModel) {
        ContaModel novaConta = contaService.salvar(contaModel);
        return ResponseEntity.status(201).body(novaConta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContaModel> atualizar(@PathVariable Long id, @RequestBody ContaModel contaAtualizada) {
        ContaModel conta = contaService.atualizar(id, contaAtualizada);
        return (conta != null) ? ResponseEntity.ok(conta) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        contaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
