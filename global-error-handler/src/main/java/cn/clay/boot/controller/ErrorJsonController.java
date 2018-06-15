package cn.clay.boot.controller;

import cn.clay.boot.bean.City;
import cn.clay.boot.bean.ResultBean;
import cn.clay.boot.bean.constant.CityErrorInfoEnum;
import cn.clay.boot.exception.GlobalErrorInfoException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 这个工程是一个
 * {@link }
 */
@RequestMapping("/")
@RestController
public class ErrorJsonController {

    @RequestMapping(value = "/api/city",method = RequestMethod.POST)
    public ResultBean show(@RequestParam("cityName") String cityName ) throws GlobalErrorInfoException {

        if (StringUtils.isEmpty(cityName)) {
            throw new GlobalErrorInfoException(CityErrorInfoEnum.PARAMS_NO_COMPLETE);
        }
        if (StringUtils.isBlank(" ") ){
            throw new GlobalErrorInfoException(CityErrorInfoEnum.CITY_EXIT);
        }
        return new ResultBean(new City(1L,2L,"禹州","禹州是许昌市管辖县级市，位于河南省中部地区。"));
    }
}
