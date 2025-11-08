package com.oti.software.consultorcep.repository;
import com.oti.software.consultorcep.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, String> {

    @Query("SELECT e FROM Endereco e WHERE LOWER(e.logradouro) LIKE LOWER(CONCAT('%', :logradouro, '%'))")
    List<Endereco> findByLogradouro(String logradouro);

    @Query("SELECT e FROM Endereco e WHERE LOWER(e.cidade) LIKE LOWER(CONCAT('%', :cidade, '%'))")
    List<Endereco> findByCidade(String cidade);
}
