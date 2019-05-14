package de.manager.dao;

import de.manager.entity.Person;
import de.manager.entity.PurchaseContract;
import de.manager.entity.TenancyContract;
import de.manager.util.JDBCConnector;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

@Repository
public class ContractDAOImpl implements ContractDAO {

    @Autowired
    @Qualifier("JDBC_DB2ConnectorImpl")
    private JDBCConnector jdbcConnector;

    @Autowired
    private SessionFactory factory;

    @Override
    public void insertPerson(Person person) {
            Connection connection = jdbcConnector.getConnection();

            Session currentSession = factory.getCurrentSession();

            currentSession.save(person);

        Hibernate.initialize("INSERT successful: " + person);
    }


    @Override
    public boolean personExist(Person person) {

        Session currentSession = factory.getCurrentSession();
        Query query = currentSession.createQuery("from person where person =: login and loginPassword =: password");
        currentSession.save(person);
        boolean result = (boolean) query.uniqueResult();
        return result;

    }

    @Override
    public void createPurchaseContract(PurchaseContract purchaseContract) {
            Connection connection = jdbcConnector.getConnection();

        Session currentSession = factory.getCurrentSession();

        currentSession.save(purchaseContract);


        Hibernate.initialize("INSERT successful: " + purchaseContract);


    }

    @Override
    public void createTenancyContract(TenancyContract tenancyContract) {
            Connection connection = jdbcConnector.getConnection();

        Session currentSession = factory.getCurrentSession();

        currentSession.save(tenancyContract);

        Hibernate.initialize("INSERT successful: " + tenancyContract);


    }

    @Override
    public boolean purchaseContractExist(int personId, int houseId, String contractNumber) {

        Session currentSession = factory.getCurrentSession();

        Query query = currentSession.createQuery("from purchase_contract where contractNumber =: contract_no or " +
                "personId =: fk_id_person and houseId =: fk_id_house");
        boolean result = (boolean) query.uniqueResult();
        return result;

    }

    @Override
    public boolean tenancyContractExist(int personId, int apartmentId, String contractNumber) {

        Session currentSession = factory.getCurrentSession();

        Query query = currentSession.createQuery("from tenancy_contract where contractNumber =: contract_no or " +
                "personId =: fk_id_person and apartmentId =: fk_id_apartment");
        boolean result = (boolean) query.uniqueResult();
        return result;
    }

    @Override
    public List<PurchaseContract> getAllPurchaseContracts() {
            List<PurchaseContract> purchaseContracts = new LinkedList();

        Connection connection = jdbcConnector.getConnection();
            Session currentSession = factory.getCurrentSession();
            Query<PurchaseContract> query = currentSession.createQuery("from PurchaseContract order by lastName", PurchaseContract.class);
            List<PurchaseContract> purchase = query.getResultList();

            return purchase;
    }

    @Override
    public List<TenancyContract> getAllTenancyContracts() {
            List<TenancyContract> tenancyContracts = new LinkedList();
            Connection connection = jdbcConnector.getConnection();

        Session currentSession = factory.getCurrentSession();
        Query<TenancyContract> query = currentSession.createQuery("from TenancyContract order by lastName", TenancyContract.class);
        List<TenancyContract> tenancy = query.getResultList();

        return tenancy;
    }
}
