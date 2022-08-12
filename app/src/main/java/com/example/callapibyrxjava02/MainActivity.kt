package com.example.callapibyrxjava02

import android.app.AlertDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.callapibyrxjava02.adapter.MoviesAdapter
import com.example.callapibyrxjava02.databinding.ActivityMainBinding
import com.example.callapibyrxjava02.viewModel.MovieViewModel
import dmax.dialog.SpotsDialog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var mainActivityViewModel: MovieViewModel? = null
    private var dialog: AlertDialog? = null
    var adapter: MoviesAdapter? = null
    var layoutManager: LinearLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initObserver()
    }

    private fun initViewModel() {
        mainActivityViewModel = ViewModelProvider(this)[MovieViewModel::class.java]
        dialog = SpotsDialog.Builder().setContext(this).build()
        dialog!!.show()

        layoutManager = LinearLayoutManager(this)
        binding.recyclerview.layoutManager = layoutManager
    }

    private fun initObserver() {
        mainActivityViewModel!!.getMovieList.observe(this) { postModels ->
            adapter = MoviesAdapter(this, postModels)
            adapter!!.notifyDataSetChanged()
            binding.recyclerview.adapter = adapter
            dialog!!.dismiss()
        }
    }
}