package tr.libir.springdemo.api.v1.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tr.libir.springdemo.api.v1.dto.CityDTO;

@RestController
@RequestMapping(value = "/api/v1/city")
public class RestDemo {

    @GetMapping(value = "/{cityCode}")
    private ResponseEntity<CityDTO> getCityByCidtyCode(@PathVariable("cityCode") int cityCode){

        if (cityCode == 53){
            CityDTO cityDTO = new CityDTO();
            cityDTO.setCityCode(53);
            cityDTO.setCityName("Rize");
            cityDTO.setId(1L);
            return ResponseEntity.ok(cityDTO);
        }else if (cityCode == 34){
            CityDTO cityDTO = new CityDTO();
            cityDTO.setCityCode(34);
            cityDTO.setCityName("İstanbul");
            cityDTO.setId(2L);
            return ResponseEntity.ok(cityDTO);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(value = "/")
    private ResponseEntity<CityDTO> getCityById(@RequestParam("id") int id){

        if (id == 1){
            CityDTO cityDTO = new CityDTO();
            cityDTO.setCityCode(53);
            cityDTO.setCityName("Rize");
            cityDTO.setId(1L);
            return ResponseEntity.ok(cityDTO);
        }else if (id == 2){
            CityDTO cityDTO = new CityDTO();
            cityDTO.setCityCode(34);
            cityDTO.setCityName("İstanbul");
            cityDTO.setId(2L);
            return ResponseEntity.ok(cityDTO);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

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
