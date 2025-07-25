package agsilvamhm.user_api.service;

import agsilvamhm.user_api.dto.UserDto;
import agsilvamhm.user_api.model.User;
import agsilvamhm.user_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> getAll() {
        List<User> usuarios = userRepository.findAll();
        return usuarios
                .stream()
                .map(UserDto::convert)
                .collect(Collectors.toList());
    }

    public UserDto findById(long userId) {
        Optional<User> usuario = userRepository.findById(userId);
        if (usuario.isPresent()) {
            return UserDto.convert(usuario.get());
        }
        return null;
    }

    public UserDto save(UserDto userDTO) {
        User user = userRepository.save(User.convert(userDTO));
        return UserDto.convert(user);
    }

    public UserDto delete(long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            userRepository.delete(user.get());
        }
        return null;
    }

    public UserDto findByCpf(String cpf) {
        User user = userRepository.findByCpf(cpf);
        if (user != null) {
            return UserDto.convert(user);
        }
        return null;
    }

    public List<UserDto> queryByName(String name) {
        List<User> usuarios = userRepository.queryByNomeLike(name);
        return usuarios
                .stream()
                .map(UserDto::convert)
                .collect(Collectors.toList());
    }
}
