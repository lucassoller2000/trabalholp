package br.edu.ifsul.sapucaia.lp.web.login;

import br.edu.ifsul.sapucaia.lp.dominio.dto.LoginRequestDto;
import br.edu.ifsul.sapucaia.lp.dominio.dto.LoginResponseDto;
import br.edu.ifsul.sapucaia.lp.service.login.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("public/login")
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto){
        return loginService.logar(loginRequestDto);
    }
}