package br.com.qi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.ListView
import androidx.core.view.get
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
            Produto(1L, "Feijão 1Kg", 2.69),
            Produto(2L, "Leite", 2.70),
            Produto(3L, "Macarrão", 16.70),
            Produto(4L, "Farofa", 3.38),
            Produto(5L, "Refrigerante", 3.00),
            Produto(6L, "Batata-frita", 5.00)
        )

        listViewItens.adapter = AdapterProduto(listaProduto, this)

        listViewItens
    }
}
