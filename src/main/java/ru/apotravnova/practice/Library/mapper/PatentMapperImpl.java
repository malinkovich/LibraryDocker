package ru.apotravnova.practice.Library.mapper;

import org.springframework.stereotype.Component;
import ru.apotravnova.practice.Library.dto.PatentDTO;
import ru.apotravnova.practice.Library.model.Author;
import ru.apotravnova.practice.Library.model.Patent;

@Component
public class PatentMapperImpl implements PatentMapper {

    @Override
    public Patent toModel(PatentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Patent patent = new Patent();

        patent.setAuthor( patentDTOToAuthor( dto ) );
        patent.setId( dto.getId() );
        patent.setTitle( dto.getTitle() );
        patent.setDataRegistr( dto.getDataRegistr() );

        return patent;
    }

    @Override
    public PatentDTO toDto(Patent model) {
        if ( model == null ) {
            return null;
        }

        PatentDTO patentDTO = new PatentDTO();

        patentDTO.setIdAuthor( modelAuthorId( model ) );
        patentDTO.setTitle( model.getTitle() );
        patentDTO.setDataRegistr( model.getDataRegistr() );
        patentDTO.setId( model.getId() );

        return patentDTO;
    }

    protected Author patentDTOToAuthor(PatentDTO patentDTO) {
        if ( patentDTO == null ) {
            return null;
        }

        Author author = new Author();

        author.setId( patentDTO.getIdAuthor() );

        return author;
    }

    private int modelAuthorId(Patent patent) {
        if ( patent == null ) {
            return 0;
        }
        Author author = patent.getAuthor();
        if ( author == null ) {
            return 0;
        }
        int id = author.getId();
        return id;
    }
}