package com.libraryservice.service;


import com.libraryservice.model.Library;
import com.libraryservice.repos.LibraryRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@Slf4j
@AllArgsConstructor
@Service
public class ILibraryServiceImpl implements ILibraryService {


    private final LibraryRepository libraryRepository;

    @Override
    public List<Library> getAllLibraries() {
        log.info("getting all libraryies");
        return libraryRepository.findAll();
    }

    @Override
    public void deleteLibrary(Long libraryId) {
        libraryRepository.deleteById(libraryId);
    }


    @Override
    @Transactional
    public String addLibrary(@RequestBody Library library) {
        Optional<Library> existingLibrary = libraryRepository.findLibraryByAddressAndName(library.getAddress(),library.getName());
        if (existingLibrary.isPresent()) {
            throw new RuntimeException("A library with the name: " + library.getName() + " and address: " + library.getAddress() + " already exists");
        }
        libraryRepository.save(library);
        return library.getName() + " is created successfully";
    }

@Override
public Optional<Library> findLibraryByName(String name) {
        return libraryRepository.findLibraryByName(name);
    }

    @Override
    public Library getLibrary(Long libraryId) {
        return libraryRepository.findById(libraryId).orElse(null);
    }
}


