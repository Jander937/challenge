package com.api.challenge.mapper;

import com.api.challenge.dto.NoteBookDTO;
import com.api.challenge.entities.NoteBookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface INoteBookMapper {
    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "surname", target = "surname"),
            @Mapping(source = "img", target = "img"),
            @Mapping(source = "firstName", target = "firstName"),
            @Mapping(source = "email", target = "email")
    })
    NoteBookDTO noteBookToDTO(NoteBookEntity noteBook);

    List<NoteBookDTO> toDTOList(List<NoteBookEntity> noteBookEntities);
}
