package com.test.rizky.service.impl;

import com.test.rizky.domain.MasterPrice;
import com.test.rizky.dto.MasterPriceDTO;
import com.test.rizky.dto.PaginationDTO;
import com.test.rizky.exeption.ErrorApp;
import com.test.rizky.mapper.MasterPriceMapper;
import com.test.rizky.repository.MasterPriceRepository;
import com.test.rizky.service.MasterPriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.test.rizky.shared.util.ObjectUtil.isExist;
import static com.test.rizky.shared.util.ValidatorUtil.validateField;


@Slf4j
@Service
public class MasterPriceServiceImpl implements MasterPriceService {
    private final MasterPriceRepository masterPriceRepository;
    private final MasterPriceMapper masterPriceMapper;

    public MasterPriceServiceImpl(MasterPriceRepository masterPriceRepository, MasterPriceMapper masterPriceMapper) {
        this.masterPriceRepository = masterPriceRepository;
        this.masterPriceMapper = masterPriceMapper;
    }

    @Override
    public MasterPriceDTO addMasterPrice(MasterPriceDTO dto) {
        log.info("master price request. addMasterPrice {}", dto);
        validateField(dto.getDestinationCode(), "destination code");
        validateField(dto.getOriginCode(), "origin code");
        validateField(dto.getPrice(), "price");
        validateField(dto.getProduct(), "product");

        MasterPrice masterPrice = masterPriceMapper.convertToEntity(dto);
        masterPrice = masterPriceRepository.save(masterPrice);
        return masterPriceMapper.convertToDto(masterPrice);
    }

    @Override
    public MasterPriceDTO getById(Long id) {
        validateField(id, "id");
        MasterPrice masterPrice = masterPriceRepository.findById(id);
        if  (!isExist(masterPrice)){
            throw new ErrorApp("404", "data not found");
        }
        log.info("response get data from redis {}", masterPrice);

        return isExist(masterPrice) ? masterPriceMapper.convertToDto(masterPrice) : null;
    }

    @Override
    public List<MasterPriceDTO> getAll() {
        List<MasterPrice> masterPriceList = (List<MasterPrice>) masterPriceRepository.findAll();
        log.info("response getAll. masterPriceList{}", masterPriceList);

        return masterPriceMapper.convertToDto(masterPriceList);

    }

    @Override
    public MasterPriceDTO updateMasterPrice(MasterPriceDTO dto) {
        log.info("request update data {}", dto.toString());
        validateField(dto.getId(), "id");
        MasterPrice masterPrice = masterPriceMapper.convertToEntity(dto);
        masterPriceRepository.save(masterPrice);

        return masterPriceMapper.convertToDto(masterPrice);
    }

    @Override
    public String deleteMasterPrice(Long id) {
        validateField(id, "id");
        MasterPrice masterPrice = masterPriceRepository.findById(id);
        if (isExist(masterPrice)){
            masterPriceRepository.delete(masterPrice);
        }else{
            throw new ErrorApp("404", "data not found");
        }

        return "delete success";
    }

    @Override
    public List<MasterPriceDTO> filter(PaginationDTO dto) {

        List<MasterPrice> masterPriceList = (List<MasterPrice>) masterPriceRepository.getByOriginCode(dto.getOriginCode());

        masterPriceList = masterPriceList.stream().sorted(Comparator.comparing(MasterPrice::getPrice)).collect(Collectors.toList());


        return masterPriceMapper.convertToDto(masterPriceList);
    }
}
