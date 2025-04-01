package semana3_d.semana3_d;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {

    private final EnvioService envioService = new EnvioService();

    @GetMapping
    public List<Envio> getTodos() {
        return envioService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Envio getPorId(@PathVariable int id) {
        return envioService.obtenerPorId(id);
    }

    @PostMapping
    public Envio registrarEnvio(@RequestBody Envio nuevoEnvio) {
        return envioService.registrar(nuevoEnvio);
    }

    @PatchMapping("/{id}")
    public Envio actualizarEnvio(@PathVariable int id, @RequestBody Envio datosActualizados) {
        return envioService.actualizar(id, datosActualizados);
    }
}
