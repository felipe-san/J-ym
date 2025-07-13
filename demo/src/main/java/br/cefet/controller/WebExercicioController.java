package br.cefet.controller;

import br.cefet.model.Exercicio;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequestMapping("/exercicios")
public class WebExercicioController {
    private final ExercicioController exercicioController;

    public WebExercicioController() {
        this.exercicioController = new ExercicioController();
    }

    @GetMapping
    public String listExercicios(Model model) {
        List<Exercicio> exercicios = exercicioController.lerExercicios();
        model.addAttribute("exercicios", exercicios);
        return "exercicios/list";
    }

    @GetMapping("/criar")
    public String showCreateForm(Model model) {
        model.addAttribute("exercicio", new Exercicio());
        return "exercicios/form";
    }

    @PostMapping("/criar")
    public String createExercicio(@ModelAttribute Exercicio exercicio) {
        exercicioController.criarExercicio(
            exercicio.getNome(),
            exercicio.getLocal(),
            exercicio.getSeries(),
            exercicio.getRepeticoes(),
            exercicio.getCarga(),
            exercicio.getTempoDescanso()
        );
        return "redirect:/exercicios";
    }

    @GetMapping("/editar/{indice}")
    public String showEditForm(@PathVariable int indice, Model model) {
        List<Exercicio> exercicios = exercicioController.lerExercicios();
        if (indice < 0 || indice >= exercicios.size()) {
            return "redirect:/exercicios";
        }
        model.addAttribute("exercicio", exercicios.get(indice));
        model.addAttribute("indice", indice);
        return "exercicios/form";
    }

    @PostMapping("/editar/{indice}")
    public String editExercicio(@PathVariable int indice, @ModelAttribute Exercicio exercicio) {
        exercicioController.atualizarExercicio(
            indice,
            exercicio.getNome(),
            exercicio.getLocal(),
            exercicio.getSeries(),
            exercicio.getRepeticoes(),
            exercicio.getCarga(),
            exercicio.getTempoDescanso()
        );
        return "redirect:/exercicios";
    }

    @PostMapping("/deletar/{indice}")
    public String deleteExercicio(@PathVariable int indice) {
        exercicioController.destruirExercicio(indice);
        return "redirect:/exercicios";
    }
}
