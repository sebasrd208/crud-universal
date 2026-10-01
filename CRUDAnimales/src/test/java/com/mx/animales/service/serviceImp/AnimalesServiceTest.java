package com.mx.animales.service.serviceImp;

import java.util.*;
import org.mockito.*;
import com.mx.animales.dao.*;
import org.junit.jupiter.api.*;
import com.mx.animales.dominio.*;
import static org.mockito.Mockito.*;
import org.springframework.data.domain.*;
import static org.junit.jupiter.api.Assertions.*;

class AnimalesServiceTest {

    //Creamos un Mock del DAO (objeto falso o simulado)
    @Mock
    private iAnimalesDao dao;

    //Inyectamos el dao simulado dentro del servicio
    @InjectMocks
    private AnimalesService service;

    @BeforeEach
    void setUp() throws Exception {
        //Inicializamos los mocks antes de cada prueba unitaria
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListar() {
        List<Animales> lista = Arrays.asList(
                new Animales(1, "Perro", "Willi", 3),
                new Animales(2, "Gato", "Bigotes", 1)
        );

        //Simulamos el comportamiento del dao
        //when(dao.findAll(Sort.by(Sort.Direction.ASC, "id"))).thenReturn(lista);
        when(dao.findAll(any(Sort.class))).thenReturn(lista);

        List<Animales> resultado = service.listar();

        assertEquals(2, resultado.size());
        //Verificamos que el mock dao llamo al menos una vez al metodo findAll
        verify(dao).findAll(any(Sort.class));
    }

    @Test
    void testGuardar() {
        Animales animal = new Animales(1, "Perro", "Beto", 2);

        //Simulamos la accion de guardar desde el dao
        when(dao.save(animal)).thenReturn(animal);

        Animales resultado = service.guardar(animal);

        assertNotNull(resultado);
        assertEquals("Beto", resultado.getNombre());

        verify(dao).save(animal);
    }

    @Test
    void testBuscarPorNombre() {
        //Datos simulados
        Animales a1 = new Animales(1, "Perro", "Duque", 3);
        Animales a2 = new Animales(3, "Perro", "Sam", 1);

        //Simulamos el comportamiento del dao
        when(dao.findByNombreIgnoreCase("sam")).thenReturn(a2);

        //Llamamos al metodo del servicio
        Animales encontrado = service.buscarPorNombre("sam");

        assertNotNull(encontrado);
        assertEquals("Perro", encontrado.getTipo());

        verify(dao).findByNombreIgnoreCase("sam");
    }

    @Test
    void testBuscarPorTipo() {
        //Datos simulados
        Animales a1 = new Animales(1, "Perro", "Duque", 3);
        Animales a2 = new Animales(3, "Perro", "Sam", 1);

        //Simulacion del dao
        when(dao.findByTipoIgnoreCase("Perro")).thenReturn(Arrays.asList(a1, a2));

        List<Animales> resultado = service.buscarPorTipo("Perro");

        assertEquals(2, resultado.size());
        assertEquals("Duque", resultado.get(0).getNombre());

        verify(dao).findByTipoIgnoreCase("Perro");
    }

    @Test
    void testBuscar() {
        Animales a1 = new Animales(1, "Perro", "Duque", 3);

        when(dao.findById(1)).thenReturn(Optional.of(a1));

        Animales animal = service.buscar(1);

        assertNotNull(animal);
        assertEquals("Duque", animal.getNombre());

        verify(dao).findById(1);
    }

    @Test
    void testEliminar() {
        service.eliminar(1);
        verify(dao).deleteById(1);
    }

}