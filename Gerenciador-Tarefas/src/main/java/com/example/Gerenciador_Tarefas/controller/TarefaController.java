package com.example.Gerenciador_Tarefas.controller;

import com.example.Gerenciador_Tarefas.model.Tarefa;
import com.example.Gerenciador_Tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    // Endpoint para listar todas as tarefas
    @GetMapping("/")
    public String listarTodas(Model model) {
        List<Tarefa> tarefas = tarefaService.listarTodas();
        model.addAttribute("tarefas", tarefas);
        return "index";
    }

    // Endpoint para criar uma nova tarefa
    @PostMapping
    public String criar(@ModelAttribute Tarefa tarefa) {
        tarefaService.criar(tarefa);
        return "redirect:/tarefas/"; // Redireciona para a lista de tarefas após criar
    }

    // Endpoint para excluir uma tarefa
    @PostMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        tarefaService.deletar(id);
        return "redirect:/tarefas/"; // Redireciona após excluir
    }
}
