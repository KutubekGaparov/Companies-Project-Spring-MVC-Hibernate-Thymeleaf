package peaksoft.service.interfase;

import peaksoft.model.Company;

import java.util.List;

public interface CompanyService {

    Company saveCompany(Company company);

    void removeCompanyById(long id);

    public Company getById(long id);

    public List<Company> getAllCompany();

    void update(long id,Company company);
}
