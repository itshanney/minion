package net.hanney.minion.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;

/**
 * Model that defines a Data Center which may hold Servers
 *
 * @author justin.hanney
 */
public class DataCenter {

    private String dataCenterId;
    private String dataCenterName;
    private DateTime createDate;

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

    public DateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(final DateTime createDate) {
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
