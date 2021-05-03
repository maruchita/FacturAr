package facturar.users.domain.model;

import facturar.shared.domain.ValueObject;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "phones")
public class PhoneValue implements ValueObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "phone_type_id")
    private Integer phoneTypeId;

    @Column(name = "country_code", length = 3)
    private String countryCode;

    @Column(name = "city_code")
    private Integer cityCode;

    @Column(name = "number", length = 20)
    private String number;

    @Column(name = "extension", length = 10)
    private String extension;

    public PhoneValue(Integer phoneType, String countryCode, Integer cityCode, String phoneNumber, String extension) {
        this.phoneTypeId = phoneType;
        this.countryCode = countryCode;
        this.cityCode = cityCode;
        this.number = phoneNumber;
        this.extension = extension;
    }
}
