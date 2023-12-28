package com.example.cryptotest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotest.api.ApiUtilities
import com.example.cryptotest.api.apiInterface
import com.example.cryptotest.models.remote.coinDetails.Coin
import com.example.cryptotest.models.remote.coinDetails.CoinDetailDto
import com.example.cryptotest.models.remote.coinRates.CoinRateDto
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var coinAdapter: MyAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var coinRecyclerView: RecyclerView

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        coinRecyclerView = findViewById(R.id.coinRecyclerView)
        coinRecyclerView.layoutManager = LinearLayoutManager(this)

        GlobalScope.launch(Dispatchers.IO) {
            val coinResult = ApiUtilities.getInstance().create(apiInterface::class.java)
                .getAllCoin(ApiUtilities.apiKey)
            val rateResult = ApiUtilities.getInstance().create(apiInterface::class.java)
                .getCoinRate(ApiUtilities.apiKey)

            val coins = coinResult.body()
            val rates = rateResult.body()

            combineResponses(
                coinDetailDto = coins,
                coinRateDto = rates
            ).forEach {
                println("Name: ${it.coin.name}")
                println("Icon: ${it.coin.icon_url}")
                println("Name: ${it.rate}")
            }
        }
    }
}

fun combineResponses(
    coinDetailDto: CoinDetailDto?,
    coinRateDto: CoinRateDto?
): List<CombinedCoinInfo> {
    val combinedList = mutableListOf<CombinedCoinInfo>()

    if (coinDetailDto?.success == true && coinRateDto?.success == true) {
        val cryptoMap = coinDetailDto.crypto
        val ratesMap = coinRateDto.rates

        for ((symbol, coin) in cryptoMap) {
            val rate = ratesMap[symbol]
            if (rate != null) {
                val combinedInfo = CombinedCoinInfo(coin, rate)
                combinedList.add(combinedInfo)
            }
        }
    }

    return combinedList
}

data class CombinedCoinInfo(
    val coin: Coin,
    val rate: Double
)
