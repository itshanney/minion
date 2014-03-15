package net.hanney.minion.model;

import org.joda.time.DateTime;

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
public class ServerClass {

    private Long classId;
    private String className;
    private String description;
    private DateTime createDate;

    public ServerClass() {
        super();
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public DateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(DateTime createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
