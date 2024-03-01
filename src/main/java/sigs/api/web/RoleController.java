package sigs.api.web;


import java.util.List;

import sigs.api.model.Role;
import sigs.api.repository.RoleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import sigs.api.exception.RestApiNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/")
@RestController
public class RoleController
{


    private final RoleRepository repository;

    RoleController(RoleRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/roles")
    List<Role> all() {
        return (List<Role>) repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/role-add")
    Role newRole(@RequestBody Role newRole) {
        return repository.save(newRole);
    }

    // Single item

    @GetMapping("/role/{id}")
    Role one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new RestApiNotFoundException(id));
    }

    @PutMapping("/role-update/{id}")
    Role replaceRole(@RequestBody Role newRole, @PathVariable Long id) {

        return repository.findById(id)
                .map(role -> {
                    role.setLabel(newRole.getLabel());
                    role.setStatut(newRole.getStatut());
                    role.setDescription(newRole.getDescription());


                    return repository.save(role);
                })
                .orElseGet(() -> {
                    newRole.setId(id);
                    return repository.save(newRole);
                });
    }

    @DeleteMapping("/role-delete/{id}")
    void deleteRole(@PathVariable Long id) {
        repository.deleteById(id);
    }






}

