package com.fikupn.ucolo

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // DRAWER
        val toolbar = findViewById<Toolbar>(R.id.toolbar_myDay)
        val drw_layout = findViewById<DrawerLayout>(R.id.drw_myDay)
        val nav_view = findViewById<NavigationView>(R.id.nav_view)
        setSupportActionBar(toolbar);

        val navController = Navigation.findNavController(this, R.id.fragCon_myDay)
        NavigationUI.setupWithNavController(nav_view, navController)
        NavigationUI.setupActionBarWithNavController(this, navController, drw_layout)

        val toggle = ActionBarDrawerToggle(this, drw_layout, toolbar,
                                R.string.navigation_drawer_open,
                                R.string.navigation_drawer_close)
        drw_layout.addDrawerListener(toggle)
        toggle.syncState()


        //Dropdown
        val navHeaderDrawer = nav_view.getHeaderView(0)
        val btnProfile = navHeaderDrawer.findViewById<ImageButton>(R.id.btn_profile_menu)
        var boolVisible = false

        btnProfile.setOnClickListener{
            val menuProfile = nav_view.menu
            if(!boolVisible)
            {
                menuProfile.setGroupVisible(R.id.profile_menu, true)
                boolVisible = true
            }

            else
            {
                menuProfile.setGroupVisible(R.id.profile_menu, false)
                boolVisible = false
            }
        }

        val navDrawerMenu = NavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_manage_acc -> {
                    navController.navigate(R.id.nav_manage_acc)
                    drw_layout.close()
                    //Toast.makeText(this, "Manage Account", Toast.LENGTH_SHORT).show()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_logout -> {
                    //Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show()
                    alertClick()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_myDay -> {
                    navController.navigate(R.id.nav_myDay)
                    drw_layout.close()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_important -> {
                    navController.navigate(R.id.nav_important)
                    drw_layout.close()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_planned -> {
                    navController.navigate(R.id.nav_planned)
                    drw_layout.close()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.nav_task -> {
                    navController.navigate(R.id.nav_task)
                    drw_layout.close()
                    return@OnNavigationItemSelectedListener true
                }

                R.id.nav_newList ->
                {
                    addNewList()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

        nav_view.setNavigationItemSelectedListener(navDrawerMenu)
    }

    override fun onBackPressed() {
        val drw_layout = findViewById<DrawerLayout>(R.id.drw_myDay)
        if(drw_layout.isDrawerOpen(GravityCompat.START)){
            drw_layout.closeDrawer(GravityCompat.START)
        } else{
            super.onBackPressed()
        }
    }

    fun alertClick() {

        val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_logout, null)
        val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
        val btnLogoutOkay = mDialogView.findViewById<Button>(R.id.btn_logoutOkay)
        val btnLogoutCancel = mDialogView.findViewById<Button>(R.id.btn_logoutCancel)
        val  mAlertDialog = mBuilder.show()

        btnLogoutCancel.setOnClickListener {
            mAlertDialog.dismiss()
            Toast.makeText(this, "Belum Log Out", Toast.LENGTH_SHORT).show()
        }
        btnLogoutOkay.setOnClickListener{
            finish()
            Toast.makeText(this, "Sudah Log Out", Toast.LENGTH_SHORT).show()
        }
    }

    fun addNewList()
    {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_new_list, null)
        val mBuilder = AlertDialog.Builder(this).setView(mDialogView)
        val btnAddOkay = mDialogView.findViewById<Button>(R.id.btn_addOkay)
        val btnAddCancel = mDialogView.findViewById<Button>(R.id.btn_addCancel)
        val  mAlertDialog = mBuilder.show()

        btnAddCancel.setOnClickListener {
            mAlertDialog.dismiss()
            Toast.makeText(this, "Cancle Add New List", Toast.LENGTH_SHORT).show()
        }
        btnAddOkay.setOnClickListener{
            mAlertDialog.dismiss()
            Toast.makeText(this, "Success Add New List", Toast.LENGTH_SHORT).show()
        }
    }
}