package crm.crm.mapper;

import crm.crm.DTO.ContratDTO;
import crm.crm.entity.Contrat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ContratMapper {

    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    ContratDTO contratToContratDTO(Contrat contrat);

    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    Contrat contratDTOToContrat(ContratDTO contractDTO);
}
