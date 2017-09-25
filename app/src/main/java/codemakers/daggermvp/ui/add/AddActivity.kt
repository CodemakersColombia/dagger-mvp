package codemakers.daggermvp.ui.add

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import codemakers.daggermvp.R
import codemakers.daggermvp.data.model.Todo
import codemakers.daggermvp.util.text
import com.jakewharton.rxbinding2.view.clicks
import dagger.android.AndroidInjection
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_add.*
import javax.inject.Inject

class AddActivity : AppCompatActivity(), AddView {

    @Inject
    lateinit var presenter:AddPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_add)
    }

    override fun onResume() {
        super.onResume()
        presenter.bind(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.unbind()
    }

    override fun onClickAdd(): Observable<Todo> = btnSave.clicks()
            .map { Todo(todoTitle.text(), todoDescription.text()) }

    override fun todoAdded() {
        finish()
    }
}
