package codemakers.daggermvp.ui.add

import codemakers.daggermvp.data.model.Todo
import io.reactivex.Observable

interface AddView{

    fun onClickAdd():Observable<Todo>
    fun todoAdded()

}