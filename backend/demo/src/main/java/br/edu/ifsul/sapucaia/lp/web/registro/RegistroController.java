package br.edu.ifsul.sapucaia.lp.web.registro;

import br.edu.ifsul.sapucaia.lp.dominio.dto.RegistroRequestDto;
import br.edu.ifsul.sapucaia.lp.service.registro.SalvarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/public/registro")
@RestController
public class RegistroController {

    @Autowired
    private SalvarUsuarioService salvarUsuario;

    @RequestMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void salvar(@RequestBody RegistroRequestDto registroDto){
        salvarUsuario.salvar(registroDto);
    }
}
