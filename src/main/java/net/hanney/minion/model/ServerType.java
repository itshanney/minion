package net.hanney.minion.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;

import java.math.BigDecimal;

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
public class ServerType {

    private Long typeId;
    private String typeName;
    private String description;
    private String cpuType;
    private Integer cpuCores;
    private BigDecimal tcoDollars, ramGb, hddGb;
    private DateTime createDate;

    public ServerType() {
        super();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(final Long typeId) {
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

    public void setTcoDollars(final BigDecimal tcoDollars) {
        this.tcoDollars = tcoDollars;
    }

    public DateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(final DateTime createDate) {
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
                .toString();
    }

}
