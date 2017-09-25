package codemakers.daggermvp.ui.main

import codemakers.daggermvp.data.model.Todo
import io.reactivex.Observable

interface MainView{

    fun onClickAdd(): Observable<Unit>
    fun onClickRemove():Observable<Todo>
    fun goToAdd()

}