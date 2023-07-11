package br.com.ProjetoMigra.controller;

import br.com.ProjetoMigra.entities.Formulario;
import br.com.ProjetoMigra.service.FormularioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FormularioController {
    private final FormularioService service;
    @Autowired
    public FormularioController(FormularioService service) {
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Formulario>> buscaTodos(){
        return ResponseEntity.ok(service.buscaTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Formulario> getFormularioById(@PathVariable Long id) {
        if (id == null || id <= 0) {
            return ResponseEntity.badRequest().build(); // ID inválido, retornar código de erro 400 Bad Request
            }
        Optional<Formulario> formularioOptional = service.buscaPorId(id);
        if (formularioOptional.isEmpty()) {
            return ResponseEntity.notFound().build(); // Formulário não encontrado, retornar código de erro 404 Not Found
        }
        return ResponseEntity.ok(formularioOptional.get()); // Retornar formulário encontrado com código de status 200 OK
    }
    @PostMapping("/formulario")
    public ResponseEntity<Formulario> salvar(@RequestBody Formulario formulario){
        var newForm = service.salva(formulario);
        return  new ResponseEntity<>(newForm, null, HttpStatus.CREATED);
    }
    @DeleteMapping
    public ResponseEntity<Void> remover(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
