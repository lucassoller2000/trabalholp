package br.edu.ifsul.sapucaia.lp.web.usuario;

import br.edu.ifsul.sapucaia.lp.dominio.Usuario;
import br.edu.ifsul.sapucaia.lp.dominio.dto.EdicaoRequestDto;
import br.edu.ifsul.sapucaia.lp.repository.IUsuarioRepository;
import br.edu.ifsul.sapucaia.lp.service.usuario.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import br.edu.ifsul.sapucaia.lp.security.UserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RequestMapping("/usuario")
@RestController
public class UsuarioController {

    @Autowired
    private BuscarUsuariosPorNomeDeUsuarioService buscarUsuariosPorNomeDeUsuario;

    @Autowired
    private Buscar3PrimeirosUsuariosPorNomeDeUsuarioService buscar3Primeiros;

    @Autowired
    private EditarUsuarioService editarUsuario;

    @Autowired
    private IUsuarioRepository usuarioRepository; 

    @GetMapping
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/buscar/todos/{username}/{pagina}")
    public Page<Usuario> buscarUsuariosPorNomeDeUsuario(@PathVariable("username") String username, @PathVariable("pagina") int pagina){
        return buscarUsuariosPorNomeDeUsuario.buscar(username, pagina);
    }

    @GetMapping("/buscar/primeiros/{username}")
    public List<Usuario> buscar3PrimeirosUsuariosPorNomeDeUsuario(@PathVariable("username") String username){
        return buscar3Primeiros.buscar(username);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void editar(@AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody EdicaoRequestDto edicaoDto){
        editarUsuario.editar(userPrincipal.getUsername(), edicaoDto);
    }
}    




