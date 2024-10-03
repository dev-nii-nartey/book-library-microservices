package com.libraryservice.repos;

import com.libraryservice.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

    Optional<Library> findLibraryByAddressAndName(String address, String name);
    Optional<Library> findLibraryByName( String name);
}