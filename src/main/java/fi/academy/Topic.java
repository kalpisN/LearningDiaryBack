package fi.academy;


import javax.persistence.*;

import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity
public class Topic {

    @Id
    @GeneratedValue(strategy = SEQUENCE,
            generator = "topic_id_seq")
    @SequenceGenerator(name = "topic_id_seq",
            sequenceName = "topic_id_seq",
            allocationSize = 1)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String title;
    private String description;
    private Boolean complete;


    @Temporal(TemporalType.TIMESTAMP)
    private Date creationdate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date completiondate;

    public boolean isComplete() {
        return complete;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Date getCompletiondate() {
        return completiondate;
    }

    public void setCompletiondate(Date completiondate) {
        this.completiondate = completiondate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }


}
