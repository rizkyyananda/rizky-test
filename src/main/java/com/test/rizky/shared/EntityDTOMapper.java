package com.test.rizky.shared;

import java.util.List;

public interface EntityDTOMapper<Entity, DTO> {
    DTO convertToDto(Entity entity);
    List<DTO> convertToDto(List<Entity> entities);
    Entity convertToEntity(DTO dto);
    List<Entity>convertToEntity(List<DTO> dtos);
}
