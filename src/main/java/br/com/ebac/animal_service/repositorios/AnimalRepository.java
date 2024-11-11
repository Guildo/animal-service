package br.com.ebac.animal_service.repositorios;

import br.com.ebac.animal_service.entidades.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NULL ORDER BY a.dataEntrada")
    List<Animal> findNotAdopted();

    @Query("SELECT a FROM Animal a WHERE a.dataAdocao IS NOT NULL")
    List<Animal> findAdopted();

    List<Animal> findByEspecie(String especie);

    @Query("SELECT a FROM Animal a WHERE a.nomeRecebedor = :nomeRecebedor AND a.dataEntrada BETWEEN :dataInicial AND :dataFinal")
    List<Animal> findByNomeRecebedor(@Param("nomeRecebedor") String nomeRecebedor, @Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal);
}
