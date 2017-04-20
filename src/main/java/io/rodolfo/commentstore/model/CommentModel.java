package io.rodolfo.commentstore.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import io.rodolfo.commentstore.model.utils.UtcCalendarType;


@Entity
@Table(name = "comments_model",
    indexes = {
        @Index(name = "idx_pageId", columnList = "pageId")
    }
)
@TypeDefs({
    @TypeDef(name = "calendarUTC",
            typeClass = UtcCalendarType.class,
            defaultForType = Calendar.class)
})
public class CommentModel implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -7656080077383455564L;

    @Id
    @Column(length = 36)
    private String id;
    
    @Version
    private Integer version;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "calendarUTC")
    private Calendar lastModificationDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "calendarUTC")
    private Calendar creationDate;
    
    @Column(length = 32)
    private String pageId;
    
    @Column(length = 32)
    private String username;
    
    @Column(length = 32)
    private String emailAddress;
    
    @Column
    private boolean spam;
    
    @Column(columnDefinition = "TEXT")
    private String comment;
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Calendar getLastModificationDate() {
        return lastModificationDate;
    }

    public void setLastModificationDate(Calendar lastModificationDate) {
        this.lastModificationDate = lastModificationDate;
    }

    public Calendar getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Calendar creationDate) {
        this.creationDate = creationDate;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public boolean isSpam() {
        return spam;
    }

    public void setSpam(boolean spam) {
        this.spam = spam;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
