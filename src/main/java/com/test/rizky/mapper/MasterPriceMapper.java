package com.test.rizky.mapper;

import com.test.rizky.domain.MasterPrice;
import com.test.rizky.dto.MasterPriceDTO;
import com.test.rizky.repository.MasterPriceRepository;
import com.test.rizky.shared.EntityDTOMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MasterPriceMapper implements EntityDTOMapper<MasterPrice, MasterPriceDTO> {
    private final ModelMapper modelMapper;
    private final MasterPriceRepository masterPriceRepository;

    @Autowired
    public MasterPriceMapper(ModelMapper modelMapper, MasterPriceRepository masterPriceRepository) {
        this.modelMapper = modelMapper;
        this.masterPriceRepository = masterPriceRepository;
    }

    @Override
    public MasterPriceDTO convertToDto(MasterPrice masterPrice){
        return modelMapper.map(masterPrice, MasterPriceDTO.class);
    }

    @Override
    public List<MasterPriceDTO> convertToDto(List<MasterPrice> masterPriceList){
        return masterPriceList.stream().map(this::convertToDto).collect(Collectors.toList());
    }
    @Override
    public MasterPrice convertToEntity(MasterPriceDTO masterPriceDTO){
        MasterPrice masterPrice;

        if (masterPriceDTO.getId() != null){
            masterPrice = masterPriceRepository.findById(masterPriceDTO.getId());
        } else {
            masterPrice = new MasterPrice();
        }
        assert masterPrice != null;
        masterPrice.setOriginCode(masterPriceDTO.getOriginCode());
        masterPrice.setDestinationCode(masterPriceDTO.getDestinationCode());
        masterPrice.setPrice(masterPriceDTO.getPrice());
        masterPrice.setProduct(masterPriceDTO.getProduct());

        return masterPrice;
    }

    @Override
    public List<MasterPrice> convertToEntity(List<MasterPriceDTO> masterPriceDTOList){
        return masterPriceDTOList.stream().map(this::convertToEntity).collect(Collectors.toList());
    }
}
