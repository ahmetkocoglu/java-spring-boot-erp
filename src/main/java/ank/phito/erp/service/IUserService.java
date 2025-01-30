package ank.phito.erp.service;

import ank.phito.erp.dto.DtoUser;
import ank.phito.erp.dto.DtoUserIU;

import java.util.List;

public interface IUserService {

    public DtoUser saveUser(DtoUserIU dtoUser);

    public List<DtoUser> getAllUser();

    public DtoUser getUserById(String id);

    public void deleteUser(String id);

    public DtoUser updateUser(String id , DtoUserIU dtoUserIU);

}
