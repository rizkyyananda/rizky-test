package com.test.rizky;

import com.test.rizky.dto.MasterPriceDTO;
import com.test.rizky.dto.PaginationDTO;
import com.test.rizky.dto.response.ResponseDTO;
import com.test.rizky.service.MasterPriceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@SpringBootApplication
@RestController
public class RizkyApplication {
    private final MasterPriceService masterPriceService;

    public RizkyApplication(MasterPriceService masterPriceService) {
        this.masterPriceService = masterPriceService;
    }


    public static void main(String[] args) {
        SpringApplication.run(RizkyApplication.class, args);
    }

    @PostMapping(value = "/add/master-price")
    @ApiOperation("Api to add master price")
    public ResponseDTO addMasterPrice(@RequestBody MasterPriceDTO dto) {
        return ResponseDTO.SUCCESS(masterPriceService.addMasterPrice(dto));
    }

    @PutMapping(value = "/update/master-price")
    @ApiOperation("Api to update master price")
    public ResponseDTO updateMasterPrice(@RequestBody MasterPriceDTO dto){
        return ResponseDTO.SUCCESS(masterPriceService.updateMasterPrice(dto));
    }

    @GetMapping("/get/list/master-price")
    @ApiOperation("get all list data")
    public ResponseDTO getList (){
        return ResponseDTO.SUCCESS((Serializable) masterPriceService.getAll());
    }

    @PostMapping("/filter/master-price")
    @ApiOperation("get all list data")
    public ResponseDTO pagination (@RequestBody PaginationDTO dto){
        return ResponseDTO.SUCCESS((Serializable) masterPriceService.filter(dto));
    }

    @GetMapping(value = "/get/master-price/{id}")
    @ApiOperation("get master price by id")
    public ResponseDTO getMasterPrice(@PathVariable ("id") Long id){
        return ResponseDTO.SUCCESS(masterPriceService.getById(id));
    }
    @DeleteMapping(value = "delete/master-price/{id}")
    @ApiOperation("delete data price by id")
    public ResponseDTO deleteMasterPrice(@PathVariable ("id") Long id){
        return ResponseDTO.SUCCESS( masterPriceService.deleteMasterPrice(id));
    }

}
