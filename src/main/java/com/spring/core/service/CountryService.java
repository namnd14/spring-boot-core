package com.spring.core.service;

import com.spring.core.dto.request.SearchCountryRequestDTO;
import com.spring.core.entity.Country;
import com.spring.core.repository.CountryRepository;
import com.spring.core.utils.SortColumnMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Page<Country> searchCountry(SearchCountryRequestDTO requestDTO) {
        int pageNumber = requestDTO.getPageNumber();
        int pageSize = requestDTO.getPageSize();
        String orderBy = requestDTO.getOrderBy();
        String direction = requestDTO.getDirection();
        String orderBySql = SortColumnMapper.toSqlOrderBySearchCountry(orderBy);
        Sort.Direction directionKey = direction.equals("ASC") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(directionKey, orderBySql);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        return countryRepository.search(pageable, requestDTO.getCountryName());
    }
}
