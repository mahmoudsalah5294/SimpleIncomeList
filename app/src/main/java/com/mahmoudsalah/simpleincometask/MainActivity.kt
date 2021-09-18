package com.mahmoudsalah.simpleincometask

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import com.mahmoudsalah.simpleincometask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list = mutableListOf()

    }

    fun getData():String{
        val name = binding.aName.text.toString()
        val amount = binding.amount.text.toString()
        return "$name  $amount"
    }

    fun updateAdapter(list: MutableList<String>){
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        binding.incomeList.adapter = adapter
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (!binding.aName.text.isNullOrEmpty() || !binding.amount.text.isNullOrEmpty()) {
            when (item.itemId) {
                R.id.addBtn -> {
                    list.add(getData())
                    updateAdapter(list)
                    emptyFields()
                }
            }
        }else{
            Toast.makeText(this,"Please Fill the Blank",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun emptyFields(){
        binding.aName.setText("")
        binding.amount.setText("")
    }
}