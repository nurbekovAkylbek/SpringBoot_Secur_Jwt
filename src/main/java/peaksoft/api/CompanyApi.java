package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.entity.Company;
import peaksoft.service.CompanyService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
public class CompanyApi {

    private final CompanyService companyService;

    @PostMapping("/addCompany")
    public CompanyResponse saveCompany(@RequestBody @Valid CompanyRequest companyRequest) {
        return companyService.saveCompany(companyRequest);
    }

    @GetMapping("/getAllCompany")
    public List<Company> getALlCompany() {
        return companyService.getAllCompany();
    }

    @PutMapping("/update/{id}")
    public CompanyResponse updateCompany(@PathVariable Long id, @RequestBody CompanyRequest companyRequest) {
        return companyService.updateCompany(id, companyRequest);
    }

    @GetMapping("/getById/{id}")
    public CompanyResponse getCompanyById(@PathVariable Long id) {
        return companyService.getCompanyById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCompanyById(@PathVariable Long id) {
        companyService.deleteCompanyById(id);
    }
}

