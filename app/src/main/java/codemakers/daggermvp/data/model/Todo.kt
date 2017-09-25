package codemakers.daggermvp.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import java.util.Date

@Entity
class Todo(@PrimaryKey var id: Long?,
           var title: String?,
           var description: String?,
           var date: Date) {

    @Ignore
    constructor(title: String, description: String?) : this(null, title, description, Date())
}