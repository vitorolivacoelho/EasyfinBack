package br.com.fiap.easyfin.controller;

import br.com.fiap.easyfin.model.InvestimentoModel;
import br.com.fiap.easyfin.service.InvestimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investimentos")
@CrossOrigin(origins = "*")
public class InvestimentoController {

    @Autowired
    private InvestimentoService investimentoService;

    @GetMapping
    public ResponseEntity<List<InvestimentoModel>> listarTodas() {
        return ResponseEntity.ok(investimentoService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvestimentoModel> buscarPorId(@PathVariable Long id) {
        return investimentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<InvestimentoModel> criar(@RequestBody InvestimentoModel investimentoModel) {
        InvestimentoModel novoInvestimento = investimentoService.salvar(investimentoModel);
        return ResponseEntity.status(201).body(novoInvestimento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvestimentoModel> atualizar(@PathVariable Long id, @RequestBody InvestimentoModel investimentoAtualizado) {
        InvestimentoModel investimento = investimentoService.atualizar(id, investimentoAtualizado);
        return (investimento != null) ? ResponseEntity.ok(investimento) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        investimentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}