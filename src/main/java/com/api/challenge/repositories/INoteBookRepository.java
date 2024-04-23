package com.api.challenge.repositories;

import com.api.challenge.entities.NoteBookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface INoteBookRepository extends JpaRepository <NoteBookEntity, Long> {
    List<NoteBookEntity> findByFirstNameContainingIgnoreCase(String firstName);
}
