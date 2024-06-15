package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/save")
    public Object salvar(@RequestParam("id") String idUsuario, @RequestParam("nomeUsuario") String nomeUsuario, @RequestParam("senha") String senha, @RequestParam("identificadorTipoUsuario") long identificadorTipoUsuario) {
        try{
            return this.usuarioService.cadastraUsuario(idUsuario, nomeUsuario, senha, identificadorTipoUsuario);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public Object deletar(@RequestParam("id") String idUsuario){
        try{
            return this.usuarioService.apagarUsuario(idUsuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public Object obterTodos(){
        try{
            return this.usuarioService.obtemTodos();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }

    @GetMapping("/findById")
    public Object obterPorId(@RequestParam("id") String idUsuario){
        try{
            return this.usuarioService.findById(idUsuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro não tratado: " + e.getMessage());
        }
    }

}
