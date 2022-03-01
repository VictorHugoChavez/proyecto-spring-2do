package com.generation.restcontroller.controller;

import com.generation.restcontroller.model.User;
import com.generation.restcontroller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/user") // request mapping es para colocar un subfijo y todas las rutas empezaran por lo que est adentro
public class UserController {

    private final UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping // primer metodo como no tiene ruta se va ejecutar  a la linea 11
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{id}") //  api/user/3  ruta por get  get manda informacion- y post guarda la informacion
    public User getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }


    @GetMapping("/all") //  api/user/all
    public ArrayList<User> getUsers() {
        return (ArrayList<User>) userService.getUsers();
    }
    @GetMapping("/search")
    public ArrayList<User> findByName(@RequestParam(name="name") String name){
    	return (ArrayList<User>) userService.findByName(name);
    }
}
