package com.api.advApp.controllers;


import com.api.advApp.dtos.UserDto;
import com.api.advApp.models.UserModel;
import com.api.advApp.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/usuarios")
public class UserController {
    final UserService userService;

   public UserController(UserService userService){
       this.userService = userService;
   }

    @PostMapping
    public ResponseEntity<Object> saveUser (@RequestBody  UserDto userDto){

        var userModel = new UserModel();

        BeanUtils.copyProperties(userDto,userModel);
        System.out.println(userModel.getNome());



        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));

    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id")Long id) {
        Optional<UserModel> userModelOptional = userService.findById(id);
        if (!userModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Long id){
        Optional<UserModel> userModelOptional = userService.findById(id);
        if (!userModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario não encontrado.");
        }
        userService.delete(userModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuario deletado");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") Long id,
                                                 @RequestBody @Valid UserDto userDto){
        Optional<UserModel> userModelOptional = userService.findById(id);
        if (!userModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usario não encontrado.");
        }

        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto,userModel);
        userModel.setUserId(userModelOptional.get().getUserId());

        return ResponseEntity.status(HttpStatus.OK).body(userService.save(userModel));
    }
}
