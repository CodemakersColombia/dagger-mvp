package codemakers.daggermvp.ui.add

import codemakers.daggermvp.data.dao.TodoDao
import codemakers.daggermvp.data.model.Todo
import codemakers.daggermvp.di.ActivityScope
import codemakers.daggermvp.util.push
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ActivityScope
class AddPresenter @Inject constructor(val dao: TodoDao) {

    val dis: CompositeDisposable = CompositeDisposable()

    fun bind(view: AddView) {
        dis push view.onClickAdd()
                .flatMap(this::insert)
                .subscribe { view.todoAdded() }
    }

    fun unbind() {
        dis.dispose()
    }

    fun insert(todo: Todo): Observable<Unit>
            = Observable.fromCallable { dao.insert(todo) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


}
