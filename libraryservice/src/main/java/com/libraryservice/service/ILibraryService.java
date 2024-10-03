package com.libraryservice.service;

import com.libraryservice.model.Library;

import java.util.List;
import java.util.Optional;

public interface ILibraryService {
    List<Library> getAllLibraries();
void deleteLibrary(Long libraryId);
    String addLibrary(Library book);
    Library getLibrary(Long libraryId);
     Optional<Library> findLibraryByName(String name);
}
