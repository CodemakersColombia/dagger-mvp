package codemakers.daggermvp.ui.main

import codemakers.daggermvp.data.dao.TodoDao
import codemakers.daggermvp.data.model.Todo
import codemakers.daggermvp.di.ActivityScope
import codemakers.daggermvp.util.push
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@ActivityScope
class MainPresenter @Inject constructor(val dao: TodoDao) {

    val dis: CompositeDisposable = CompositeDisposable()

    fun bind(view: MainView) {

        dis push  view.onClickAdd()
                .subscribe { view.goToAdd() }

        dis push view.onClickRemove()
                .flatMap { Observable.fromCallable { dao::delete } }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()


    }

    fun unbind() {
        dis.dispose()
    }

    fun getAllTodo(): Flowable<List<Todo>>
            = dao.all()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


}