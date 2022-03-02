package peaksoft.dao;

import peaksoft.model.Company;
import peaksoft.model.Course;

import java.util.List;

public interface CompanyDao {

    Company saveCompany(Company company);

    void removeCompanyById(long id);

    Company getById(long id);

    List<Company> getAllCompany();

    void update(long id, Company company);


}
