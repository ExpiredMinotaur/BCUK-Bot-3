package com.expiredminotaur.bcukbot.sql.sfx;

import org.jetbrains.annotations.NotNull;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SFXRepository extends CrudRepository<SFX, Integer>
{
    @Override
    @Cacheable(value = "SFX")
    @NotNull
    List<SFX> findAll();

    @Query("from SFX where hidden=false")
    @Cacheable(value = "SFX_NOT_HIDDEN")
    @NotNull
    List<SFX> getSFXList();

    @Query("from SFX where lower(triggerCommand)=:trigger")
    @Cacheable(value = "SFX")
    @NotNull
    List<SFX> findByTrigger(String trigger);

    @Cacheable(value = "SFX")
    @NotNull
    List<SFX> findByCategory(SFXCategory category);

    @Cacheable(value = "SFX_NULL")
    @NotNull
    List<SFX> findByCategoryIsNull();

    @Override
    @CacheEvict(value = {"SFX", "SFX_NULL", "SFX_NOT_HIDDEN"}, allEntries = true)
    void deleteById(@NotNull Integer id);

    @Override
    @CacheEvict(value = {"SFX", "SFX_NULL", "SFX_NOT_HIDDEN"}, allEntries = true)
    void delete(@NotNull SFX sfx);

    @Override
    @CacheEvict(value = {"SFX", "SFX_NULL", "SFX_NOT_HIDDEN"}, allEntries = true)
    @NotNull <S extends SFX> S save(@NotNull S sfx);
}
