package com.mx.animales.controller;

import java.util.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import tools.jackson.databind.*;
import com.mx.animales.dominio.*;
import static org.mockito.Mockito.*;
import org.springframework.http.MediaType;
import com.mx.animales.service.serviceImp.*;
import org.springframework.test.web.servlet.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.web.servlet.request.*;
import org.springframework.boot.webmvc.test.autoconfigure.*;
import org.springframework.test.context.bean.override.mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AnimalesWS.class) //Levanta solo el controlador, no toda la app
class AnimalesWSTest {

    @Autowired
    private MockMvc mockMvc; //Simula las peticiones GET, POST, PUT, DELETE

    @MockitoBean //Creamos un servicio falso para poder controlar las repuestas
    private AnimalesService service;

    //Convierte objetos java a JSON
    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void testListar() throws Exception {
        //Datos simulados
        Animales a1 = new Animales(1, "Perro", "willi", 3);
        Animales a2 = new Animales(2, "Gato", "michi", 2);

        //Simulacion del service
        when(service.listar()).thenReturn(Arrays.asList(a1, a2));

        //Peticion GET
        mockMvc.perform(MockMvcRequestBuilders.get("/Animales/listar"))
                .andExpect(status().isOk()) //Esperamos un status 200
                //Validamos que la lista tenga exactamente 2 valores
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void testGuardar() throws Exception {
        Animales a1 = new Animales(1, "Perro", "willi", 3);

        //Simulando el proceso de guardar del servicio
        when(service.guardar(Mockito.any(Animales.class))).thenReturn(a1);

        mockMvc.perform(MockMvcRequestBuilders.post("/Animales/guardar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(a1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("willi"));
    }

    @Test
    void testBuscar() throws Exception{
        Animales a1 = new Animales(1, "Perro", "willi", 3);

        when(service.buscar(1)).thenReturn(a1);

        mockMvc.perform(MockMvcRequestBuilders.get("/Animales/buscar/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("willi"));
    }

    @Test
    void testBuscarNoExiste() throws Exception{
        when(service.buscar(500)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/Animales/buscar/500"))
                .andExpect(status().isOk());
    }

    @Test
    void testEliminar() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.delete("/Animales/eliminar/1"))
                .andExpect(status().isOk());

        //Verificamos la interaccion con el service
        Mockito.verify(service, Mockito.times(1)).eliminar(1);
    }

    @Test
    void testBuscarPorNombre() throws Exception {
        Animales a1 = new Animales(1, "Perro", "willi", 3);

        when(service.buscarPorNombre("willi")).thenReturn(a1);

        mockMvc.perform(MockMvcRequestBuilders.get("/Animales/buscarPorNombre/willi"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.tipo").value("Perro"));
    }

    @Test
    void testBuscarPorTipo() throws Exception {
        Animales a1 = new Animales(1, "Perro", "willi", 3);
        Animales a2 = new Animales(2, "Perro", "michi", 2);

        when(service.buscarPorTipo("Perro")).thenReturn(Arrays.asList(a1, a2));

        mockMvc.perform(MockMvcRequestBuilders.get("/Animales/buscarPorTipo")
                        .param("tipo", "Perro"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }
}