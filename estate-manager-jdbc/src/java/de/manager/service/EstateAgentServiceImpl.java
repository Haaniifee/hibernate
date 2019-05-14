package de.manager.service;

import de.manager.dao.EstateAgentDAO;
import de.manager.entity.EstateAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstateAgentServiceImpl implements  EstateAgentService  {

    @Autowired
    EstateAgentDAO estateAgentDAO;

    @Override
    @Transactional
    public int getEstateAgentId(String loginName) {
        return estateAgentDAO.getEstateAgentId(loginName);
    }

    @Override
    @Transactional
    public void addEstateAgent(EstateAgent estateAgent) {
        estateAgentDAO.addEstateAgent(estateAgent);
    }

    @Override
    @Transactional
    public void deleteEstateAgent(String loginName) {
        estateAgentDAO.deleteEstateAgent(loginName);
    }

    @Override
    @Transactional
    public void updateEstateAgent(EstateAgent estateAgent) {
        estateAgentDAO.updateEstateAgent(estateAgent);
    }

    @Override
    @Transactional
    public boolean existEstateAgent(String loginName, String loginPassword) {
        return estateAgentDAO.existEstateAgent(loginName, loginPassword);
    }
}
