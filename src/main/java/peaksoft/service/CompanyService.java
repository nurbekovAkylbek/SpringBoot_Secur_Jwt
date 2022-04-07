package peaksoft.service;

import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.entity.Company;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompany();

    CompanyResponse saveCompany(CompanyRequest companyRequest);

    CompanyResponse updateCompany(Long id, CompanyRequest companyRequest);

    CompanyResponse getCompanyById(Long id);

    void deleteCompanyById(Long id);
}
