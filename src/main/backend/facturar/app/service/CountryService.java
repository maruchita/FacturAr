package facturar.app.service;

import facturar.app.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CountryService {

    public Iterable<Country> findAll();

    public Page<Country> findAll(Pageable pageable);
}
