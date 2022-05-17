package es.juancarlos.beans;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author junco
 */
@Entity
@Table(name = "Usuarios")
public class Usuario implements Serializable {

    @Id
    @Column(name = "IdUsuario", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int IdUsuario;

    @Column(name = "DNI", nullable = false, length = 9)
    String dni;

    @Column(name = "Nombre", nullable = false, length = 50)
    String nombre;

    @Column(name = "Apellidos", nullable = false, length = 50)
    String apellidos;

    @Column(name = "Correo", nullable = false, length = 100)
    String email;

    

    /**
     * Constructor sin parametros
     */
    public Usuario() {
    }

    /**
     * Constructor con parametros
     *
     * @param u Usuario del que se quiere introducir los datos, usado para
     * consultas HQL (hibernate) y crear un usuario directamente
     */
    public Usuario(Usuario u) {
        this.IdUsuario = u.IdUsuario;
        this.dni = u.dni;
        this.nombre = u.nombre;
        this.apellidos = u.apellidos;
        this.email = u.email;
    }

    /**
     * Constructor con parametros
     *
     *
     * @param IdUsuario Id del usuario
     * @param dni       Dni del usuario
     * @param nombre    Nombre del usuario
     * @param apellidos Apellidos del usuario
     * @param email     Correo/email del usuario 
     */
    public Usuario(int IdUsuario, String dni, String nombre, String apellidos, String email) {
        this.IdUsuario = IdUsuario;
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;

    }

    /**
     *
     * @return Id del usuario
     */
    public int getIdUsuario() {
        return IdUsuario;
    }

    /**
     *
     * @param IdUsuario Id del usuario
     */
    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    /**
     *
     * @return Dni del usuario
     */
    public String getDni() {
        return dni;
    }

    /**
     *
     * @param dni Dni del usuario
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     *
     * @return Nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre Nombre del usuario
     */ 
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return  Apellidos del usuario
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *
     * @param apellidos Apellidos del usuario
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     *
     * @return Correo/email del usuario 
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email Correo/email del usuario 
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
