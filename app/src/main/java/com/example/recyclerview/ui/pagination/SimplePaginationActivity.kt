package com.example.recyclerview.ui.pagination

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.R
import kotlinx.android.synthetic.main.activity_simple_pagination.*

class SimplePaginationActivity : AppCompatActivity() {


    lateinit var paginationAdapter: PaginationAdapter

    var PAGE_START = 1
    var isLoading = false
    var isLastPage = false
    var TOTAL_PAGES = 5
    var currentPage = PAGE_START
    var LIMIT = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simple_pagination)


//        initPagination()

//        initialData()
    }

    fun initPagination() {

        val linearLayoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        pagingRecyclerview.layoutManager = linearLayoutManager

        paginationAdapter = PaginationAdapter(this)

        pagingRecyclerview.adapter = paginationAdapter


        pagingRecyclerview.addOnScrollListener(object : PaginationScrollListener(linearLayoutManager) {
            override fun loadMoreItems() {
                this@SimplePaginationActivity.isLoading = true
                this@SimplePaginationActivity.currentPage += 1
                nextPageLoad()
            }

            override fun isLastPage(): Boolean {
                return this@SimplePaginationActivity.isLastPage
            }

            override fun isLoading(): Boolean {
                return this@SimplePaginationActivity.isLoading
            }
        })

//        paginationAdapter.setOnClickListener(this)
//        paginationAdapter.setSpinnerListener(this)
    }


    private fun nextPageLoad() {
//        viewModel.getOrderList(null, null, currentPage, LIMIT, null, status)
//            .observe(viewLifecycleOwner, Observer {
//                when (it?.status) {
//                    Resource.Status.SUCCESS -> {
//                        orderList.clear()
//                        val orderLisModel: OrderListModel = it.data!!
//
//
//                        if (orderLisModel!!.items != null) {
//                            for (item in orderLisModel?.items!!) {
////                                Log.d("orderDate","date: "+item.createdAt);
//                                orderList.add(
//                                    OrderModel(
//                                        item.order_parcels._id,
//                                        item.order_parcels.order_parcel_code,
//                                        item.createdAt,
//                                        item.customer_name,
//                                        item.customer_phone,
//                                        item.order_parcels.store_info.store_name,
//                                        item.order_parcels.parcel_shipping_cost,
//                                        "shipping time",
//                                        item.payment_method.name,
//                                        item.payment_status,
//                                        item.order_parcels.parcel_grand_total,
//                                        item.order_parcels.status,
//                                        false
//                                    )
//                                )
//                            }
//                        }
//
//
//                        paginationAdapter.removeLoadingFooter()
//                        isLoading = false
//                        currentPage = orderLisModel!!.pagination.page
//
//                        paginationAdapter.addAll(orderList)
//
//                        if (currentPage != TOTAL_PAGES) {
//                            paginationAdapter.addLoadingFooter()
//                        } else {
//                            isLastPage =
//                                true
//                        }
//
//                    }
//                    Resource.Status.ERROR -> {
//                        it.isNetworkError?.let { it1 ->
//                            if (it1) {
//                                Toast.makeText(
//                                    requireContext(),
//                                    "No Connection",
//                                    Toast.LENGTH_SHORT
//                                )
//                                    .show()
//                            }
//                        }
//                    }
//                    Resource.Status.LOADING -> {
//
//                    }
//                }
//            })
    }

    private fun initialData() {
//        viewModel.getOrderList(null, null, 1, LIMIT, null, status)
//            .observe(viewLifecycleOwner, Observer {
//                when (it?.status) {
//                    Resource.Status.SUCCESS -> {
////                        var list = ArrayList<OrderModel>()
//                        orderList.clear()
//                        val orderLisModel: OrderListModel = it.data!!
//
//                        val gson = Gson()
////                        val response= gson.toJson(orderLisModel)
//
//                        if (orderLisModel!!.items != null) {
//                            for (item in orderLisModel?.items!!) {
////                                Log.d("orderDate","date: "+item.createdAt);
//                                orderList.add(
//                                    OrderModel(
//                                        item.order_parcels._id,
//                                        item.order_parcels.order_parcel_code,
//                                        item.createdAt,
//                                        item.customer_name,
//                                        item.customer_phone,
//                                        item.order_parcels.selected_shipping_option,
//                                        item.order_parcels.parcel_shipping_cost,
//                                        "shipping time",
//                                        item.payment_method.name,
//                                        item.payment_status,
//                                        item.order_parcels.parcel_grand_total,
//                                        item.order_parcels.status,
//                                        false
//                                    )
//                                )
//                            }
//                        }
//
//                        progressbar.visibility = View.GONE
//                        paginationAdapter.addAll(orderList)
//
//                        currentPage = orderLisModel!!.pagination.page
//                        TOTAL_PAGES = orderLisModel!!.pagination.totalPages
//
//                        if (currentPage < TOTAL_PAGES) {
//                            paginationAdapter.addLoadingFooter()
//                        } else {
//                            isLastPage = true
//                        }
//
////                        orderAdapter.notifyDataSetChanged()
//
//                    }
//                    Resource.Status.ERROR -> {
//                        it.isNetworkError?.let { it1 ->
//                            if (it1) {
//                                Toast.makeText(
//                                    requireContext(),
//                                    "No Connection",
//                                    Toast.LENGTH_SHORT
//                                )
//                                    .show()
//                            }
//                        }
//                    }
//                    Resource.Status.LOADING -> {
//
//                    }
//                }
//            })
    }

}