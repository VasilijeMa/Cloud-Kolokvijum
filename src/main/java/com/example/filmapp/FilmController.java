package com.example.filmapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/film")
public class FilmController {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping
    public ResponseEntity<List<Film>> getFilms() {
        return ResponseEntity.ok(filmRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Film> addFilm(@RequestBody Film film) {
        film = filmRepository.save(film);
        return ResponseEntity.ok(film);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilm(@PathVariable Long id) {
        Film film = filmRepository.findById(id).orElse(null);
        if (film == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(film);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable Long id, @RequestBody Film film) {
        Film storedFilm = filmRepository.findById(id).orElse(null);
        if (storedFilm == null) {
            return ResponseEntity.notFound().build();
        }
        film.setId(storedFilm.getId());
        filmRepository.save(film);
        return ResponseEntity.ok(film);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeFilm(@PathVariable Long id) {
        Film bread = filmRepository.findById(id).orElse(null);
        if (bread == null) {
            return ResponseEntity.notFound().build();
        }
        filmRepository.delete(bread);
        return ResponseEntity.noContent().build();
    }
}