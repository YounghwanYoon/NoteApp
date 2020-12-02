package com.ray.noteapp.model.repository.retrofit

import com.ray.noteapp.model.data.Note
import com.ray.noteapp.model.data.NoteNetworkEntity
import com.ray.noteapp.model.utils.EntityMapper
import javax.inject.Inject

class NetworkMapper
@Inject
constructor(): EntityMapper<NoteNetworkEntity, Note> {
    override fun mapFromEntity(entity: NoteNetworkEntity): Note {
        return Note(
            id = entity.id,
            title = entity.title,
            time_update = entity.time_update,
            body = entity.body
        )
    }

    override fun maptoEntity(domainModel: Note): NoteNetworkEntity {
        return NoteNetworkEntity(
            id = domainModel.id,
            title = domainModel.title,
            time_update = domainModel.time_update,
            body = domainModel.body
        )
    }

    fun mapFromEntityList(entities:List<NoteNetworkEntity>):List<Note>{
        return entities.map{mapFromEntity(it)}
    }
}