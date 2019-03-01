package com.lambdaschool.bookstore.repository;

import com.lambdaschool.bookstore.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface Sectionrepository extends JpaRepository<Section, Long>
{
    List<Section> findSectionByNameEquals(String name);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM studsections WHERE sectionid = :sectionid", nativeQuery = true)
    void deleteCourseFromStudsections(long sectionid);
}
