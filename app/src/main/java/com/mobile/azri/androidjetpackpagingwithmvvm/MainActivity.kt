package com.mobile.azri.androidjetpackpagingwithmvvm

import RecyclerViewAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobile.azri.androidjetpackpagingwithmvvm.databinding.ActivityMainBinding
import com.mobile.azri.androidjetpackpagingwithmvvm.view.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var adapterRecyler : RecyclerViewAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        subscribeObservers()
        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.rvMain.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(applicationContext,DividerItemDecoration.VERTICAL)

            addItemDecoration(decoration)
            adapterRecyler = RecyclerViewAdapter()
            adapter = adapterRecyler
        }
    }

    private fun subscribeObservers(){
        viewModel.getRecyclerListObserver()?.observe(this, Observer {
            if (it!=null){
                adapterRecyler.submitList(it)
            }else{
                //show data null
                Toast.makeText(this,"Failed to fetch data!",Toast.LENGTH_LONG).show()
            }
        })
    }

}