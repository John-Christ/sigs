package sigs.api.model;



import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "utilisateur")
public class DAOUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String username;
    @Column
    private String password;


   // @Column
    // private String role;
   @ManyToOne
   @JoinColumn(name = "role_id")
   private Role role;





    @ManyToOne
    @JoinColumn(name = "permission_id")
    private Permission permission;




    @Column
    private String nom;
    @Column
    private String prenom;


    @Column
    private String email;


    @Column
    private String tel;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


   /* public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
*/
   public Role getRole() {
       return role;
   }

    public void setRole(Role role) {
        this.role = role;
    }


    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }



    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }












    @Override
    public String toString() {
        return "DAOUser [id=" + id + ", username=" + username +
                ", password=" + password + ", role=" + role +
                ", nom=" + nom + ", prenom=" + prenom +
                ", email=" + email + ", tel=" + tel + "]";
    }

}