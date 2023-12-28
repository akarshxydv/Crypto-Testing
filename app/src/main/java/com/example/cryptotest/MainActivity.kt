package com.example.cryptotest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotest.api.ApiUtilities
import com.example.cryptotest.api.apiInterface
import com.example.cryptotest.models.local.NewCoinList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var coinAdapter: MyAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var coinRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        coinRecyclerView=findViewById(R.id.coinRecyclerView)
//        coinRecyclerView.layoutManager= LinearLayoutManager(this)

        GlobalScope.launch(Dispatchers.IO) {

            val coinResult = ApiUtilities.getInstance().create(apiInterface::class.java)
                .getAllCoin(ApiUtilities.apiKey)
            val rateResult = ApiUtilities.getInstance().create(apiInterface::class.java)
                .getCoinRate(ApiUtilities.apiKey)
//            if (coinResult.isSuccessful && rateResult.isSuccessful) {
//                val coins = coinResult.body()
//                val rates = rateResult.body()?.rates
//                if (coins != null) {
//                    val coinss = coins.crypto
//
//                    val coinInfoList = coinss.mapNotNull { (symbol, coin) ->
//                        val rate = rates[symbol]
//                        if (rate != null) {
//                            NewCoinList(
//                                symbol = symbol,
//                                name = coin.name,
//                                fullName = coin.name_full,
//                                iconUrl = coin.icon_url,
//                                rate = rate
//                            )
//                        } else {
//                            null
//                        }
//                    }
//                }

            val res= rateResult.body()?.rates

            Log.d("AKA",res.toString())
//            coinAdapter=MyAdapter(res)
//            coinRecyclerView.adapter=coinAdapter
                Log.d("AKA",res.toString())

            }
        }
    }
