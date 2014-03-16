package net.hanney.minion.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;

/**
 * Model that defines an Operating System which may run on a particular Server
 *
 * @author justin.hanney
 */
public class OperatingSystem {

    private String operatingSystemId;
    private String operatingSystemName;
    private DateTime createDate;

    public String getOperatingSystemId() {
        return operatingSystemId;
    }

    public void setOperatingSystemId(final String operatingSystemId) {
        this.operatingSystemId = operatingSystemId;
    }

    public String getOperatingSystemName() {
        return operatingSystemName;
    }

    public void setOperatingSystemName(final String operatingSystemName) {
        this.operatingSystemName = operatingSystemName;
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
                .append("operatingSystemId", getOperatingSystemId())
                .append("operatingSystemName", getOperatingSystemName())
                .append("createDate", getCreateDate())
                .toString();
    }
}
