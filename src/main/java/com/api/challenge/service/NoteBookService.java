package com.api.challenge.service;

import com.api.challenge.dto.NoteBookDTO;
import com.api.challenge.entities.NoteBookEntity;

import java.util.List;

public interface NoteBookService {
    NoteBookDTO save(NoteBookEntity dataNoteBookCover)throws Exception;

    List<NoteBookDTO> searchAll()throws Exception;

    List<NoteBookDTO> searchByName(String name) throws Exception;

    NoteBookDTO modify(Integer id, NoteBookEntity noteBook)throws Exception;

    Boolean delete(Integer id);
}
