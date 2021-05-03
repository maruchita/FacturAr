package facturar.users.application;

import facturar.shared.domain.Command;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class CreateUserCommand extends Command {


    private final Integer id;
    private final String userName;
    private final String name;
    private final String lastName;
    private final String password;
    private final String email;
    private final Integer phoneType;
    private final String countryCode;
    private final Integer cityCode;
    private final String phoneNumber;
    private final String extension;
    private final Integer addressType;
    private final String street;
    private final String city;
    private final Integer provinceId;
    private final Integer countryId;




}
