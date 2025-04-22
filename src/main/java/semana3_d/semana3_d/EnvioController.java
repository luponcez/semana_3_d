package semana3_d.semana3_d;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping
    public List<Envio> getTodos() {
        return envioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Envio getPorId(@PathVariable int id) {
        return envioService.obtenerPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Envio registrarEnvio(@RequestBody Envio nuevoEnvio) {
        return envioService.registrar(nuevoEnvio);
    }

    @PutMapping("/{id}")
    public Envio actualizarEnvio(@PathVariable int id, @RequestBody Envio datosActualizados) {
        return envioService.actualizar(id, datosActualizados);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarEnvio(@PathVariable int id) {
        envioService.eliminar(id);
    }
}