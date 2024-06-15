package com.example.service;

import com.example.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final String USUARIO = "USUARIO";
    private final String MODERADOR = "MODERADOR";
    private final String ADMIN = "ADMIN";

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastraUsuario(String id, String nomeUsuario, String senha, long identificadorTipoUsuario) throws Exception{
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNome(nomeUsuario);
        usuario.setSenha(senha);

        switch ((int) identificadorTipoUsuario) {
            case 1:
                usuario.setTipoConta(USUARIO);
                break;
            case 2:
                usuario.setTipoConta(MODERADOR);
                break;
            case 3:
                usuario.setTipoConta(ADMIN);
                break;
            default:
                throw new Exception("Esolha o tipo de usuário corretamentre!!!! Exemplo: 1- COMUM, 2 - MODERADOR, 3 - ADMIN");
        }

         return this.salvarUsuario(usuario);
    }

    public List<Usuario> obtemTodos(){
        return this.usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(String idUsuario){
        return this.usuarioRepository.findById(idUsuario);
    }

    private Usuario salvarUsuario(Usuario usuario) throws Exception{
        return this.usuarioRepository.save(usuario);
    }

    public Object apagarUsuario(String idUsuario){
        this.usuarioRepository.deleteById(idUsuario);
        return "Usuario apagado do registro de dados!";
    }

}
