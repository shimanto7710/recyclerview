package com.example.recyclerview.ui.simple_recycler_filter

import android.app.SearchManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.SearchView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.R
import com.example.recyclerview.utls.RecyclerviewExtentions.LinearVerticalItemDecoration
import kotlinx.android.synthetic.main.activity_simple_recycler_with_filter.*


class SimpleRecyclerWithFilterActivity : AppCompatActivity() {
    private var searchView: SearchView? = null
    lateinit var adapterVertical: SimpleAdapterVerticalFilter
    lateinit var verticalList: ArrayList<String>

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_recycler_with_filter)
//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)

        // toolbar fancy stuff
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.title = "asd"

        initRecyclerViewVertical()
//        whiteNotificationBar(window.decorView.rootView)
    }

    private fun initRecyclerViewVertical() {
        verticalList = ArrayList()
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        verticalList.add("adss")
        adapterVertical = SimpleAdapterVerticalFilter(verticalList)
        var layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        simpleVerticalRecyclerView.layoutManager = layoutManager
        simpleVerticalRecyclerView.addItemDecoration(LinearVerticalItemDecoration(0))
        simpleVerticalRecyclerView.adapter = adapterVertical
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)

        // Associate searchable configuration with the SearchView
        val searchManager =
            getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu.findItem(R.id.action_search)
            .actionView as SearchView
        searchView!!.setSearchableInfo(
            searchManager
                .getSearchableInfo(componentName)
        )
        searchView!!.maxWidth = Int.MAX_VALUE

        // listening to search query text change

        // listening to search query text change
        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // filter recycler view when query submitted
                adapterVertical.filter?.filter(query)
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                // filter recycler view when text is changed
                adapterVertical.filter?.filter(query)
                return false
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId

        return if (id == R.id.action_search) {
            true
        } else super.onOptionsItemSelected(item)
    }


    override fun onBackPressed() {
        // close search view on back button pressed
        if (!searchView!!.isIconified) {
            searchView!!.isIconified = true
            return
        }
        super.onBackPressed()
    }

//    private fun whiteNotificationBar(view: View) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            var flags: Int = view.getSystemUiVisibility()
//            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//            view.setSystemUiVisibility(flags)
//            window.statusBarColor = Color.WHITE
//        }
//    }

}