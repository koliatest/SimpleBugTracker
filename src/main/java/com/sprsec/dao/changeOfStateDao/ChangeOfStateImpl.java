package com.sprsec.dao.changeOfStateDao;

import com.sprsec.model.ChangeOfState;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ChangeOfStateImpl implements ChangeOfStateDao
{
    @Autowired
    private SessionFactory sessionFactory;

    private Session openSession()
    {
        return sessionFactory.getCurrentSession();
    }

    @Override
    @Transactional
    public ChangeOfState getChangeOfState(Integer id)
    {
        return (ChangeOfState) openSession().get(ChangeOfState.class, id);
    }

    @Override
    @Transactional
    public void createChangeOfState(ChangeOfState changeOfState)
    {
        openSession().save(changeOfState);
    }

    @Override
    @Transactional
    public void updateChangeOfState(ChangeOfState changeOfState)
    {
        openSession().update(changeOfState);
    }

    @Override
    @Transactional
    public void removeChangeOfState(Integer id)
    {
        openSession().delete(getChangeOfState(id));
    }
}
