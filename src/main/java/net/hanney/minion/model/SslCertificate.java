package net.hanney.minion.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Model that defines a particular security-related SSL Certificate
 *
 * @author justin.hanney
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "ssl_certificates")
public class SslCertificate implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "certificate_id")
    private Integer certificateId;

    @Column(name = "certificate_name")
    private String certificateName;

    @Column(name = "domain_id")
    private Integer domainId;

    @JoinColumn(name = "domain_id", updatable = false, insertable = false)
    @OneToOne(targetEntity = Domain.class, fetch = FetchType.EAGER)
    private Domain domain;

    @Column(name = "expiration_date")
    private Date expirationDate;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "is_active")
    private Boolean isActive;

    public Integer getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(final Integer certificateId) {
        this.certificateId = certificateId;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(final String certificateName) {
        this.certificateName = certificateName;
    }

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

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(final Date expirationDate) {
        this.expirationDate = expirationDate;
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
                .append("certificateId", getCertificateId())
                .append("certificateName", getCertificateName())
                .append("domainId", getDomainId())
                .append("expirationDate", getExpirationDate())
                .append("isActive", getIsActive())
                .append("createDate", getCreateDate())
                .toString();
    }

}
