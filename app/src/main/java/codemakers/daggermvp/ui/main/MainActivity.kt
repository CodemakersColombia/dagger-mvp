package codemakers.daggermvp.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

import codemakers.daggermvp.R
import codemakers.daggermvp.data.model.Todo
import codemakers.daggermvp.ui.adapters.TodoAdapter
import codemakers.daggermvp.ui.add.AddActivity
import com.jakewharton.rxbinding2.view.clicks
import dagger.android.AndroidInjection
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var adapter: TodoAdapter
    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)
        presenter.getAllTodo()
                .subscribe { adapter.data = it }

        presenter.bind(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbind()
    }

    override fun onClickAdd(): Observable<Unit> = add.clicks()
    override fun onClickRemove(): Observable<Todo> = adapter.clearSubject
    override fun goToAdd() {
        startActivity<AddActivity>()
    }
}
