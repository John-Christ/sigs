package sigs.api.model;


import javax.persistence.*;

@Entity
@Table(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column
    private String action;



    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;



    @ManyToOne
    @JoinColumn(name = "module_id")
    private Module module;



    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }



    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }




    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }





}

