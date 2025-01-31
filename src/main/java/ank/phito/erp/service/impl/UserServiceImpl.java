package ank.phito.erp.service.impl;

import ank.phito.erp.dto.DtoUser;
import ank.phito.erp.dto.DtoUserIU;
import ank.phito.erp.entity.UserEntity;
import ank.phito.erp.repository.UserRepository;
import ank.phito.erp.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {
    private static final String MY_EMAIL = "akocoglu@gmail.com";
    private static final String EXISTING_EMAIL = "test@test.com";
    private static final String OTHER_EMAIL = "other@test.com";

    @Autowired
    UserRepository userRepository;

    public Optional<UserEntity> findByEmail(String email) {

        Optional<UserEntity> optional = userRepository.findByEmail(email);

        if (optional.isPresent()) {
            UserEntity dbUse = optional.get();
            System.out.println("getId >> " + dbUse.getId());

            /*System.out.println("getEmail >> " + dbUse.getEmail());
            System.out.println("getPassword >> " + dbUse.getPassword());
            System.out.println("getRole >> " + dbUse.getRole());
            System.out.println("setExtraInfo >> " + dbUse.getExtraInfo());*/

//            dbUse.setId("1");
            dbUse.setRole("ROLE_ADMIN");
            dbUse.setExtraInfo("My nice admin user");

            return Optional.of(dbUse);
        } else {
            return Optional.empty();
        }

        /*if (EXISTING_EMAIL.equalsIgnoreCase(email)) {
            var user = new UserEntity();
            user.setId("1");
            user.setEmail(EXISTING_EMAIL);
            user.setPassword("$2a$12$OBnerD3ZrnkqY/ofkaxune1jnpUscFhTGCcuVA9x5lgAGAtr6Bss2"); // test
            user.setRole("ROLE_ADMIN");
            user.setExtraInfo("My nice admin user");
            return Optional.of(user);
        } else if (OTHER_EMAIL.equalsIgnoreCase(email)) {
            var user = new UserEntity();
            user.setId("99");
            user.setEmail(OTHER_EMAIL);
            user.setPassword("$2a$12$OBnerD3ZrnkqY/ofkaxune1jnpUscFhTGCcuVA9x5lgAGAtr6Bss2"); // test
            user.setRole("ROLE_USER");
            user.setExtraInfo("My nice simple user");
            return Optional.of(user);
        } else if (MY_EMAIL.equalsIgnoreCase(email)) {
            var user = new UserEntity();
            user.setId("99");
            user.setEmail(OTHER_EMAIL);
            user.setPassword("$2a$12$OBnerD3ZrnkqY/ofkaxune1jnpUscFhTGCcuVA9x5lgAGAtr6Bss2"); // test
            user.setRole("ROLE_ADMIN");
            user.setExtraInfo("My nice admin user");
            return Optional.of(user);
        } else {
            return Optional.empty();
        }*/
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public DtoUser saveUser(DtoUserIU dtoUserIU) {
        DtoUser response = new DtoUser();
        Optional<UserEntity> optional = userRepository.findByEmail(dtoUserIU.getEmail());
        if (optional.isEmpty())  {
            UserEntity user = new UserEntity();
            BeanUtils.copyProperties(dtoUserIU, user);

            user.setPassword(passwordEncoder().encode(user.getPassword()));

            UserEntity dbUser = userRepository.save(user);
            BeanUtils.copyProperties(dbUser, response);
        }
        return response;
    }

    @Override
    public List<DtoUser> getAllUser() {
        List<DtoUser> dtoList = new ArrayList<>();

        List<UserEntity> userList = userRepository.findAll();
        for (UserEntity user : userList) {
            DtoUser dto = new DtoUser();
            BeanUtils.copyProperties(user, dto);

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public DtoUser getUserById(String id) {
        DtoUser dtoUser = new DtoUser();
        Optional<UserEntity> optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        UserEntity dbUser = optional.get();
        BeanUtils.copyProperties(dbUser, dtoUser);

        return dtoUser;
    }

    @Override
    public void deleteUser(String id) {
        Optional<UserEntity> optional = userRepository.findById(id);
        optional.ifPresent(userEntity -> userRepository.delete(userEntity));
    }

    @Override
    public DtoUser updateUser(String id, DtoUserIU dtoUserIU) {
        DtoUser dto = new DtoUser();

        Optional<UserEntity> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            UserEntity dbUser = optional.get();

            dbUser.setFirstName(dtoUserIU.getFirstName());
            dbUser.setLastName(dtoUserIU.getLastName());
            dbUser.setEmail(dtoUserIU.getEmail());
            dbUser.setPassword(dtoUserIU.getPassword());

            UserEntity updatedUser = userRepository.save(dbUser);

            BeanUtils.copyProperties(updatedUser, dto);
            return dto;
        }
        return null;
    }
}