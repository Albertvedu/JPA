package org.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "Clase")
@Entity
public class Clase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String Nombre;

    @Column(name = "rama", nullable = false)
    private String Rama;

    @Column(name = "n_alumnos", nullable = false)
    private Integer nAlumnos;

    @Column(name = "instituto_id", nullable = false)
    private Integer idInstituto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getRama() {
        return Rama;
    }

    public void setRama(String Rama) {
        this.Rama = Rama;
    }

    public Integer getNAlumnos() {
        return nAlumnos;
    }

    public void setNAlumnos(Integer nAlumnos) {
        this.nAlumnos = nAlumnos;
    }

    public Integer getIdInstituto() {
        return idInstituto;
    }

    public void setIdInstituto(Integer idInstituto) {
        this.idInstituto = idInstituto;
    }

    public String toString() {
      return "Clase{id=" + id + 
        ", Nombre=" + Nombre + 
        ", Rama=" + Rama + 
        ", nAlumnos=" + nAlumnos + 
        ", idInstituto=" + idInstituto + 
        "}";
    }
}