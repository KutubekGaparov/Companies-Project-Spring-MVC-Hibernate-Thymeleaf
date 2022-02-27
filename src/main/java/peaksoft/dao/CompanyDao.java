package peaksoft.dao;

import peaksoft.model.Company;

import java.util.List;

public interface CompanyDao {

    Company  saveCompany(Company company);

    void removeCompanyById(long id);

    Company getById(long id);

    List<Company> getAllCompany();

    void cleanCompanyTable();

    void update(long id,Company company);


}
