package com.api.challenge.mapper;

import com.api.challenge.dto.NoteBookDTO;
import com.api.challenge.entities.NoteBookEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-04-29T18:49:56-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class INoteBookMapperImpl implements INoteBookMapper {

    @Override
    public NoteBookDTO noteBookToDTO(NoteBookEntity noteBook) {
        if ( noteBook == null ) {
            return null;
        }

        NoteBookDTO noteBookDTO = new NoteBookDTO();

        if ( noteBook.getId() != null ) {
            noteBookDTO.setId( noteBook.getId().intValue() );
        }
        noteBookDTO.setSurname( noteBook.getSurname() );
        noteBookDTO.setImg( noteBook.getImg() );
        noteBookDTO.setFirstName( noteBook.getFirstName() );
        noteBookDTO.setEmail( noteBook.getEmail() );

        return noteBookDTO;
    }

    @Override
    public List<NoteBookDTO> toDTOList(List<NoteBookEntity> noteBookEntities) {
        if ( noteBookEntities == null ) {
            return null;
        }

        List<NoteBookDTO> list = new ArrayList<NoteBookDTO>( noteBookEntities.size() );
        for ( NoteBookEntity noteBookEntity : noteBookEntities ) {
            list.add( noteBookToDTO( noteBookEntity ) );
        }

        return list;
    }
}
