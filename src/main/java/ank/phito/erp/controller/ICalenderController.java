package ank.phito.erp.controller;

import ank.phito.erp.dto.DtoCalender;
import ank.phito.erp.dto.DtoCalenderIU;

import java.util.List;

public interface ICalenderController {
    public DtoCalender saveCalender(DtoCalenderIU dtoCalenderIU);

    public List<DtoCalender> getAllCalender();

    public DtoCalender getCalenderById(String id);

    public void deleteCalender(String id);

    public DtoCalender updateCalender(String id , DtoCalenderIU dtoCalenderIU);
}
