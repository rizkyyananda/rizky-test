package com.test.rizky.shared;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class StringUUIDIdentity extends EntityBase<String> {
    private static final long serialVersionUID = -5053684821378511710L;
    private String id;

    @Id
    @GeneratedValue(generator = "hbm_uuid")
    @GenericGenerator(name = "hbm_uuid", strategy = "uuid")
    @Column(name = "ID_")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;

    }
}
