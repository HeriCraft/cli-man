package tv.nosy.climanage.models.dao;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users implements Serializable{
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long matricule;

    @Column(name = "NAME")
    private String name;

    @Column(name = "U_NAME")
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "LOGIN", 
        joinColumns = 
            { @JoinColumn(name = "USERS_ID", referencedColumnName = "ID") },
        
        inverseJoinColumns = 
            { @JoinColumn(name = "CODE_REF", referencedColumnName = "REF")})

    private Code cd;

    public Users() {
    }
    public Users(long matricule, String name, String username, Code cd) {
        this.matricule = matricule;
        this.name = name;
        this.username = username;
        this.cd = cd;
    }

    /**
     * @return long return the matricule
     */
    public long getMatricule() {
        return matricule;
    }

    /**
     * @param matricule the matricule to set
     */
    public void setMatricule(long matricule) {
        this.matricule = matricule;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return Code return the cd
     */
    public Code getCd() {
        return cd;
    }

    /**
     * @param cd the cd to set
     */
    public void setCd(Code cd) {
        this.cd = cd;
    }


}
