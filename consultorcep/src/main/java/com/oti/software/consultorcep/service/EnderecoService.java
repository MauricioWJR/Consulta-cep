package com.oti.software.consultorcep.service;

import com.oti.software.consultorcep.exception.RecursoNaoEncontrado; 
import com.oti.software.consultorcep.model.Endereco;
import com.oti.software.consultorcep.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public Endereco salvar(Endereco endereco) {
        return repository.save(endereco);
    }

    public List<Endereco> listarTodos() {
        List<Endereco> enderecos = repository.findAll();
        if (enderecos.isEmpty()) {
            throw new RecursoNaoEncontrado("Nenhum endereço encontrado no sistema.");
        }
        return enderecos;
    }

    public Endereco buscarPorCep(String cep) {
        return repository.findById(cep)
                .orElseThrow(() -> new RecursoNaoEncontrado("CEP " + cep + " não encontrado."));
    }

    public List<Endereco> buscarPorLogradouro(String logradouro) {
        List<Endereco> enderecos = repository.findByLogradouro(logradouro);
        if (enderecos.isEmpty()) {
            throw new RecursoNaoEncontrado("Nenhum endereço encontrado para o logradouro: " + logradouro);
        }
        return enderecos;
    }

    public List<Endereco> buscarPorCidade(String cidade) {
        List<Endereco> enderecos = repository.findByCidade(cidade);
        if (enderecos.isEmpty()) {
            throw new RecursoNaoEncontrado("Nenhum endereço encontrado para a cidade: " + cidade);
        }
        return enderecos;
    }

    public Endereco atualizar(String cep, Endereco endereco) {
        if (!repository.existsById(cep)) {
            throw new RecursoNaoEncontrado("Não foi possível atualizar. O CEP " + cep + " não existe.");
        }
        endereco.setCep(cep);
        return repository.save(endereco);
    }

    public void deletar(String cep) {
        if (!repository.existsById(cep)) {
            throw new RecursoNaoEncontrado("Não foi possível excluir. O CEP " + cep + " não existe.");
        }
        repository.deleteById(cep);
    }
}
