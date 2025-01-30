package ank.phito.erp.controller;

import ank.phito.erp.dto.DtoUser;
import ank.phito.erp.dto.DtoUserIU;

import java.util.List;

public interface IUserController {
    public DtoUser saveUser(DtoUserIU dtoUserIU);

    public List<DtoUser> getAllUser();

    public DtoUser getUserById(String id);

    public void deleteUser(String id);

    public DtoUser updateUser(String id , DtoUserIU dtoUserIU);
}
