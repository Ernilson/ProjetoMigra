package br.com.ProjetoMigra.service;

import br.com.ProjetoMigra.entities.Formulario;
import br.com.ProjetoMigra.repository.FormularioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class FormularioService {
    private FormularioRepository repository;
    @Autowired
    public FormularioService(FormularioRepository repository) {
        this.repository = repository;
    }

    public List<Formulario> buscaTodos(){
        return repository.findAll();
    }

    public Formulario salva(Formulario formulario){
        try {
            return repository.save(formulario);
        }catch (Exception e){
            log.info(e.getMessage());
        }
        return null;
    }

    public Optional<Formulario> buscaPorId(Long id) {
        if (id != null && id > 0) {
            try {
                return repository.findById(id);
            } catch (Exception e) {
                log.info(e.getMessage());
            }
        }
        return Optional.empty(); //
    }


    public void delete (Long id){
        try {
           repository.deleteById(id);
        }catch (Exception e){
            log.info(e.getMessage());
        }

    }


}
