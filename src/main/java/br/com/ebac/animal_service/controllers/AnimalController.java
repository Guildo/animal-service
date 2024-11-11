package br.com.ebac.animal_service.controllers;

import br.com.ebac.animal_service.entidades.Animal;
import br.com.ebac.animal_service.repositorios.AnimalRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/animais")
public class AnimalController {

    private AnimalRepository repository;

    public AnimalController(AnimalRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    private List<Animal> findAll() {
        return repository.findAll();
    }

    @PostMapping
    private Animal create(@RequestBody Animal animal) {
        return repository.save(animal);
    }

    @GetMapping("/not-adopted")
    private List<Animal> findNotAdopted() {
        return repository.findNotAdopted();
    }

    @GetMapping("/adopted")
    private List<Animal> findAdopted() {
        return repository.findAdopted();
    }

    @GetMapping("/especie/{especie}")
    private List<Animal> findByEspecie(@PathVariable String especie) {
        return repository.findByEspecie(especie);
    }

    @GetMapping("/nome-recebedor/{nomeRecebedor}/{dataInicial}/{dataFinal}")
    private List<Animal> findByNomeRecebedor(@PathVariable String nomeRecebedor, @PathVariable Date dataInicial, @PathVariable Date dataFinal) {
        return repository.findByNomeRecebedor(nomeRecebedor, dataInicial, dataFinal);
    }
}
