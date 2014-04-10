package net.hanney.minion.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Model that defines a particular network Domain (e.g. google.com)
 *
 * @author justin.hanney
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "domains")
public class Domain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "domain_id")
    private Integer domainId;

    @Column(name = "domain_name")
    private String domainName;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "is_active")
    private Boolean isActive;


    public Integer getDomainId() {
        return domainId;
    }

    public void setDomainId(final Integer domainId) {
        this.domainId = domainId;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(final String domainName) {
        this.domainName = domainName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(final Boolean isActive) {
        this.isActive = isActive;
    }

    public String toString() {
        return new ToStringBuilder(this)
                .append("domainId", getDomainId())
                .append("domainName", getDomainName())
                .append("isActive", getIsActive())
                .append("createDate", getCreateDate())
                .toString();
    }
}
