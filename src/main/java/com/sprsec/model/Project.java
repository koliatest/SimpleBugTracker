package com.sprsec.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project
{
    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column
    private String nameOfTheProject;

    @Column
    private String descriptionOfTheProject;

    @OneToOne
    @JoinColumn(name = "leadOfTheProject_id")
    private User leadOfTheProject;

    //cascade = CascadeType.ALL
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="project_user",
            joinColumns = @JoinColumn(name="proj_id"),
            inverseJoinColumns = @JoinColumn(name="usr_id")
    )
    private Set<User> usersInTheCurrentProject = new HashSet<User>(0);

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "projectOfTheIssue")
    private Set<Issue> issuesSet = new HashSet<Issue>(0);

    public Project() {}

    public Integer getId() {
        return id;
    }

    public Set<Issue> getIssuesSet() {
        return issuesSet;
    }

    public void setIssuesSet(Set<Issue> issuesSet) {
        this.issuesSet = issuesSet;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameOfTheProject() {
        return nameOfTheProject;
    }

    public void setNameOfTheProject(String nameOfTheProject) {
        this.nameOfTheProject = nameOfTheProject;
    }

    public String getDescriptionOfTheProject() {
        return descriptionOfTheProject;
    }

    public void setDescriptionOfTheProject(String descriptionOfTheProject) {
        this.descriptionOfTheProject = descriptionOfTheProject;
    }

    public User getLeadOfTheProject() {
        return leadOfTheProject;
    }

    public void setLeadOfTheProject(User leadOfTheProject) {
        this.leadOfTheProject = leadOfTheProject;
    }

    public Set<User> getUsersInTheCurrentProject() {
        return usersInTheCurrentProject;
    }

    public void setUsersInTheCurrentProject(Set<User> usersInTheCurrentProject) {
        this.usersInTheCurrentProject = usersInTheCurrentProject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Project))
            return false;

        Project other = (Project)o;

        if (id == other.getId()) return true;
        if (id == null) return false;

        // equivalence by id
        return id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        if (id != null) {
            return id.hashCode();
        } else {
            return super.hashCode();
        }
    }
}
