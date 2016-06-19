package com.sprsec.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "change_of_state")
public class ChangeOfState
{
    @Column
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Date dateOfChange = setDefaultDateOfChange();

    @Column
    private String basicText;

    @Column
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "issue_fk")
    private Issue issueOfState;

    public ChangeOfState() {}

    private synchronized static Date setDefaultDateOfChange(){
        return new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Issue getIssueOfState() {
        return issueOfState;
    }

    public void setIssueOfState(Issue issueOfState) {
        this.issueOfState = issueOfState;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBasicText() {
        return basicText;
    }

    public void setBasicText(String basicText) {
        this.basicText = basicText;
    }

    public Date getDateOfChange() {
        return dateOfChange;
    }

    public void setDateOfChange(Date dateOfChange) {
        this.dateOfChange = dateOfChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof ChangeOfState))
            return false;

        ChangeOfState other = (ChangeOfState)o;

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
