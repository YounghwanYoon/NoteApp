package com.ray.noteapp.model.utils

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity:Entity):DomainModel

    fun maptoEntity(domainModel:DomainModel):Entity

}