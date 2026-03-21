package com.example.computadora.dominio;

import jakarta.persistence.*;

/**
 *
 * @author sebas
 */

@Entity //Esta anotacion indica que seras una entidad de persistencia, es decir, que se va a guardar en la BD
@Table(name="COMPUTADORAS_BD")// Esta anotacion especifica el nombre de la tabla en la BD
public class Computadoras {
    
    @Id//Define la llave primaria
    private int id;
    @Column(name = "MARCA")
    private String marca;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "RAM")
    private int ram;
    @Column(name = "PRECIO")
    private double precio;

    public Computadoras(int id, String marca, String modelo, int ram, double precio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ram = ram;
        this.precio = precio;
    }

    public Computadoras() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Computadoras{" + "id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", ram=" + ram + ", precio=" + precio + '}';
    }        
}
