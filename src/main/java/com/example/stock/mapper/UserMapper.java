package com.example.stock.mapper;

import com.example.stock.dto.SaveUserdto;
import com.example.stock.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface  UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User userToSaveUserDTO(SaveUserdto saveUserdto);
}
