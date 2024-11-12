package com.chapter1.blueprint.finance.repository;

import com.chapter1.blueprint.finance.domain.SavingsList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingsListRepository extends JpaRepository<SavingsList, Long> {
    @Query("SELECT f.imageUrl FROM SavingsList f WHERE f.idx = :idx")
    String findImageUrlById(@Param("idx") Long idx);
}
