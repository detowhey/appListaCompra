package br.com.qi.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import br.com.qi.R
import br.com.qi.model.Produto

class AdapterProduto(private val listaProduto: List<Produto>, private val activity: Activity) :
    BaseAdapter() {

    override fun getCount(): Int {
        return listaProduto.size
    }

    override fun getItem(position: Int): Any {
        return listaProduto[position]
    }

    override fun getItemId(position: Int): Long {
        return listaProduto[position].id
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = activity.layoutInflater.inflate(R.layout.list_view_item_lista, parent, false)
        val produto = listaProduto[position]
        val txtPreco = view.findViewById<TextView>(R.id.txtPreco)
        val txtQuantidade = view.findViewById<TextView>(R.id.txtQuantidade)

        val iconAdd = view.findViewById<ImageButton>(R.id.iconAdd)
        val iconRemove = view.findViewById<ImageButton>(R.id.iconRemove)

        view.findViewById<TextView>(R.id.txtNomeProduto).text = produto.nome
        txtPreco.text = formatarValorPreco(produto.preco)

        iconAdd.setOnClickListener {
            val preco = produto.preco
            val quantidade = txtQuantidade.text.toString().toInt() + 1

            txtQuantidade.text = quantidade.toString()
            txtPreco.text = formatarValorPreco(preco * quantidade)
        }

        iconRemove.setOnClickListener {
            var quantidade = txtQuantidade.text.toString().toInt()

            if (quantidade == 0)
                return@setOnClickListener

            val preco = produto.preco
            quantidade -= 1

            txtQuantidade.text = quantidade.toString()
            txtPreco.text = formatarValorPreco(preco * quantidade)
        }
        return view
    }

    private fun formatarValorPreco(preco: Double): String {
        return "R$ ${String.format("%.2f", preco).replace(".", ",")}"
    }
}
