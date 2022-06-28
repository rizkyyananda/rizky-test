package com.test.rizky.service;

import com.test.rizky.dto.MasterPriceDTO;
import com.test.rizky.dto.PaginationDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MasterPriceService {
    MasterPriceDTO addMasterPrice (MasterPriceDTO dto);
    MasterPriceDTO getById (Long id);
    List<MasterPriceDTO> getAll ();
    MasterPriceDTO updateMasterPrice (MasterPriceDTO dto);
    String deleteMasterPrice(Long id);
    List<MasterPriceDTO> filter(PaginationDTO dto);
}
