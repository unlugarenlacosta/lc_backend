package com.unlugarenlacosta.controller;

import com.unlugarenlacosta.controller.Bean.UserBean;
import com.unlugarenlacosta.encoder.PasswordEncoderGenerator;
import com.unlugarenlacosta.entities.User;
import com.unlugarenlacosta.interfaces.UserRepository;
import com.unlugarenlacosta.response.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private PasswordEncoderGenerator passwordEncoderGenerator;

    @Autowired
    private UserRepository userRepository;

    //Metodo que busca un usuario por username y devuelve toda la entiedad usuario, del usuario encontrado
    @GetMapping(path="/username")
    public ResponseEntity findUsername(@RequestParam String username) {
        User user = userRepository.findByUsername(username);
        return new ResponseEntity(new GenericResponse("OK", user), HttpStatus.OK);
    }
    //Metodo que busca un usuario por email y devuelve toda la entiedad usuario, del usuario encontrado
    @GetMapping(path="/email")
    public ResponseEntity findEmail(@RequestParam String email) {
        User user = userRepository.findByEmail(email);
        return new ResponseEntity(new GenericResponse("OK", user), HttpStatus.OK);
    }
    /**
     * Metodo para registar a un usuario ha partir de un Bean
     * El bean se crea para mapear los datos recibidos
     * Los datos recibidos se setean en la entiedad usuario y despues se guardan
    **/
    @PostMapping(path="/register")
    public ResponseEntity saveUser(@RequestBody UserBean userBean) {
        User user = new User();

        String encodePassword = passwordEncoderGenerator.encode(userBean.getPassword());

        user.setEmail(userBean.getEmail());
        user.setPassword(encodePassword);
        user.setDeleted(false);
        user.setUsername(userBean.getUsername());
        userRepository.save(user);
        return new ResponseEntity(new GenericResponse("OK", userBean), HttpStatus.OK);
    }

    /**
     * Metodo para verificar que el usuario existe en la base de datos y puede entrar
     * Primero se mira si el usuario existe, si existe entrara en la condición
     * Se desencripta la contraseña para comprobar que es correcta y se devuelve el usuario
     */
    @PostMapping(path="/login")
    public ResponseEntity loginUser(@RequestBody UserBean userBean) {
        User user = userRepository.findByEmail(userBean.getEmail());

        if(user != null){
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            if(bCryptPasswordEncoder.matches(userBean.getPassword(), user.getPassword())){
                return new ResponseEntity(new GenericResponse("User exists", user), HttpStatus.OK);
            }else {
                return new ResponseEntity(new GenericResponse("Invalid password", userBean), HttpStatus.NOT_FOUND);
            }
        }else {
            return new ResponseEntity(new GenericResponse("Not exists", userBean), HttpStatus.NOT_FOUND);
        }
    }
}
