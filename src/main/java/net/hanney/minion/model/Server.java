package net.hanney.minion.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Model that defines a Server, which lives in a Data Center somewhere
 *
 * @author justin.hanney
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="servers")
public class Server implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "server_id")
    private Long serverId;

    @Column(name = "hostname")
    private String hostname;

    @Column(name = "server_type_id")
    private Integer serverTypeId;

    @Column(name = "operating_system_id")
    private Integer operatingSystemId;

    @Column(name = "data_center_id")
    private String dataCenterId;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "create_date")
    private Date createDate;

    public String getDataCenterId() {
        return dataCenterId;
    }

    public void setDataCenterId(final String dataCenterId) {
        this.dataCenterId = dataCenterId;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(final String hostname) {
        this.hostname = hostname;
    }

    public Integer getOperatingSystemId() {
        return operatingSystemId;
    }

    public void setOperatingSystemId(final Integer operatingSystemId) {
        this.operatingSystemId = operatingSystemId;
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(final Long serverId) {
        this.serverId = serverId;
    }

    public Integer getServerTypeId() {
        return serverTypeId;
    }

    public void setServerTypeId(final Integer serverTypeId) {
        this.serverTypeId = serverTypeId;
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
                .append("serverId", getServerId())
                .append("hostname", getHostname())
                .append("serverTypeId", getServerTypeId())
                .append("dataCenterId", getDataCenterId())
                .append("operatingSystemId", getOperatingSystemId())
                .append("isActive", getIsActive())
                .append("createDate", getCreateDate())
                .toString();
    }
}
