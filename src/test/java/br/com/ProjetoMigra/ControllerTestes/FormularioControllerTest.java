package br.com.ProjetoMigra.ControllerTestes;

import br.com.ProjetoMigra.entities.Formulario;
import br.com.ProjetoMigra.service.FormularioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class FormularioControllerTest {
   @Autowired
   MockMvc mockMvc;
   @Autowired
   ObjectMapper mapper;
   @Autowired
   private FormularioService service;

    @BeforeEach
   void setUp(){
        Formulario form = new Formulario();
        form.setNome("teste1");
        form.setEmail("teste@teste");
        form.setEnder("teste");
        form.setFone(Integer.parseInt("123456789"));
        service.salva(form);
   }
//   @AfterEach
//   void setDown(Long id){
//        repository.deleteAll();
//   }

   @Test
   @DisplayName("Listar todos pacientes")
   void deve_listarTodos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
   }

   @Test
   @DisplayName("Salva Formulario com sucesso")
   void salvarFormulario() throws Exception {
        Formulario formulario = new Formulario();
               formulario.setNome("Ernilson");
               formulario.setEnder("Quadra 105");
               formulario.setFone(123456);
               formulario.setEmail("teste@teste.com");
               service.salva(formulario);
        //Ação
       mockMvc.perform(MockMvcRequestBuilders.post("/api/formulario")
                       .contentType(MediaType.APPLICATION_JSON)
                       .characterEncoding("UTF-8")
                       .content(mapper.writeValueAsString(formulario)))

               // Verificações
               .andExpect(MockMvcResultMatchers.status().isCreated())
               .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Ernilson"))
               .andExpect(MockMvcResultMatchers.jsonPath("$.ender").value("Quadra 105"))
               .andExpect(MockMvcResultMatchers.jsonPath("$.fone").value(123456))
               .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("teste@teste.com"))

               //Impressão do resultado
               .andDo(MockMvcResultHandlers.print());
   }
}

