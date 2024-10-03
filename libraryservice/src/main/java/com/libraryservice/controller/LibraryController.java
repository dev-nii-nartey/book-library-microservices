package com.libraryservice.controller;


import com.libraryservice.model.Library;
import com.libraryservice.service.ILibraryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/library")
@AllArgsConstructor
public class LibraryController {
    private ILibraryService libraryService;

    @GetMapping
//    @Cacheable("allBooksCache")
    public ResponseEntity<List<Library>> getAllLibrary() {
        return ResponseEntity.ok(libraryService.getAllLibraries());
    }


    @PostMapping
//    @CacheEvict(value = {"allBooksCache", "recommendationsCache"}, allEntries = true)
    public String addBook( @RequestBody Library library) {
        return libraryService.addLibrary(library);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        libraryService.deleteLibrary(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Library> findBookById(@PathVariable Long id) {
        Library library = libraryService.getLibrary(id);
        if (library != null) {
            return ResponseEntity.ok(library);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<Optional<Library>> getLibraryByName(@RequestParam String name) {
        Optional<Library> library = libraryService.findLibraryByName(name);
        if (library != null) {
            return ResponseEntity.ok(library);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}




