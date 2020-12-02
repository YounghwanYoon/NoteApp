package com.ray.noteapp.model.repository.room

import com.ray.noteapp.model.data.Note
import com.ray.noteapp.model.data.NoteCacheEntity
import com.ray.noteapp.model.utils.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor():EntityMapper<NoteCacheEntity, Note>{
    override fun mapFromEntity(entity: NoteCacheEntity): Note {
        return Note(
            id = entity.id,
            title= entity.title,
            time_update = entity.time_update,
            body=entity.body
        )
    }

    override fun maptoEntity(domainModel: Note): NoteCacheEntity {
        return NoteCacheEntity(
            id = domainModel.id,
            title= domainModel.title,
            time_update = domainModel.time_update,
            body=domainModel.body
        )
    }

    fun mapFromEntityList(entities: List<NoteCacheEntity>):List<Note>{
        return entities.map{mapFromEntity(it)}
    }
}