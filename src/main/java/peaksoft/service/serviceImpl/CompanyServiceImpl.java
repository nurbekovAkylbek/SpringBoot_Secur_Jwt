package peaksoft.service.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import peaksoft.dto.request.CompanyRequest;
import peaksoft.dto.response.CompanyResponse;
import peaksoft.entity.Company;
import peaksoft.mapper.edit.CompanyEditMapper;
import peaksoft.mapper.views.CompanyViewMapper;
import peaksoft.rpeository.CompanyRepository;
import peaksoft.service.CompanyService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;
    private final CompanyEditMapper editMapper;
    private final CompanyViewMapper viewMapper;

    @Override
    @Transactional
    public List<Company> getAllCompany() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public CompanyResponse saveCompany(CompanyRequest companyRequest) {
        return viewMapper.viewCompany(repository.save(editMapper.create(companyRequest)));
    }

    @Override
    @Transactional
    public CompanyResponse updateCompany(Long id, CompanyRequest companyRequest) {
        Company company = repository.findById(id).get();
        editMapper.update(company, companyRequest);
        Company company1 = repository.findById(id).get();
        return viewMapper.viewCompany(company1);
    }

    @Override
    @Transactional
    public CompanyResponse getCompanyById(Long id) {
        return viewMapper.viewCompany(repository.findById(id).get());
    }

    @Override
    public void deleteCompanyById(Long id) {
        repository.deleteById(id);
    }
}
