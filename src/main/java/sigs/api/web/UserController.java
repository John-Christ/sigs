package sigs.api.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import sigs.api.model.DAOUser;


import sigs.api.repository.DaoUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import sigs.api.exception.RestApiNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import sigs.api.repository.UserDao;


@Controller
@RequestMapping("/")
@RestController
public class UserController
{


    @Autowired
    private UserDao userDao;


    private final DaoUser repository;

    UserController(DaoUser repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/users")
    List<DAOUser> all() {
        return (List<DAOUser>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/user-add")
    DAOUser newUser(@RequestBody DAOUser newUser) {
        return repository.save(newUser);
    }

    // Single item

    @GetMapping("/user/{id}")
    DAOUser one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RestApiNotFoundException(id));
    }

    @PutMapping("/user-update/{id}")
    DAOUser replaceUser(@RequestBody DAOUser newUser, @PathVariable Long id) {

        return repository.findById(id)
                .map(user -> {
                    user.setNom(newUser.getNom());
                    user.setPrenom(newUser.getPrenom());
                    user.setEmail(newUser.getEmail());
                    user.setTel(newUser.getTel());
                    user.setUsername(newUser.getUsername());
                    user.setPassword(newUser.getPassword());
                    user.setRole(newUser.getRole());
                    user.setPermission(newUser.getPermission());
                    return repository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return repository.save(newUser);
                });
    }

    @DeleteMapping("/user-delete/{id}")
    void deleteUser(@PathVariable Long id) {
        repository.deleteById(id);
    }






    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ResponseEntity<?> getUser() throws Exception {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        return  ResponseEntity.ok(userDao.findByUsername(username));
    }



}

