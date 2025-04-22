package semana3_d.semana3_d;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@Service
public class EnvioService {

    private final EnvioRepository envioRepository;

    public EnvioService(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    public List<Envio> obtenerTodos() {
        return envioRepository.findAll();
    }

    public Envio obtenerPorId(int id) {
        return envioRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Envío no encontrado con ID: " + id
                ));
    }

    public Envio registrar(Envio nuevo) {
        validarEnvio(nuevo);
        return envioRepository.save(nuevo);
    }

    public Envio actualizar(int id, Envio datos) {
        Envio envioExistente = obtenerPorId(id);
        
        if (datos.getDestinatario() != null) {
            envioExistente.setDestinatario(datos.getDestinatario());
        }
        if (datos.getOrigen() != null) {
            envioExistente.setOrigen(datos.getOrigen());
        }
        if (datos.getDestino() != null) {
            envioExistente.setDestino(datos.getDestino());
        }
        if (datos.getEstado() != null) {
            envioExistente.setEstado(datos.getEstado());
        }
        if (datos.getUbicacion() != null) {
            envioExistente.setUbicacion(datos.getUbicacion());
        }
        
        return envioRepository.save(envioExistente);
    }

    public void eliminar(int id) {
        envioRepository.deleteById(id);
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