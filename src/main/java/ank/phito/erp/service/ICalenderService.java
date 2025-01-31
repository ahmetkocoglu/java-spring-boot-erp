package ank.phito.erp.service;

import ank.phito.erp.dto.DtoCalender;
import ank.phito.erp.dto.DtoCalenderIU;

import java.util.List;

public interface ICalenderService {

    public DtoCalender saveCalender(DtoCalenderIU dtoCalender);

    public List<DtoCalender> getAllCalender();

    public DtoCalender getCalenderById(String id);

    public void deleteCalender(String id);

    public DtoCalender updateCalender(String id , DtoCalenderIU dtoCalenderIU);

}
