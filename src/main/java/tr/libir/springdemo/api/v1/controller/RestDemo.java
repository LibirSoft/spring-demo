package tr.libir.springdemo.api.v1.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.libir.springdemo.api.v1.dto.CityDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/city")
public class RestDemo {


    private final List<CityDTO> cityList  = new ArrayList();//Çskma DB

    RestDemo(){

        CityDTO cityDTO = new CityDTO();
        cityDTO.setCityCode(53);
        cityDTO.setCityName("Rize");
        cityDTO.setId(1L);

        cityList.add(cityDTO);

        cityDTO = new CityDTO();
        cityDTO.setCityCode(34);
        cityDTO.setCityName("İstanbul");
        cityDTO.setId(2L);

        cityList.add(cityDTO);


        cityDTO = new CityDTO();
        cityDTO.setCityCode(01);
        cityDTO.setCityName("Ankara");
        cityDTO.setId(3L);

        cityList.add(cityDTO);


    }

    private CityDTO findByCityName(String cityName){
        CityDTO result = null;
        for (int i=0;i<=cityList.size();i++){
            if (cityList.get(i).getCityName().equals(cityName)){
                result = cityList.get(i);
                break;
            }
        }
        return result;
    }

    private CityDTO findByCityName(int id) {
        /**
         * java 8 stream kullanımı
         */
        return cityList.stream().filter(c->c.getId()==id).findAny().orElse(null);
    }

    @GetMapping(value = "/")
    private ResponseEntity<CityDTO> getCityByCityName(@RequestParam("cityName") String cityName){
            System.out.println("city name :"+cityName);
            CityDTO cityDTO = findByCityName(cityName);

            if (cityDTO==null)
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(cityDTO,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    private ResponseEntity<CityDTO> getCityById(@PathVariable("id") int id){

        System.out.println("city id :"+id);
        CityDTO cityDTO = findByCityName(id);

        if (cityDTO==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(cityDTO,HttpStatus.OK);

    }

    @PostMapping(value = "/")
    private ResponseEntity<CityDTO> save(@RequestBody CityDTO cityDTO){

        if (cityDTO != null && cityDTO.getCityCode() != 0){
            /**
             * Database kaydettiğini varsayuyıruz.
             */

            return new ResponseEntity<>(HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);


    }

}
