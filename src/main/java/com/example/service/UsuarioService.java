package com.example.service;

import com.example.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final String ADMIN = "ADMIN";
    private final String GERENTE = "GERENTE";
    private final String VENDEDOR = "VENDEDOR";
    private final String CLIENTE = "CLIENTE";

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastraUsuario(String id, String nomeUsuario, String senha, String email, long identificadorTipoUsuario) throws Exception{
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setNome(nomeUsuario);
        usuario.setSenha(senha);
        usuario.setEmailUser(email);

        switch ((int) identificadorTipoUsuario) {
            case 1:
                usuario.setTipoConta(ADMIN);
                break;
            case 2:
                usuario.setTipoConta(GERENTE);
                break;
            case 3:
                usuario.setTipoConta(VENDEDOR);
                break;
            case 4:
                usuario.setTipoConta(CLIENTE);
                break;
            default:
                throw new Exception("Esolha o tipo de usuário corretamentre!!!! Exemplo: 1- ADMIN, 2 - GERENTE, 3 - VENDEDOR, 4 - CLIENTE");
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
