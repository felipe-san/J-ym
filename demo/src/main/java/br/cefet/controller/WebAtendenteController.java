package br.cefet.controller;

import br.cefet.model.Atendente;
import br.cefet.model.TipoContrato;
import br.cefet.model.TipoTurno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/atendentes")
public class WebAtendenteController {
    private final AtendenteController atendenteController;

    @Autowired
    public WebAtendenteController() {
        this.atendenteController = new AtendenteController();
    }

    @GetMapping
    public String listAtendentes(Model model) {
        List<Atendente> atendentes = atendenteController.lerAtendentes();
        model.addAttribute("atendentes", atendentes);
        return "atendentes/list";
    }

    @GetMapping("/criar")
    public String showCreateForm(Model model) {
        model.addAttribute("atendente", new Atendente());
        return "atendentes/form";
    }

    @PostMapping("/criar")
    public String createAtendente(@ModelAttribute Atendente atendente) {
        // Adapte conforme o construtor do seu AtendenteController
        atendenteController.criarAtendente(
            atendente.getTurno(),
            atendente.getMatricula(),
            atendente.getGenero(),
            atendente.getSalario(),
            atendente.getNome(),
            atendente.getSetor(),
            atendente.getDataNascimento(),
            atendente.getTipoContrato(),
            atendente.getStatus(),
            atendente.getDataAdmissao(),
            atendente.getCtps()
        );
        return "redirect:/atendentes";
    }

    @GetMapping("/editar/{indice}")
    public String showEditForm(@PathVariable int indice, Model model) {
        List<Atendente> atendentes = atendenteController.lerAtendentes();
        if (indice < 0 || indice >= atendentes.size()) {
            return "redirect:/atendentes";
        }
        model.addAttribute("atendente", atendentes.get(indice));
        model.addAttribute("indice", indice);
        return "atendentes/form";
    }

    @PostMapping("/editar/{indice}")
    public String editAtendente(@PathVariable int indice, @ModelAttribute Atendente atendente) {
        atendenteController.atualizarAtendente(
            indice,
            atendente.getTurno(),
            atendente.getMatricula(),
            atendente.getGenero(),
            atendente.getSalario(),
            atendente.getNome(),
            atendente.getSetor(),
            atendente.getDataNascimento(),
            atendente.getTipoContrato(),
            atendente.getStatus(),
            atendente.getDataAdmissao(),
            atendente.getCtps()
        );
        return "redirect:/atendentes";
    }

    @PostMapping("/deletar/{indice}")
    public String deleteAtendente(@PathVariable int indice) {
        atendenteController.destruirAtendente(indice);
        return "redirect:/atendentes";
    }
}
