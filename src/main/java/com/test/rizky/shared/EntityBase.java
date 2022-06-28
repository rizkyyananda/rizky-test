package com.test.rizky.shared;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

@MappedSuperclass
public abstract class EntityBase <ID extends Serializable> implements Serializable {
    private static final long serialVersionUID = 8621562413768735013L;
    private Long version;

    @Column(name = "VERSION_")
    @Version

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
