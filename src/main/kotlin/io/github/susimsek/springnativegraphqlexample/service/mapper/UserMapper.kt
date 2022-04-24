package io.github.susimsek.springnativegraphqlexample.service.mapper

import io.github.susimsek.springnativegraphqlexample.domain.User
import io.github.susimsek.springnativegraphqlexample.graphql.input.AddUserInput
import io.github.susimsek.springnativegraphqlexample.graphql.type.UserPayload
import org.mapstruct.BeanMapping
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget
import org.mapstruct.Named
import org.mapstruct.NullValuePropertyMappingStrategy
import org.mapstruct.ReportingPolicy

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
interface UserMapper : EntityMapper<User, UserPayload> {

    fun toEntity(input: AddUserInput): User

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    fun partialUpdate(@MappingTarget entity: User, input: AddUserInput)
}
