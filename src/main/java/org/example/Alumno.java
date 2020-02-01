package org.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Alumno")
public class Alumno {

    @Column(name = "nombre", nullable = false)
    private String Nombre;

    @Id
    @Column(name = "dni", insertable = false, nullable = false)
    private Integer DNI;

    @Column(name = "clase_id", nullable = false)
    private Integer classeId;

//    protected Alumnos(String nombre, Integer DNI, Integer classeId) {
//        Nombre = nombre;
//        this.DNI = DNI;
//        this.classeId = classeId;
//    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Integer getDNI() {
        return DNI;
    }

    public void setDNI(Integer DNI) {
        this.DNI = DNI;
    }

    public Integer getClasseId() {
        return classeId;
    }

    public void setClasseId(Integer classeId) {
        this.classeId = classeId;
    }

    public String toString() {
      return "Alumnos{Nombre=" + Nombre + 
        ", DNI=" + DNI + 
        ", classeId=" + classeId + 
        "}";
    }
}