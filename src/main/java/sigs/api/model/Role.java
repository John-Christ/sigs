package sigs.api.model;


import javax.persistence.*;
import java.awt.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String label;
    @Column
    // @JsonIgnore
    private String statut;


    @Column
    private String description;



    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }



    public String getStatut() {
        return statut;
    }
    public void setStatut(String statut) {
        this.statut = statut;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }





}


