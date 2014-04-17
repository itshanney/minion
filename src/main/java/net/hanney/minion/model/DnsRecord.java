package net.hanney.minion.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Model that defines a particular DNS record in a typical DNS system
 *
 * @author justin.hanney
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "dns_records")
public class DnsRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "record_id")
    private Long recordId;

    @Column(name = "domain_id")
    private Integer domainId;

    @JoinColumn(name = "domain_id", updatable = false, insertable = false)
    @OneToOne(targetEntity = Domain.class, fetch = FetchType.EAGER)
    private Domain domain;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private String value;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "is_active")
    private Boolean isActive;

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(final Domain domain) {
        this.domain = domain;
    }

    public Integer getDomainId() {
        return domainId;
    }

    public void setDomainId(final Integer domainId) {
        this.domainId = domainId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(final Long recordId) {
        this.recordId = recordId;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("recordId", getRecordId())
                .append("domainId", getDomainId())
                .append("name", getName())
                .append("value", getValue())
                .append("createDate", getCreateDate())
                .append("isActive", getIsActive())
                .toString();
    }

}
