package com.lzy.utils;

import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IncrementGenerator;

import javax.persistence.GeneratedValue;
import java.io.Serializable;
import java.util.UUID;

public class UserIdentityGenerator extends IncrementGenerator  {
    @Override
    public synchronized Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        return "O_"+ UUID.randomUUID().toString();
    }
}
