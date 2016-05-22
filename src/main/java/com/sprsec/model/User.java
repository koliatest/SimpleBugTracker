package com.sprsec.model;

import com.sprsec.model.enums.RoleOfTheUser;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column(name = "date_of_registration")
    private Date dateOfRegistration = setDateByRegistration();

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<RoleOfTheUser> rolesOfTheUser = setDefaultRoles();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="project_user",
            joinColumns = @JoinColumn(name="usr_id"),
            inverseJoinColumns = @JoinColumn(name="proj_id")
    )

    private Set<Project> userProjects = new HashSet<Project>(0);

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "fixerOfTheIssue")
    private Set<Issue> issuesToFix = new HashSet<Issue>(0);

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "testerOfTheIssue")
    private Set<Issue> issuesToTest = new HashSet<Issue>(0);

    public User() {    }

    public Set<Project> getUserProjects() {
        return userProjects;
    }

    public void setUserProjects(Set<Project> userProjects) {
        this.userProjects = userProjects;
    }

    public Set<Issue> getIssuesToFix() {
        return issuesToFix;
    }

    public void setIssuesToFix(Set<Issue> issuesToFix) {
        this.issuesToFix = issuesToFix;
    }

    public Set<Issue> getIssuesToTest() {
        return issuesToTest;
    }

    public void setIssuesToTest(Set<Issue> issuesToTest) {
        this.issuesToTest = issuesToTest;
    }

    private static Set<RoleOfTheUser> setDefaultRoles() {
        Set<RoleOfTheUser> defaultRoles = new HashSet<RoleOfTheUser>();
        defaultRoles.add(RoleOfTheUser.ROLE_USER);
        return defaultRoles;
    }

    private static Date setDateByRegistration(){
        return new Date();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<RoleOfTheUser> getRolesOfTheUser() {
        return rolesOfTheUser;
    }

    public void setRolesOfTheUser(Set<RoleOfTheUser> rolesOfTheUser) {
        this.rolesOfTheUser = rolesOfTheUser;
    }

    public String getLogin() {

        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }
}
