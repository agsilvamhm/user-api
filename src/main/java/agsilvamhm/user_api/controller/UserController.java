package agsilvamhm.user_api.controller;

import agsilvamhm.user_api.dto.UserDto;
import agsilvamhm.user_api.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //public static List<UserDto> usuarios = new ArrayList<>();

    @GetMapping("/")
    public String getMensagem(){
        return "Spring boot is working!";
    }

  /*  @PostConstruct
    public void initiateList(){
        UserDto userDTO = new UserDto();
        userDTO.setNome("Eduardo");
        userDTO.setCpf("123");
        userDTO.setEndereco("Rua a");
        userDTO.setEmail("eduardo@email.com");
        userDTO.setTelefone("1234-3454");
        userDTO.setDataCadastro(new Date());
        UserDto userDTO2 = new UserDto();
        userDTO2.setNome("Luiz");
        userDTO2.setCpf("456");
        userDTO2.setEndereco("Rua b");
        userDTO2.setEmail("luiz@email.com");
        userDTO2.setTelefone("1234-3454");
        userDTO2.setDataCadastro(new Date());
        UserDto userDTO3 = new UserDto();
        userDTO3.setNome("Bruna");
        userDTO3.setCpf("678");
        userDTO3.setEndereco("Rua c");
        userDTO3.setEmail("bruna@email.com");
        userDTO3.setTelefone("1234-3454");
        userDTO3.setDataCadastro(new Date());
        usuarios.add(userDTO);
        usuarios.add(userDTO2);
        usuarios.add(userDTO3);
    } */

    @GetMapping("/user/")
    public List<UserDto> getUsers() {
        List<UserDto> usuarios = userService.getAll();
        return usuarios;
    }

    @GetMapping("/user/{id}")
    UserDto findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping("/user")
    UserDto newUser(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }

    @GetMapping("/user/cpf/{cpf}")
    UserDto findByCpf(@PathVariable String cpf) {
        return userService.findByCpf(cpf);
    }

    @DeleteMapping("/user/{id}")
    UserDto delete(@PathVariable Long id) {
        return userService.delete(id);
    }@GetMapping("/user/search")

    public List<UserDto> queryByName(
            @RequestParam(name="nome", required = true)
            String nome) {
        return userService.queryByName(nome);
    }
}
