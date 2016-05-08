package com.sprsec.service.changeOfStateService;

import com.sprsec.model.ChangeOfState;
import org.springframework.stereotype.Service;

@Service
public interface ChangeOfStateService
{
    public ChangeOfState getChangeOfState(Integer id);
    public void createChangeOfState(ChangeOfState changeOfState);
    public void updateChangeOfState(ChangeOfState changeOfState);
    public void removeChangeOfState(Integer id);
}
