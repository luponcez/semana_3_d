package semana3_d.semana3_d;


import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

public class EnvioService {

    private List<Envio> envios = new ArrayList<>();
    private int contadorId = 1;

    public EnvioService() {
        envios.add(new Envio(contadorId++, "Luis Ponce",  "Santiago, Chile",     "Madrid, España",   "En tránsito", "Santiago, Chile"));
        envios.add(new Envio(contadorId++, "Matilda Ponce",   "Buenos Aires, Arg.",  "Tokyo, Japón",     "En tránsito", "En vuelo a Japón"));
        envios.add(new Envio(contadorId++, "Joselin Rodriguez",    "Lima, Perú",          "Miami, EE.UU",     "En aduana",   "Aduana de EE.UU."));
    }

    public List<Envio> obtenerTodos() {
        return envios;
    }

    public Envio obtenerPorId(int id) {
        return envios.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Envío no encontrado con ID: " + id
                ));
    }

    public Envio registrar(Envio nuevo) {
        validarEnvio(nuevo);

        nuevo.setId(contadorId++);
        envios.add(nuevo);
        return nuevo;
    }

    public Envio actualizar(int id, Envio datos) {
        Envio envioExistente = obtenerPorId(id); 
        if (datos.getEstado() != null && !datos.getEstado().isEmpty()) {
            envioExistente.setEstado(datos.getEstado());
        }
        if (datos.getUbicacion() != null && !datos.getUbicacion().isEmpty()) {
            envioExistente.setUbicacion(datos.getUbicacion());
        }
        return envioExistente;
    }

    private void validarEnvio(Envio envio) {
        if (envio.getDestinatario() == null || envio.getDestinatario().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El destinatario es obligatorio.");
        }
        if (envio.getOrigen() == null || envio.getOrigen().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El origen es obligatorio.");
        }
        if (envio.getDestino() == null || envio.getDestino().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El destino es obligatorio.");
        }
    }
}
