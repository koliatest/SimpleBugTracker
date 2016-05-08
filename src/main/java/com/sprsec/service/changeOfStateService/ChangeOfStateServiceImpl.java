package com.sprsec.service.changeOfStateService;

import com.sprsec.dao.changeOfStateDao.ChangeOfStateDao;
import com.sprsec.model.ChangeOfState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ChangeOfStateServiceImpl implements ChangeOfStateService
{
    @Autowired
    ChangeOfStateDao changeOfStateDao;

    @Override
    public ChangeOfState getChangeOfState(Integer id) {
        return changeOfStateDao.getChangeOfState(id);
    }

    @Override
    public void createChangeOfState(ChangeOfState changeOfState) {
        changeOfStateDao.createChangeOfState(changeOfState);
    }

    @Override
    public void updateChangeOfState(ChangeOfState changeOfState) {
        changeOfStateDao.updateChangeOfState(changeOfState);
    }

    @Override
    public void removeChangeOfState(Integer id) {
        changeOfStateDao.removeChangeOfState(id);
    }
}
