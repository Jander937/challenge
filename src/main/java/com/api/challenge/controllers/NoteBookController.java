package com.api.challenge.controllers;

import com.api.challenge.dto.NoteBookDTO;
import com.api.challenge.dto.errorDTO.NoteBookErrorDTO;
import com.api.challenge.entities.NoteBookEntity;
import com.api.challenge.service.NoteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@CrossOrigin(originPatterns = "*")
public class NoteBookController {

    @Autowired
    private NoteBookService noteBookService;

    @PostMapping("/save")
    public ResponseEntity<?>add(@RequestBody NoteBookEntity dataReceived){
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.noteBookService.save(dataReceived));
        }catch (Exception error){
            NoteBookErrorDTO errorPersonalized = new NoteBookErrorDTO();
            errorPersonalized.setMessageError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalized.getMessageError());
        }
    }
    @GetMapping("/search")
    public ResponseEntity<?> searchAll(){
        try {
            List<NoteBookDTO> noteBookDTOList = (List<NoteBookDTO>) this.noteBookService.searchAll();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(noteBookDTOList);
        }catch (Exception error){
            NoteBookErrorDTO noteBookPersonalized = new NoteBookErrorDTO();
            noteBookPersonalized.setMessageError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(noteBookPersonalized.getMessageError());
        }

        }
    @GetMapping("/name")
    public ResponseEntity<?> searchByName(@RequestParam String firstName){
        try {
            List<NoteBookDTO> noteBookDTOList = this.noteBookService.searchByName(firstName);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(noteBookDTOList);
        }catch (Exception e){
            NoteBookErrorDTO errorPersonalized = new NoteBookErrorDTO();
            errorPersonalized.setMessageError(e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(errorPersonalized.getMessageError());
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@RequestBody NoteBookEntity dataReceived, @PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(this.noteBookService.modify(id, dataReceived));
        }catch (Exception error){
            NoteBookErrorDTO errorPersonalized = new NoteBookErrorDTO();
            errorPersonalized.setMessageError(error.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorPersonalized.getMessageError());
        }
    }
    @DeleteMapping(value = "/delete/{id}")
    public Optional<ResponseEntity<?>> delete(@PathVariable int id){
        Boolean result = noteBookService.delete(id);

        if (result){
            return Optional.of(ResponseEntity.noContent().build());
        }
        return Optional.of(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }
}
