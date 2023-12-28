package com.example.cryptotest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotest.models.remote.coinDetails.Crypto
import com.example.cryptotest.models.remote.coinRates.CoinRateDto
import com.example.cryptotest.models.remote.coinRates.Rates

class MyAdapter(private var coind:List<Rates>):RecyclerView.Adapter<MyAdapter.viewHolder>() {





    inner class viewHolder(view:View):RecyclerView.ViewHolder(view){
        val coinLayout: LinearLayout = view.findViewById(R.id.coinLinearLayout)
        // coinImage: ImageView = view.findViewById(R.id.imgCoinImage)
        val coinName: TextView = view.findViewById(R.id.txtCoinName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recycler_item,parent,false)
        return viewHolder(view)

    }

    override fun getItemCount(): Int {
            return coind.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
            var coinDeails=coind
        holder.coinName.text=coinDeails.toString()

    }
}