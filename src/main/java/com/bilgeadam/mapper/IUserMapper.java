package com.bilgeadam.mapper;

import com.bilgeadam.dto.request.UserResgisterRequestDto;
import com.bilgeadam.repository.entity.Movie;
import com.bilgeadam.repository.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {

    IUserMapper INSTANCE= Mappers.getMapper(IUserMapper.class);

    User toUser(final UserResgisterRequestDto dto);


}
