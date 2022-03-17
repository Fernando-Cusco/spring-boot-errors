package ec.edu.ups.error.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ec.edu.ups.error.errors.UsuarioNoEncontradoException;
import ec.edu.ups.error.models.domain.Usuario;
import ec.edu.ups.error.services.IUsuarioService;

@Controller
public class AppController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/")
    public String index() {
        Integer valor = 100/0;
        System.out.println(valor);
        return "index";
    }

    @GetMapping("/convertir")
    public String convertir() {
        Integer valor = Integer.parseInt("100s");
        System.out.println(valor);
        return "convertir";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model model) {
        // Usuario usuario = usuarioService.buscarUsuarioPorId(id);
        // if (usuario == null) {
            //     throw new UsuarioNoEncontradoException(id.toString());
            // }
        Usuario usuario = usuarioService.buscarUsuarioPorIdOptional(id).orElseThrow(() -> new UsuarioNoEncontradoException(id.toString()));
        model.addAttribute("titulo", "Detalle de usuario");
        model.addAttribute("usuario", usuario);
        return "ver";
    }
    
}
