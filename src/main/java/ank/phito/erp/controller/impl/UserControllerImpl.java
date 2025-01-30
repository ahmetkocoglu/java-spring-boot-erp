package ank.phito.erp.controller.impl;

import ank.phito.erp.controller.IUserController;
import ank.phito.erp.dto.DtoUser;
import ank.phito.erp.dto.DtoUserIU;
import ank.phito.erp.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements IUserController {

    @Autowired
    private IUserService userService;

    @PostMapping(path = "")
    @Override
    public DtoUser saveUser(@RequestBody @Valid DtoUserIU dtoUserIU) {
        return userService.saveUser(dtoUserIU);
    }

    @GetMapping(path = "")
    @Override
    public List<DtoUser> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping(path = "/{id}")
    @Override
    public DtoUser getUserById(@PathVariable(name = "id") String id) {
        return userService.getUserById(id);
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public void deleteUser(@PathVariable(name = "id") String id) {
        userService.deleteUser(id);
    }

    @PutMapping(path = "/{id}")
    @Override
    public DtoUser updateUser(@PathVariable(name = "id") String id, @RequestBody DtoUserIU dtoUserIU) {
        return userService.updateUser(id, dtoUserIU);
    }
}
