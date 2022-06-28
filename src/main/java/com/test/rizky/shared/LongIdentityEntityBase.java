package com.test.rizky.shared;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class LongIdentityEntityBase extends EntityBase<Long> {
    /**
     *
     */
    private static final long serialVersionUID = 486950420413014209L;
    private Long id;
    public LongIdentityEntityBase() {
        super();
    }
    public LongIdentityEntityBase(Long id) {
        super();
        this.id = id;
    }
    @Id
    @GeneratedValue(generator = "hibincr")
    @GenericGenerator(name = "hibincr", strategy = "identity")
    @Column(name = "ID_")
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
