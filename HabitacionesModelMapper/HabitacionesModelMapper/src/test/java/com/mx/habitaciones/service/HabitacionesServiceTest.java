package com.mx.habitaciones.service;

import java.util.*;
import org.mockito.*;
import org.modelmapper.*;
import org.junit.jupiter.api.*;
import com.mx.habitaciones.dao.*;
import com.mx.habitaciones.dto.*;
import org.mockito.junit.jupiter.*;
import static org.mockito.Mockito.*;
import com.mx.habitaciones.dominio.*;
import org.junit.jupiter.api.extension.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HabitacionesServiceTest {

    @Mock
    private iHabitacionesDao dao;

    @Mock
    private ModelMapper mapper;

    @InjectMocks
    private HabitacionesService service;

    //Objetos reutilizables
    private Habitaciones h1;
    private Habitaciones h2;
    private HabitacionResponseDTO dto1;
    private HabitacionResponseDTO dto2;

    @BeforeEach
    void setUp() throws Exception {

        h1=new Habitaciones();
        h2=new Habitaciones();
        dto1 = new HabitacionResponseDTO();
        dto2 = new HabitacionResponseDTO();
        h1.setNumero("101");
        h2.setNumero("102");
        dto1.setNumero("101");
        dto2.setNumero("102");
    }

    @Test
    void testListar() {
        //Simulacion del dao
        when(dao.findAll()).thenReturn(Arrays.asList(h1, h2));

        //Simulacion del mapero de entidad a dto
        when(mapper.map(h1, HabitacionResponseDTO.class)).thenReturn(dto1);
        when(mapper.map(h2, HabitacionResponseDTO.class)).thenReturn(dto2);

        //Ejecutamos el metodo del service
        List<HabitacionResponseDTO> resultado = service.listar();

        assertEquals(2, resultado.size());
        assertEquals("101", resultado.get(0).getNumero());

        //Verificamos el el dao llamo al metodo findAll
        verify(dao).findAll();
        //Verificamos que el mapper se uso 2 veces
        verify(mapper, times(2)).map(any(Habitaciones.class), eq(HabitacionResponseDTO.class));
    }

    @Test
    void testGuardar() {
        //Creamos un dto de entrada
        HabitacionRequestDTO request = new HabitacionRequestDTO();
        request.setNumero("201");
        request.setPrecio(1500);
        request.setTipo("Suite");

        Habitaciones entity = new Habitaciones();
        entity.setNumero("201");

        //Entidad que regresa la bd
        Habitaciones guardado = new Habitaciones();
        guardado.setNumero("201");
        guardado.setDisponible(true);

        //DTO de repuesta
        HabitacionResponseDTO response = new HabitacionResponseDTO();
        response.setNumero("201");

        //Simulacion de conversiones y guardado
        when(mapper.map(request, Habitaciones.class)).thenReturn(entity);
        when(dao.save(entity)).thenReturn(guardado);
        when(mapper.map(guardado, HabitacionResponseDTO.class)).thenReturn(response);

        //Ejecutamos el metodo
        HabitacionResponseDTO resultado = service.guardar(request);

        assertNotNull(resultado);
        assertEquals("201", resultado.getNumero());

        //Verificamos las llamadas
        verify(dao).save(entity);
        verify(mapper).map(request, Habitaciones.class);
        verify(mapper).map(guardado, HabitacionResponseDTO.class);
    }

    @Test
    void testBuscar() {
        //Simulamos que existe un registro
        when(dao.findById(1)).thenReturn(Optional.of(h1));

        //Simulamos el mapeo
        when(mapper.map(h1, HabitacionResponseDTO.class)).thenReturn(dto1);

        //Ejecutamos el metodo
        HabitacionResponseDTO resultado = service.buscar(1);

        //Validaciones
        assertNotNull(resultado);
        assertEquals("101", resultado.getNumero());

        //Verificamos
        verify(dao).findById(1);
        verify(mapper).map(h1, HabitacionResponseDTO.class);
    }

    @Test
    void testBuscarNoEncontrado() {
        //Simulamos que no existe el registro
        when(dao.findById(99)).thenReturn(Optional.empty());

        //Esperamos que lance exception
        assertThrows(RuntimeException.class, () -> service.buscar(99));

        //Verificamos la llamada
        verify(dao).findById(99);
    }

    @Test
    void testEditar(){
        //DTO con valores nuevos
        HabitacionRequestDTO request = new HabitacionRequestDTO();
        request.setNumero("202");
        request.setPrecio(900);
        request.setTipo("Doble");

        //Entidad actualizada
        Habitaciones actualizado = new Habitaciones();
        actualizado.setNumero("202");

        //DTO de respuesta
        HabitacionResponseDTO response = new HabitacionResponseDTO();
        response.setNumero("202");

        //Simulamoslos comportamientos
        when(dao.findById(1)).thenReturn(Optional.of(h1)); //Existe
        when(dao.save(h1)).thenReturn(actualizado); //Se guarda
        when(mapper.map(actualizado, HabitacionResponseDTO.class)).thenReturn(response);

        //Ejecutamos el metodo
        HabitacionResponseDTO resultado = service.editar(1, request);

        //Validamos
        assertEquals("202", resultado.getNumero());

        //Verificamos el flujo
        verify(dao).findById(1);
        verify(dao).save(h1);
        verify(mapper).map(actualizado, HabitacionResponseDTO.class);
    }

    @Test
    void testEditarNoEncontrado() {
        //DTO vacio
        HabitacionRequestDTO request = new HabitacionRequestDTO();

        //Simulamos que no existe
        when(dao.findById(99)).thenReturn(Optional.empty());

        //Esperamos la excepción
        assertThrows(RuntimeException.class, () -> service.editar(99, request));

        //Verificamos
        verify(dao).findById(99);
    }

    @Test
    void testEliminar() {
        //Simular que si existe
        when(dao.findById(1)).thenReturn(Optional.of(h1));

        //Ejecutamos la eliminación
        service.eliminar(1);

        //Verificamos el flujo
        verify(dao).findById(1);
        verify(dao).delete(h1);
    }
}