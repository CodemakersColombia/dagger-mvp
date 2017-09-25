package codemakers.daggermvp.util

import android.support.annotation.LayoutRes
import android.support.design.widget.TextInputLayout
import android.view.LayoutInflater
import android.view.ViewGroup
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun ViewGroup.inflate(@LayoutRes layout:Int) = LayoutInflater.from(context).inflate(layout, this, false)

fun TextInputLayout.text():String = editText?.text.toString()

infix fun CompositeDisposable.push(disposable: Disposable){
    add(disposable)
}
