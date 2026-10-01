package com.mx.animales.dao;

import java.util.*;
import org.junit.jupiter.api.*;
import com.mx.animales.dominio.*;
import org.springframework.boot.test.context.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.*;

@SpringBootTest
class AnimalesDaoTest {

    @Autowired
    private iAnimalesDao dao;

    @BeforeEach
    void setUp() throws Exception {
        dao.deleteAll();

        Animales a1 = new Animales(1, "Perro", "Willi", 3);
        Animales a2 = new Animales(2, "Perro", "Duque", 2);
        Animales a3 = new Animales(3, "Gato", "Bigotes", 1);

        dao.save(a1);
        dao.save(a2);
        dao.save(a3);
    }

    @Test
    void testListar() {
        //Recuperamos todos los registros de la bd
        List<Animales> animales = dao.findAll();

        //Validamos que existan exactamente 3 registros en la lista.
        assertEquals(3, animales.size());
    }

    @Test
    void testGuardar() {
        //Creamos el objeto que se va a guardar
        Animales animal = new Animales(4, "Raton", "Pepe", 1);

        dao.save(animal); //Guardamos

        //Buscamos para verificar que si se guardo
        Animales encontrado = dao.findById(4).orElse(null);

        //Validamos que el objeto NO sea null
        assertNotNull(encontrado);
        //Validamos que el objeto encontrado tenga por nombre Pepe
        assertEquals("Pepe", encontrado.getNombre());
    }

    @Test
    void testBuscar() {
        Animales animal = dao.findById(1).orElse(null);

        assertNotNull(animal);
        assertEquals(3, animal.getEdad());
    }

    @Test
    void testEditar() {
        Animales original = dao.findById(2).orElse(null);

        original.setNombre("UPDATE");
        original.setTipo("update");

        dao.save(original);

        Animales actualizado = dao.findById(2).orElse(null);

        assertEquals("UPDATE", actualizado.getNombre());
        assertNotEquals("Perro", actualizado.getTipo());
    }

    @Test
    void testEliminar() {
        Animales eliminado = dao.findById(3).orElse(null);

        dao.delete(eliminado);

        Animales encontrado = dao.findById(3).orElse(null);

        assertNull(encontrado);
        assertFalse(dao.findById(3).isPresent());
    }

    @Test
    void testBuscarPorNombre() {
        Animales animal = dao.findByNombreIgnoreCase("duque");

        assertNotNull(animal);
        assertEquals("Duque", animal.getNombre());
    }

    @Test
    void testBuscarPorTipo() {
        List<Animales> lista = dao.findByTipoIgnoreCase("perro");

        assertEquals(2, lista.size());
    }
}
