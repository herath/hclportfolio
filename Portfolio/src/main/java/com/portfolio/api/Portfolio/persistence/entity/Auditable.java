package com.portfolio.api.Portfolio.persistence.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class Auditable<U> {
    @NotNull(message = "Please enter requester")
    @Size(max = 20)
    @CreatedBy
    @Column(name = "added_by")
    protected String addedBy;

    @NotNull(message = "Please enter date")
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "added_date")
    protected Date addedDate;

    @LastModifiedBy
    @Column(name = "modified_by")
    protected U modifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_date")
    protected Date modifiedDate;

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public U getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(U modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
