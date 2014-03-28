package net.hanney.minion.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Model that defines an Operating System which may run on a particular Server
 *
 * @author justin.hanney
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "operating_systems")
public class OperatingSystem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "operating_system_id")
    private Integer operatingSystemId;

    @Column(name = "operating_system_name")
    private String operatingSystemName;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "create_date")
    private Date createDate;

    public OperatingSystem() {
        super();
    }

    public Integer getOperatingSystemId() {
        return operatingSystemId;
    }

    public void setOperatingSystemId(final Integer operatingSystemId) {
        this.operatingSystemId = operatingSystemId;
    }

    public String getOperatingSystemName() {
        return operatingSystemName;
    }

    public void setOperatingSystemName(final String operatingSystemName) {
        this.operatingSystemName = operatingSystemName;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(final Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("operatingSystemId", getOperatingSystemId())
                .append("operatingSystemName", getOperatingSystemName())
                .append("isActive", getIsActive())
                .append("createDate", getCreateDate())
                .toString();
    }

}
