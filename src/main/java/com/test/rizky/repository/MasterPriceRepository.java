package com.test.rizky.repository;

import com.test.rizky.domain.MasterPrice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface MasterPriceRepository extends PagingAndSortingRepository<MasterPrice, String> {
    MasterPrice findById(Long id);
    @Query(value = "SELECT * FROM master_price WHERE origin_code like ?1",nativeQuery = true)
    List<MasterPrice>getByOriginCode(String originCode);
}
