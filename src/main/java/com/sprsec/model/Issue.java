package com.sprsec.model;

import com.sprsec.model.enums.PriorityOfTheIssue;
import com.sprsec.model.enums.StatusOfTheIssue;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "issue")
public class Issue {

    @Id
    @GeneratedValue
    @Column
    private Integer id;

    @Column
    private String titleOfIssue;

    @Column
    private String description;

    @Column
    @Enumerated(EnumType.STRING)
    private PriorityOfTheIssue priority;

    @Column
    private Date dateOfTheCreation = setDefaultDateOfCreation();

    @Column
    @Enumerated(EnumType.STRING)
    private StatusOfTheIssue status = setDefaultStatusOfTheIssue();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "project_fk")
    private Project projectOfTheIssue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_fixer_fk")
    private User fixerOfTheIssue;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_tester_fk")
    private User testerOfTheIssue;

    private static StatusOfTheIssue setDefaultStatusOfTheIssue()
    {
        return StatusOfTheIssue.OPENED;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getTesterOfTheIssue() {
        return testerOfTheIssue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTesterOfTheIssue(User testerOfTheIssue) {
        this.testerOfTheIssue = testerOfTheIssue;
    }

    public User getFixerOfTheIssue() {
        return fixerOfTheIssue;
    }

    public String getTitleOfIssue() {
        return titleOfIssue;
    }

    public void setTitleOfIssue(String titleOfIssue) {
        this.titleOfIssue = titleOfIssue;
    }

    public void setFixerOfTheIssue(User fixerOfTheIssue) {
        this.fixerOfTheIssue = fixerOfTheIssue;
    }

    public Project getProjectOfTheIssue() {
        return projectOfTheIssue;
    }

    public void setProjectOfTheIssue(Project projectOfTheIssue) {
        this.projectOfTheIssue = projectOfTheIssue;
    }

    public StatusOfTheIssue getStatus() {
        return status;
    }

    public void setStatus(StatusOfTheIssue status) {
        this.status = status;
    }

    public Date getDateOfTheCreation() {
        return dateOfTheCreation;
    }

    public void setDateOfTheCreation(Date dateOfTheCreation) {
        this.dateOfTheCreation = dateOfTheCreation;
    }

    public PriorityOfTheIssue getPriority() {
        return priority;
    }

    public void setPriority(PriorityOfTheIssue priority) {
        this.priority = priority;
    }

    public Issue() {    }

    private synchronized static Date setDefaultDateOfCreation(){
        return new Date();
    }


}
