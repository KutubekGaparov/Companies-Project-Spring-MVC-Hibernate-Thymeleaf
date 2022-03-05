package peaksoft.service.interfase;

import peaksoft.model.Company;

import java.util.List;

public interface CompanyService {

    Company saveCompany(Company company);

    void removeCompanyById(Long id);

    public Company getById(Long id);

    public List<Company> getAllCompany();

    void update(Long id,Company company);
}
