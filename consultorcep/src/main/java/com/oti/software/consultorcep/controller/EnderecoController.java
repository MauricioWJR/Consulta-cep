package com.oti.software.consultorcep.controller;

import com.oti.software.consultorcep.model.Endereco;
import com.oti.software.consultorcep.service.EnderecoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
@CrossOrigin(origins = "*")
public class EnderecoController {

    private final EnderecoService service;

    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<Endereco> buscarPorCep(@PathVariable String cep) {
        Endereco endereco = service.buscarPorCep(cep);
        return ResponseEntity.ok(endereco);
    }

    @GetMapping("/logradouro/{logradouro}")
    public ResponseEntity<List<Endereco>> buscarPorLogradouro(@PathVariable String logradouro) {
        return ResponseEntity.ok(service.buscarPorLogradouro(logradouro));
    }

    @GetMapping("/cidade/{cidade}")
    public ResponseEntity<List<Endereco>> buscarPorCidade(@PathVariable String cidade) {
        return ResponseEntity.ok(service.buscarPorCidade(cidade));
    }

    @PostMapping
    public ResponseEntity<Endereco> criar(@RequestBody Endereco endereco) {
        return ResponseEntity.ok(service.salvar(endereco));
    }

    @PutMapping("/{cep}")
    public ResponseEntity<Endereco> atualizar(@PathVariable String cep, @RequestBody Endereco endereco) {
        Endereco atualizado = service.atualizar(cep, endereco);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{cep}")
    public ResponseEntity<String> deletar(@PathVariable String cep) {
        service.deletar(cep);
        return ResponseEntity.ok("CEP " + cep + " removido com sucesso.");
    }
}
