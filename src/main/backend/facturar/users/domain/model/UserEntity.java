package facturar.users.domain.model;

import facturar.shared.domain.Entity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@javax.persistence.Entity
@Table(name = "users")
public class UserEntity implements Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private  Integer id;

    @Column(name = "user_name", unique = true, nullable = false)
    private  String userName;

    @Column(name = "name", length = 100)
    private  String name;

    @Column(name = "last_name", length = 100)
    private  String lastName;

    @Column(name = "password", length = 128)
    private  String password;

    @Column(name = "salt", length = 50)
    private  String salt;

    @Column(name = "email", length = 200)
    private  String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "created_date")
    private Date createdDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "modified_date")
    private Date modifiedDate;

    @Column(name = "status_id")
    private Integer statusId;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressValue addressValue;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "phone_id")
    private PhoneValue phoneValue;

    public UserEntity(String userName, String name, String lastName, String password, String salt, String email, Date createdDate, Date modiDate, int statusId, AddressValue addressValue, PhoneValue phoneValue) {
    this.userName = userName;
    this.name = name;
    this.lastName = lastName;
    this.password = password;
    this.salt = salt;
    this.email = email;
    this.createdDate = createdDate;
    this.modifiedDate = modiDate;
    this.statusId = statusId;
    this.addressValue = addressValue;
    this.phoneValue = phoneValue;

    }
}
