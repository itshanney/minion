package net.hanney.minion.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Model that defines a particular Class (i.e. generation) of Servers.
 * </p>
 * Most servers will more than likely be part of a "generation" that relates to the
 * type of hardware, software, etc. that encompasses that server. For example, one
 * Class of servers might be based on a specific underlying physical CPU type, RAM,
 * hypervisor, etc.
 *
 * @author justin.hanney
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "server_types")
public class ServerType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "type_id", length = 16)
    private String typeId;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "description")
    private String description;

    @Column(name = "cpu_type")
    private String cpuType;

    @Column(name = "cpu_cores")
    private Integer cpuCores;

    @Column(name = "tco_dollars")
    private BigDecimal tcoDollars;

    @Column(name = "ram_gb")
    private BigDecimal ramGb;

    @Column(name = "hdd_gb")
    private BigDecimal hddGb;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "is_active")
    private Boolean isActive;

    public ServerType() {
        super();
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(final String typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(final String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getCpuType() {
        return cpuType;
    }

    public void setCpuType(final String cpuType) {
        this.cpuType = cpuType;
    }

    public Integer getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(final Integer cpuCores) {
        this.cpuCores = cpuCores;
    }

    public BigDecimal getRamGb() {
        return ramGb;
    }

    public void setRamGb(final BigDecimal ramGb) {
        this.ramGb = ramGb;
    }

    public BigDecimal getHddGb() {
        return hddGb;
    }

    public void setHddGb(final BigDecimal hddGb) {
        this.hddGb = hddGb;
    }

    public BigDecimal getTcoDollars() {
        return tcoDollars;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(final Boolean isActive) {
        this.isActive = isActive;
    }

    public void setTcoDollars(final BigDecimal tcoDollars) {
        this.tcoDollars = tcoDollars;
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
                .append("typeId", getTypeId())
                .append("typeName", getTypeName())
                .append("description", getDescription())
                .append("cpuType", getCpuType())
                .append("cpuCores", getCpuCores())
                .append("ramGb", getRamGb())
                .append("hddGb", getHddGb())
                .append("tcoDollars", getTcoDollars())
                .append("isActive", getIsActive())
                .append("createDate", getCreateDate())
                .toString();
    }

}
