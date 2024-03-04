package sigs.api.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sigs.api.model.DAOUser;
import sigs.api.repository.FournisseurRepository;
import sigs.api.service.UserService;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;



@Controller
@RequestMapping("/")
@RestController
public class Assign
{


  //  @Autowired
   // private  UserService userService;


  /*  private final UserService userService;

    public Assign(UserService userService) {
        this.userService = userService;
    }  */


    @PutMapping("/user/{id}/role/{roleId}")
    public DAOUser assignRoleToUser(
            @PathVariable Long id,
            @PathVariable Long roleId,
            UserService userService
    ){

        return userService.assignRoleToUser(id, roleId);
    }




}

