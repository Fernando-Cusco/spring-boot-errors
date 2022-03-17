package ec.edu.ups.error.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ec.edu.ups.error.errors.UsuarioNoEncontradoException;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler({ArithmeticException.class})
    public String aritmeticaError(ArithmeticException exception, Model model) {
        model.addAttribute("error", "Error de aritmética");
        model.addAttribute("message", exception.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        return "error/aritmetica";
    }

    @ExceptionHandler({NumberFormatException.class})
    public String convertirError(NumberFormatException exception, Model model) {
        model.addAttribute("error", "Error de conversión");
        model.addAttribute("message", exception.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        return "error/aritmetica";
    }

    @ExceptionHandler({UsuarioNoEncontradoException.class})
    public String usuarioNoEncontradoError(UsuarioNoEncontradoException exception, Model model) {
        model.addAttribute("error", "Usuario no encontrado");
        model.addAttribute("message", exception.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new Date());
        return "error/aritmetica";
    }
    
}
