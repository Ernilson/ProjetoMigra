package br.com.ProjetoMigra.repository;

import br.com.ProjetoMigra.entities.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioRepository extends JpaRepository<Formulario, Long> {
}
