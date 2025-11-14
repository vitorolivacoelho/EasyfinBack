package br.com.fiap.easyfin.controller;

import br.com.fiap.easyfin.model.MetaModel;
import br.com.fiap.easyfin.service.MetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/metas")
@CrossOrigin(origins = "*")
public class MetaController {

    @Autowired
    private MetaService metaService;

    @GetMapping
    public ResponseEntity<List<MetaModel>> listarTodas() {
        return ResponseEntity.ok(metaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MetaModel> buscarPorId(@PathVariable Long id) {
        return metaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MetaModel> criar(@RequestBody MetaModel metaModel) {
        MetaModel novaMeta = metaService.salvar(metaModel);
        return ResponseEntity.status(201).body(novaMeta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MetaModel> atualizar(@PathVariable Long id, @RequestBody MetaModel metaAtualizada) {
        MetaModel meta = metaService.atualizar(id, metaAtualizada);
        if (meta != null) {
            return ResponseEntity.ok(meta);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        metaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
