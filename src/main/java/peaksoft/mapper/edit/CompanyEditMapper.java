package peaksoft.mapper.edit;

import org.springframework.stereotype.Component;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.entity.Company;

@Component
public class CompanyEditMapper {

    public Company create(CompanyRequest companyRequest) {
        if (companyRequest == null) {
            return null;
        }

        Company company = new Company();
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        return company;
    }

    public void update(Company company, CompanyRequest companyRequest) {
        company.setCompanyName(companyRequest.getCompanyName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());

    }
}
