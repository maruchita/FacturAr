package facturar.app.service;

import facturar.app.entity.Country;
import facturar.app.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProvinceService {

    public Iterable<Province> findAll();

    public Page<Province> findAll(Pageable pageable);
}
