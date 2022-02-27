package peaksoft.dao;

import org.springframework.stereotype.Repository;
import peaksoft.model.Company;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CompanyDaoImpl implements CompanyDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Company saveCompany(Company company) {
        entityManager.persist(company);
        return company;
    }

    @Override
    public void removeCompanyById(long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public Company getById(long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public List<Company> getAllCompany() {
        return entityManager.createQuery("select c from Company c", Company.class).getResultList();
    }

    @Override
    public void cleanCompanyTable() {
        entityManager.clear();
    }

     @Override
    public void update(long id, Company company) {
        Company company1=getById(id);
        company1.setCompanyName(company.getCompanyName());
        company1.setLocatedCountry(company.getLocatedCountry());
        entityManager.merge(company1);
    }
}
