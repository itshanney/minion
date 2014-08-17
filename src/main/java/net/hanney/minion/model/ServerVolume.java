package net.hanney.minion.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Model that defines a Volume, which is a disk drive mounted to a {@link Server}
 *
 * @author justin.hanney
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="server_volumes")
public class ServerVolume implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "volume_id")
    private Long volumeId;

    @Column(name = "server_id")
    private Long serverId;

    @Column(name = "size_gb")
    private BigDecimal sizeGb;

    @Column(name = "mount_point")
    private String mountPoint;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "create_date")
    private Date createDate;

    public String getMountPoint() {
        return mountPoint;
    }

    public void setMountPoint(final String mountPoint) {
        this.mountPoint = mountPoint;
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(final Long serverId) {
        this.serverId = serverId;
    }

    public BigDecimal getSizeGb() {
        return sizeGb;
    }

    public void setSizeGb(final BigDecimal sizeGb) {
        this.sizeGb = sizeGb;
    }

    public Long getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(final Long volumeId) {
        this.volumeId = volumeId;
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
                .append("mountPoint", getMountPoint())
                .append("serverId", getServerId())
                .append("sizeGb", getSizeGb())
                .append("volumeId", getVolumeId())
                .append("isActive", getIsActive())
                .append("createDate", getCreateDate())
                .toString();
    }

}
