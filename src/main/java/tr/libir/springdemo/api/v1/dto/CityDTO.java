package tr.libir.springdemo.api.v1.dto;

import lombok.Data;

@Data
public class CityDTO {

    private Long id;
    private String cityName;
    private int cityCode;

}
