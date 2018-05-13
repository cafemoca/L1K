package cm.moca.l1k.server.models.entities

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity

open class EntityBase(id: EntityID<Int>): IntEntity(id)
