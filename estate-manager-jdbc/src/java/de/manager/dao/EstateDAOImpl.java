package de.manager.dao;

import de.manager.entity.Apartment;
import de.manager.entity.House;
import de.manager.util.JDBCConnector;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EstateDAOImpl implements EstateDAO {

    @Autowired
    @Qualifier("JDBC_DB2ConnectorImpl")
    private JDBCConnector jdbcConnector;

    @Autowired
    private SessionFactory factory;

    @Override
    public void insertHouse(House house) {
        Connection connection = jdbcConnector.getConnection();

        Session currentSession = factory.getCurrentSession();
        currentSession.save(house);

    }

    @Override
    public void deleteHouse(int houseId) {

        Connection connection = jdbcConnector.getConnection();
        Session currentSession = factory.getCurrentSession();
        Query query = currentSession.createQuery("delete from EstateAgent where houseId =: id_house");
        query.setParameter("id_house", houseId);
        query.executeUpdate();

        Hibernate.initialize("DELETE successful");
    }

    @Override
    public void updateHouse(House house) {

        Map<String, String> attributes = new HashMap<>();

        attributes.put("city", house.getCity());
        attributes.put("postal_code", house.getPostalCode());
        attributes.put("street", house.getStreet());
        attributes.put("street_number", house.getNumber());
        attributes.put("square_area", house.getSquareArea());
        attributes.put("floors", String.valueOf(house.getFloors()));
        attributes.put("price", String.valueOf(house.getPrice()));
        attributes.put("garden", String.valueOf(house.getGarden()));

        for (Map.Entry<String, String> attribute : attributes.entrySet()) {
            String key = attribute.getKey();
            String value = attribute.getValue();

            Connection connection = jdbcConnector.getConnection();
            Session currentSession = factory.getCurrentSession();
            House oldHouse = currentSession.get(House.class, house.getId());

            oldHouse.setCity(house.getCity());
            oldHouse.setPostalCode(house.getPostalCode());
            oldHouse.setStreet(house.getStreet());
            oldHouse.setNumber(house.getNumber());
            oldHouse.setSquareArea(house.getSquareArea());
            oldHouse.setFloors(house.getFloors());
            oldHouse.setPrice(house.getPrice());
            oldHouse.setGarden(house.getGarden());
        }
    }


    @Override
    public void insertApartment(Apartment apartment) {
        Connection connection = jdbcConnector.getConnection();

        Session currentSession = factory.getCurrentSession();
        currentSession.save(apartment);
    }

    @Override
    public void deleteApartment(int apartmentId) {

        Session currentSession = factory.getCurrentSession();
        Query query = currentSession.createQuery("delete from apartment where apartmentId =: id_apartment");
        query.setParameter("id_apartment", apartmentId);
        query.executeUpdate();
    }

    @Override
    public void updateApartment(Apartment apartment) {
        Map<String, String> attributes = new HashMap<>();

        attributes.put("city", apartment.getCity());
        attributes.put("postal_code", apartment.getPostalCode());
        attributes.put("street", apartment.getStreet());
        attributes.put("street_number", apartment.getNumber());
        attributes.put("square_area", apartment.getSquareArea());
        attributes.put("floor", String.valueOf(apartment.getFloor()));
        attributes.put("rent", String.valueOf(apartment.getRent()));
        attributes.put("rooms", String.valueOf(apartment.getRoom()));
        attributes.put("balcony", String.valueOf(apartment.getBalcony()));
        attributes.put("built_in_kitchen", String.valueOf(apartment.getKitchen()));

        for (Map.Entry<String, String> attribute : attributes.entrySet()) {
            String key = attribute.getKey();
            String value = attribute.getValue();

            Connection connection = jdbcConnector.getConnection();
            Session currentSession = factory.getCurrentSession();
            Apartment oldApartment = currentSession.get(Apartment.class, apartment.getId());

            oldApartment.setCity(apartment.getCity());
            oldApartment.setPostalCode(apartment.getPostalCode());
            oldApartment.setStreet(apartment.getStreet());
            oldApartment.setNumber(apartment.getNumber());
            oldApartment.setSquareArea(apartment.getSquareArea());
            oldApartment.setFloor(apartment.getFloor());
            oldApartment.setRent(apartment.getRent());
            oldApartment.setRoom(apartment.getRoom());
            oldApartment.setBalcony(apartment.getBalcony());
            oldApartment.setKitchen(apartment.getKitchen());
        }
    }

    @Override
    public boolean estateAgentMaintainHouse(int estateAgentId, int houseId) {

        Session currentSession = factory.getCurrentSession();

        Query query = currentSession.createQuery("from house where houseId =: id_house and estateAgentId =: fk_id_estate_agent");
        boolean result = (boolean) query.uniqueResult();
        return result;
    }

    @Override
    public boolean estateAgentMaintainApartment(int estateAgentId, int apartmentId) {

        Session currentSession = factory.getCurrentSession();

        Query query = currentSession.createQuery("from apartment where apartmentId =: id_apartment and estateAgentId =: fk_id_estate_agent");
        boolean result = (boolean) query.uniqueResult();
        return result;
    }

    @Override
    public House getHouse(int houseId, int estateAgentId) {

        Session currentSession = factory.getCurrentSession();

        Query query = currentSession.createQuery("from house where houseId =: id_house and estateAgentId =: fk_id_estate_agent");
        House result = (House) query.uniqueResult();
        return result;
    }

    @Override
    public Apartment getApartment(int apartmentId, int estateAgentId) {
        Session currentSession = factory.getCurrentSession();

        Query query = currentSession.createQuery("from apartment where apartmentId =: id_apartment and estateAgentId =: fk_id_estate_agent");
        Apartment result = (Apartment) query.uniqueResult();
        Apartment result1 = result;
        return result1;
    }
}