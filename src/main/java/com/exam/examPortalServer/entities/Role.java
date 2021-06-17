package com.exam.examPortalServer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Data
@Table(name = "roles")
//@JsonIgnoreProperties({"hibernateLazyInitializer","handlers","users"})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    private String roleName;

    @OneToMany( fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "role")
    @JsonIgnore
    private Set<User_Roles> userRoles = new HashSet<>();

    public Role() {
    }
    public Role(String roleName) {
        super();
        this.roleName = roleName;
    }

    public Set<User_Roles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<User_Roles> userRoles) {
        this.userRoles = userRoles;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
