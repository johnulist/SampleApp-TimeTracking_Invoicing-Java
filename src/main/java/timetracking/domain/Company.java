package timetracking.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: russellb337
 * Date: 6/17/14
 * Time: 5:41 PM
 */
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private boolean connectedToQbo;

    @Column(unique = true)
    private String qboId;

    private String requestToken;
    private String requestTokenSecret;
    private String accessToken;
    private String accessTokenSecret;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private final List<Role> roles = new ArrayList<>();

    public Company() {

    }

    public Company(String qdoId, String accessToken, String accessTokenSecret) {
        this.qboId = qdoId;
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;
        this.connectedToQbo = true;
    }

    public Company(String name) {
        this.name = name;
        this.connectedToQbo = false;
    }

    public long getId() {
        return id;
    }

    public String getQboId() {
        return qboId;
    }

    public void setQboId(String qboId) {
        this.qboId = qboId;
    }

    public String getRequestToken() {
        return requestToken;
    }

    public void setRequestToken(String requestToken) {
        this.requestToken = requestToken;
    }

    public String getRequestTokenSecret() {
        return requestTokenSecret;
    }

    public void setRequestTokenSecret(String requestTokenSecret) {
        this.requestTokenSecret = requestTokenSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }

    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isConnectedToQbo() {
        return connectedToQbo;
    }

    public void setConnectedToQbo(boolean connectedToQbo) {
        this.connectedToQbo = connectedToQbo;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
        role.setCompany(this);
    }


}
