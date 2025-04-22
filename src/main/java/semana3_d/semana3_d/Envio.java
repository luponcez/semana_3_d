package semana3_d.semana3_d;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "envios")
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "envio_seq")
    @SequenceGenerator(name = "envio_seq", sequenceName = "envios_seq", allocationSize = 1)
    private int id;
    private String destinatario;
    private String origen;
    private String destino;
    private String estado;    
    private String ubicacion;

    public Envio() {
        // Constructor vacío requerido por JPA
    }

    public Envio(int id, String destinatario, String origen, String destino, String estado, String ubicacion) {
        this.id = id;
        this.destinatario = destinatario;
        this.origen = origen;
        this.destino = destino;
        this.estado = estado;
        this.ubicacion = ubicacion;
    }

    // Getters y Setters
    public int getId() { return id; }
    public String getDestinatario() { return destinatario; }
    public String getOrigen() { return origen; }
    public String getDestino() { return destino; }
    public String getEstado() { return estado; }
    public String getUbicacion() { return ubicacion; }

    public void setId(int id) { this.id = id; }
    public void setDestinatario(String destinatario) { this.destinatario = destinatario; }
    public void setOrigen(String origen) { this.origen = origen; }
    public void setDestino(String destino) { this.destino = destino; }
    public void setEstado(String estado) { this.estado = estado; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
}