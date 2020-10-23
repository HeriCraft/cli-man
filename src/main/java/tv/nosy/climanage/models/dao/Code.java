package tv.nosy.climanage.models.dao;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CODE")
public class Code implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = -7460097040875188874L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REF")
    private long idCode;

    @OneToOne(mappedBy = "cd")
    private Users usr;

    @Column(name = "PASS")
    private String pass;

    @Column(name = "LAST_LOGGED")
    private Date lastLogged;


    // Constructors
    public Code(long idLogin, Users usr, String pass, Date lastLogged) {
        this.idCode = idLogin;
        this.usr = usr;
        this.pass = pass;
        this.lastLogged = lastLogged;
    }
    public Code() {
    
    }


    // Getters and Setters
    public long getIdCode() {
        return idCode;
    }

    public void setIdCode(long idLogin) {
        this.idCode = idLogin;
    }

    public Users getUsr() {
        return usr;
    }

    public void setUsr(Users usr) {
        this.usr = usr;
    }

    public Date getLastLogged() {
        return lastLogged;
    }

    public void setLastLogged(Date lastLogged) {
        this.lastLogged = lastLogged;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
