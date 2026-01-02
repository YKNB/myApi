package com.vkstech.elasticsearch.repository;

import com.vkstech.elasticsearch.entity.Bank;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankRepository extends ElasticsearchRepository<Bank, Long> {

    List<Bank> findByName(String name);

}
