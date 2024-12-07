package com.pfa.eventservice.mappers;

import com.pfa.eventservice.dao.entities.Creator;
import com.pfa.eventservice.dao.entities.Event;
import com.pfa.eventservice.dao.repositories.CreatorRepository;
import com.pfa.eventservice.dto.CreatorDto;
import jakarta.validation.constraints.Null;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatorMapper {


    private final CreatorRepository creatorRepository;

    public CreatorMapper(CreatorRepository creatorRepository) {
        this.creatorRepository = creatorRepository;
    }

    public CreatorDto convertCreatorToDto(Creator creator) {
        if (creator == null) {

            return null;
        }

        CreatorDto creatorDto = new CreatorDto();
        BeanUtils.copyProperties(creator, creatorDto);
        return creatorDto;
    }
    public Creator convertCreatorDtoToCreator(CreatorDto creatorDto )
    {
        if (creatorDto == null)
        {
            return null ;
        }
        Creator creator = new Creator() ;
        BeanUtils.copyProperties(creatorDto,creator);

        return creator ;
    }
}
