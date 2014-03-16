package net.hanney.minion.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Model that defines a Data Center which may hold Servers
 *
 * @author justin.hanney
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name="data_centers")
public class DataCenter implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "data_center_id")
    private String dataCenterId;

    @Column(name = "data_center_name")
    private String dataCenterName;

    @Column(name = "create_date")
    private Date createDate;

    public DataCenter() {
        super();
    }

    public String getDataCenterId() {
        return dataCenterId;
    }

    public void setDataCenterId(final String dataCenterId) {
        this.dataCenterId = dataCenterId;
    }

    public String getDataCenterName() {
        return dataCenterName;
    }

    public void setDataCenterName(final String dataCenterName) {
        this.dataCenterName = dataCenterName;
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
                .append("dataCenterId", getDataCenterId())
                .append("dataCenterName", getDataCenterName())
                .append("createDate", getCreateDate())
                .toString();
    }

}
