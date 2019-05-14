package de.manager.service;

import de.manager.dao.EstateDAO;
import de.manager.entity.Apartment;
import de.manager.entity.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstateServiceImpl implements EstateService {

    @Autowired
    EstateDAO estateDAO;

    @Override
    @Transactional
    public void insertHouse(House house) {
        estateDAO.insertHouse(house);
    }

    @Override
    @Transactional
    public void deleteHouse(int houseId) {
        estateDAO.deleteHouse(houseId);
    }

    @Override
    @Transactional
    public void updateHouse(House house) {
        estateDAO.updateHouse(house);
    }

    @Override
    @Transactional
    public void insertApartment(Apartment apartment) {
        estateDAO.insertApartment(apartment);
    }

    @Override
    @Transactional
    public void deleteApartment(int apartmentId) {
        estateDAO.deleteApartment(apartmentId);
    }

    @Override
    @Transactional
    public void updateApartment(Apartment apartment) {
        estateDAO.updateApartment(apartment);
    }

    @Override
    @Transactional
    public boolean estateAgentMaintainHouse(int estateAgentId, int houseId) {
        return estateDAO.estateAgentMaintainHouse(estateAgentId, houseId);
    }

    @Override
    @Transactional
    public boolean estateAgentMaintainApartment(int estateAgentId, int apartmentId) {
        return estateDAO.estateAgentMaintainApartment(estateAgentId, apartmentId);
    }

    @Override
    @Transactional
    public House getHouse(int houseId, int estateAgentId) {
        return estateDAO.getHouse(houseId, estateAgentId);
    }

    @Override
    @Transactional
    public Apartment getApartment(int apartmentId, int estateAgentId) {
        return estateDAO.getApartment(apartmentId, estateAgentId);
    }
}
