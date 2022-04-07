package peaksoft.mapper.views;

import org.springframework.stereotype.Component;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.entity.Company;

@Component
public class CompanyViewMapper {

    public CompanyResponse viewCompany(Company company) {
        if (company == null) {
            return null;
        }

        CompanyResponse response = new CompanyResponse();
        if (company.getId() != null) {
            response.setId(company.getId());
        }

        response.setCompanyName(company.getCompanyName());
        response.setLocatedCountry(company.getLocatedCountry());
        return response;
    }
}
