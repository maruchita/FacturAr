package facturar.users.domain.service;

import facturar.shared.domain.security.Encrypt;
import facturar.users.domain.UserCreatedEvent;
import facturar.users.domain.model.*;
import facturar.users.infrastructure.UserRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.function.Function;


@Service
public class UserProjectorService implements UserService {
    private final UserRepository userRepository;

    public UserProjectorService(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @EventListener
    public void on(UserCreatedEvent event) throws NoSuchAlgorithmException {
        AddressValue addressValue = new AddressValue(event.getAddressType(), event.getStreet(),
                event.getCity(), event.getProvinceId(), event.getCountryId());
        PhoneValue phoneValue = new PhoneValue(event.getPhoneType(), event.getCountryCode(), event.getCityCode(),
        event.getPhoneNumber(), event.getExtension());
        byte[]  salt = Encrypt.getSalt();
        String password = Encrypt.getSecurePassword(event.getPassword(), salt);
        UserEntity userEntity = new UserEntity(event.getUserName(), event.getName(), event.getLastName(),
                password, new String(salt, StandardCharsets.UTF_8),event.getEmail(), java.sql.Date.valueOf(LocalDate.now()),
                java.sql.Date.valueOf(LocalDate.now()), 1, addressValue, phoneValue);

        userRepository.save(userEntity);

    }


    public UserBean getUser(GetUserQuery query) {
       return  null;
    }

    /*private Function<UserEntity, UserBean> toUser() {
        return e -> {
            UserBean userBean = new UserBean(e.getUserName(), );

            return userBean;
        };
    }*/
}
