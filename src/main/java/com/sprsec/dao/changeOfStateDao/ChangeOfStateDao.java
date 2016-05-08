package com.sprsec.dao.changeOfStateDao;


import com.sprsec.model.ChangeOfState;

public interface ChangeOfStateDao
{
    public ChangeOfState getChangeOfState(Integer id);
    public void createChangeOfState(ChangeOfState changeOfState);
    public void updateChangeOfState(ChangeOfState changeOfState);
    public void removeChangeOfState(Integer id);
}
