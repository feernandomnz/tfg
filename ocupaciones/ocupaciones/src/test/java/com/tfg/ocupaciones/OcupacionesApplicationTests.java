package com.tfg.ocupaciones;

import com.tfg.ocupaciones.model.Usuario;
import com.tfg.ocupaciones.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class OcupacionesApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    void cleanUp() {
        usuarioRepository.deleteAll();
    }

    @Test
    void contextLoads() {
        assertThat(mockMvc).isNotNull();
    }

    @Test
    void usuarioCrudGuardaPasswordCifrada() throws Exception {
        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {
                                  "email": "demo@ocupaciones.com",
                                  "password": "123456"
                                }
                                """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.email").value("demo@ocupaciones.com"))
                .andExpect(jsonPath("$.password").isString());

        Usuario usuario = usuarioRepository.findByEmail("demo@ocupaciones.com").orElseThrow();
        assertThat(usuario.getPassword()).isNotEqualTo("123456");
        assertThat(usuario.getPassword()).startsWith("$2");

        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].email").value("demo@ocupaciones.com"));

        mockMvc.perform(get("/usuarios/" + usuario.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("demo@ocupaciones.com"));

        mockMvc.perform(delete("/usuarios/" + usuario.getId()))
                .andExpect(status().isNoContent());

        assertThat(usuarioRepository.findById(usuario.getId())).isEmpty();
    }
}
