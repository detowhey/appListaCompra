package br.com.qi.adapter

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
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

        view.findViewById<TextView>(R.id.txtNomeProduto).text = produto.nome
        view.findViewById<TextView>(R.id.txtQuantidade).text = String.format("%.2f",  produto.preco).replace(".", ",")
        return view
    }
}
