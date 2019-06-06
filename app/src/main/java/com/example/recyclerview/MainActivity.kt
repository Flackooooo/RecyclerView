package com.example.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.recyclerview.dummy.DummyContent

class MainActivity : AppCompatActivity(),ItemFragment.OnListFragmentInteractionListener {
    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, ItemFragment())
            .commit()
        setContentView(R.layout.activity_main)
    }
}
