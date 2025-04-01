package semana3_d.semana3_d;

public class Envio {
    private int id;
    private String destinatario;
    private String origen;
    private String destino;
    private String estado;    
    private String ubicacion; 

    public Envio(int id, String destinatario, String origen, String destino, String estado, String ubicacion) {
        this.id = id;
        this.destinatario = destinatario;
        this.origen = origen;
        this.destino = destino;
        this.estado = estado;
        this.ubicacion = ubicacion;
    }

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
