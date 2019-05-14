package de.manager.dao;

import de.manager.entity.EstateAgent;
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
public class EstateAgentDAOImpl implements EstateAgentDAO {

    @Autowired
    @Qualifier("JDBC_DB2ConnectorImpl")
    private JDBCConnector jdbcConnector;

    @Autowired
    private SessionFactory factory;

    @Override
    public int getEstateAgentId(String loginName) {
        Session currentSession = factory.getCurrentSession();

        Query query = currentSession.createQuery("from EstateAgent where loginName =: login");
        int result = (int) query.uniqueResult();
        return result;


    }

    @Override
    public void addEstateAgent(EstateAgent estateAgent) {
        Connection connection = jdbcConnector.getConnection();

        Session currentSession = factory.getCurrentSession();

        currentSession.save(estateAgent);

        System.out.println("INSERT successful: " + estateAgent);

    }

    @Override
    public void deleteEstateAgent(String loginName) {

        Connection connection = jdbcConnector.getConnection();
        Session currentSession = factory.getCurrentSession();
        Query query = currentSession.createQuery("delete from EstateAgent where loginName =: login");
        query.setParameter("login", loginName);
        query.executeUpdate();

        System.out.println("DELETE successful");

    }

    @Override
    public void updateEstateAgent(EstateAgent estateAgent) {

        Map<String, String> attributes = new HashMap<>();

        attributes.put("first_name", estateAgent.getFirstName());
        attributes.put("last_name", estateAgent.getLastName());
        attributes.put("address", estateAgent.getAddress());
        attributes.put("password", estateAgent.getLoginPass());

        for (Map.Entry<String, String> attribute : attributes.entrySet()) {
            String key = attribute.getKey();
            String value = attribute.getValue();


            Connection connection = jdbcConnector.getConnection();
            Session currentSession = factory.getCurrentSession();
            EstateAgent oldEstate = currentSession.get(EstateAgent.class, estateAgent.getId());

            oldEstate.setFirstName(estateAgent.getFirstName());
            oldEstate.setLastName(estateAgent.getLastName());
            oldEstate.setAddress(estateAgent.getAddress());
            oldEstate.setLoginPass(estateAgent.getLoginPass());


            Hibernate.initialize("EDIT successful");

        }
    }

    @Override
    public boolean existEstateAgent(String loginName, String loginPassword) {
        Session currentSession = factory.getCurrentSession();

        Query query = currentSession.createQuery("from EstateAgent where loginName =: login and loginPassword =: password");
        boolean result = (boolean) query.uniqueResult();
        return result;
    }
}