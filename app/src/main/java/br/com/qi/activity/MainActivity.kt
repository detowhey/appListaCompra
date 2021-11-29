package br.com.qi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.forEach
import br.com.qi.R
import br.com.qi.adapter.AdapterProduto
import br.com.qi.model.Produto

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listViewItens = findViewById<ListView>(R.id.listViewItens)
        val btnComprar = findViewById<Button>(R.id.btnComprar)

        val listaProduto = listOf(
            Produto(1L, "Feijão 1Kg", 2.69, 0),
            Produto(2L, "Leite", 2.70, 0),
            Produto(3L, "Macarrão", 16.70, 0),
            Produto(4L, "Farofa", 3.38, 0),
            Produto(5L, "Refrigerante", 3.00, 0),
            Produto(6L, "Batata-frita", 5.00, 0)
        )

        listViewItens.adapter = AdapterProduto(listaProduto, this)

        btnComprar.setOnClickListener {

            val listaPreco = mutableListOf<Double>()

            listViewItens.forEach {
                if (it.findViewById<TextView>(R.id.txtQuantidade).text.toString().toInt() != 0) {
                    listaPreco.add(
                        it.findViewById<TextView>(R.id.txtPreco).text.toString().replace(",", ".")
                            .substring(
                                startIndex = 2,
                                endIndex = findViewById<TextView>(R.id.txtPreco).text.toString().lastIndex
                            )
                            .toDouble()
                    )
                }
            }

            var precoTotal = 0.0
            listaPreco.forEach { numero -> precoTotal += numero }

            Toast.makeText(
                this,
                "Valor total: R$ ${String.format("%.2f", precoTotal).replace(".", ",")}",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
