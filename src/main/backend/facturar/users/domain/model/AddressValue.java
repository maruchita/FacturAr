package facturar.users.domain.model;


import facturar.shared.domain.ValueObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "address")
public class AddressValue implements ValueObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "address_type_id")
    private Integer addressTypeId;

    @Column(name = "street", length = 200)
    private String street;

    @Column(name = "city", length = 200)
    private String city;

    @Column(name = "province_id")
    private Integer provinceId;

    @Column(name = "country_id")
    private Integer countryId;


    public AddressValue(Integer addressType, String street, String city, Integer provinceId, Integer countryId) {
        this.addressTypeId = addressType;
        this.street = street;
        this.city = city;
        this.provinceId = provinceId;
        this.countryId = countryId;
    }
}
