package com.example.animeapp.home.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.animeapp.core.utils.Result
import com.example.animeapp.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            val layoutManager = LinearLayoutManager(this@MainActivity)
            rvAnime.layoutManager = layoutManager
            rvAnime.setHasFixedSize(true)
            val adapter = AnimeListAdapter()
            rvAnime.adapter = adapter
            viewModel.topAnime.observe(this@MainActivity) { result ->
                when (result) {
                    is Result.Loading -> progressBar.visibility = View.VISIBLE
                    is Result.Error -> {
                        progressBar.visibility = View.GONE
                        Toast.makeText(this@MainActivity, result.error, Toast.LENGTH_SHORT).show()
                    }

                    is Result.Success -> {
                        progressBar.visibility = View.GONE
                        adapter.submitList(result.data)
                    }
                }
            }
        }
    }
}
