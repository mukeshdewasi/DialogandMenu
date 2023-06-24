package com.example.dialogandmenu

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MenuActivity : AppCompatActivity(),PopupMenu.OnMenuItemClickListener{
    val btncontext:Button
    get() = findViewById(R.id.btn_context)

    val btnpop:Button
    get() = findViewById(R.id.btn_popup)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        registerForContextMenu(btncontext)
        btnpop.setOnClickListener {
            var popup= PopupMenu(this,it)
            menuInflater.inflate(R.menu.item_menu,popup.menu)
            popup.show()
            popup.setOnMenuItemClickListener(this)
        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.item_menu,menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.item_menu,menu)
        return true
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.nav_profile -> {
                Toast.makeText(this,"profile item selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.nav_setting ->{
                Toast.makeText(this,"setting item selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.nav_logout -> {
                showLogoutDialog()
                true
            }
            else -> super.onContextItemSelected(item)


        }
        return super.onContextItemSelected(item)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.nav_profile -> {
                Toast.makeText(this,"profile item selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.nav_setting ->{
                Toast.makeText(this,"setting item selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.nav_logout -> {
                showLogoutDialog()
                true
            }
                else -> super.onOptionsItemSelected(item)


        }

    }
    private fun showLogoutDialog(){
        var builder = AlertDialog.Builder(this)
            .setTitle("Logout")
            .setCancelable(false)
            .setMessage("Are you sure you want to logout from this application ?")
            .setPositiveButton("logout",DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"Positive button clicked",Toast.LENGTH_SHORT)
            }).setNegativeButton("cancel",DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"Negative button clicked",Toast.LENGTH_SHORT)
            })
        builder.show()
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return when(item!!.itemId){
            R.id.nav_profile -> {
                Toast.makeText(this,"profile item selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.nav_setting ->{
                Toast.makeText(this,"setting item selected", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.nav_logout -> {
                showLogoutDialog()
                true
            }
            else -> false

        }

    }

    }

