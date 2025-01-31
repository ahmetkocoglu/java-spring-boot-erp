package ank.phito.erp.controller.impl;

import ank.phito.erp.controller.ICalenderController;
import ank.phito.erp.dto.DtoCalender;
import ank.phito.erp.dto.DtoCalenderIU;
import ank.phito.erp.service.ICalenderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calenders")
public class CalenderControllerImpl implements ICalenderController {

    @Autowired
    private ICalenderService calenderService;

    @PostMapping(path = "")
    @Override
    public DtoCalender saveCalender(@RequestBody @Valid DtoCalenderIU dtoCalenderIU) {
        System.out.println("dtoCalenderIU");
        return calenderService.saveCalender(dtoCalenderIU);
    }

    @GetMapping(path = "")
    @Override
    public List<DtoCalender> getAllCalender() {
        return calenderService.getAllCalender();
    }

    @GetMapping(path = "/{id}")
    @Override
    public DtoCalender getCalenderById(@PathVariable(name = "id") String id) {
        return calenderService.getCalenderById(id);
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public void deleteCalender(@PathVariable(name = "id") String id) {
        calenderService.deleteCalender(id);
    }

    @PutMapping(path = "/{id}")
    @Override
    public DtoCalender updateCalender(@PathVariable(name = "id") String id, @RequestBody DtoCalenderIU dtoCalenderIU) {
        return calenderService.updateCalender(id, dtoCalenderIU);
    }
}
