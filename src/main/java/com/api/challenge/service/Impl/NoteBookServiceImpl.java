package com.api.challenge.service.Impl;

import com.api.challenge.dto.NoteBookDTO;
import com.api.challenge.entities.NoteBookEntity;
import com.api.challenge.mapper.INoteBookMapper;
import com.api.challenge.repositories.INoteBookRepository;
import com.api.challenge.service.NoteBookService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteBookServiceImpl implements NoteBookService {

    @Autowired
    private INoteBookRepository iNoteBookRepository;

    @Autowired
    private INoteBookMapper iNoteBookMapper;

    @Override
    @Transactional
    public NoteBookDTO save(NoteBookEntity dataNoteBookCover) throws Exception {
        try {
            return iNoteBookMapper.noteBookToDTO(iNoteBookRepository.save(dataNoteBookCover));
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional
    public List<NoteBookDTO> searchAll() throws Exception {
        try {
            return iNoteBookRepository.findAll().stream()
                    .map(iNoteBookMapper::noteBookToDTO)
                    .collect(Collectors.toList());
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional
    public List<NoteBookDTO> searchByName(String name) throws Exception {
        List<NoteBookEntity> bookEntities = iNoteBookRepository.findByFirstNameContainingIgnoreCase(name);
        if (bookEntities.isEmpty()) {
            throw new Exception("No se encontraron libros con el título proporcionado.");
        }
        return bookEntities.stream()
                .map(iNoteBookMapper::noteBookToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public NoteBookDTO modify(Integer id, NoteBookEntity noteBook) throws Exception {
        try {
            Optional<NoteBookEntity> optionalNoteBook = iNoteBookRepository.findById(Long.valueOf(id));
            if (optionalNoteBook.isPresent()) {
                NoteBookEntity existingNoteBook = optionalNoteBook.get();
                existingNoteBook.setImg(noteBook.getImg());
                existingNoteBook.setEmail(noteBook.getEmail());
                existingNoteBook.setSurname(noteBook.getSurname());
                existingNoteBook.setFirstName(noteBook.getFirstName());

                return iNoteBookMapper.noteBookToDTO(iNoteBookRepository.save(existingNoteBook));
            } else {
                throw new Exception("NoteBook not found");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    @Override
    @Transactional
    public Boolean delete(Integer id) {
        Optional<NoteBookEntity> delete = iNoteBookRepository.findById(Long.valueOf(id));
        if (delete.isPresent()) {
            iNoteBookRepository.delete(delete.get());
            return true;
        }
        return false;
    }
}