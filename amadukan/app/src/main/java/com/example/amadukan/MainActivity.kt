package com.example.amadukan

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get

class MainActivity : AppCompatActivity() {

    lateinit var productList: ArrayList<user>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val PNameList= arrayOf("Cap","Head Phone","Bag","Shoes","watch")
        val PPriceList= arrayOf("$10","$5","$12","$7","$18")
        val PRatingList= arrayOf("***","****","**","****","***")
        val PImgList= intArrayOf(R.drawable.cap_pic,R.drawable.headphone_pic,R.drawable.bag_pic,R.drawable.shoes_pic,R.drawable.watch_pic)
        val PDescList= arrayOf("Rock your style with our caps. Whether you're channeling beach vibes with a floppy straw number or keeping it classic with a curved-brim baseball hat, we've got the perfect topper for your next adventure.",
            "mmerse yourself in crystal-clear audio with our headphones.  Noise-cancelling for focus, wireless for freedom, and mega bass for those heart-pumping playlists - we have the perfect pair to soundtrack your life.",
            " Ditch the boring tote! Our bags come in all shapes, sizes, and colours to match your unique style.  Need a sleek backpack for conquering your commute? A roomy weekender for weekend getaways? Or a trendy crossbody for nights out? We've got your back. ",
            " Life's a journey, so walk it (or run it!) in style with our shoes.  From comfy sneakers for everyday errands to sleek trainers for hitting the gym, we've got footwear that combines function and fashion seamlessly.",
            "Our watches aren't just about keeping time, they're about making a statement.  Bold and colourful, minimalist and chic, or sporty and functional -  find the watch that complements your personal style and keeps you on track for whatever life throws your way.")

        productList= ArrayList()
        for (i in PNameList.indices){
            val product= user(PNameList[i],PPriceList[i],PRatingList[i],PImgList[i],PDescList[i])
            productList.add(product)
        }

        val listView= findViewById<ListView>(R.id.listView)
        listView.adapter=MyAdapater(this, productList)
        listView.setOnItemClickListener { parent, view, position, id ->
            var name=productList[position].name
            var price=productList[position].price
            var rating=productList[position].rating
            var imgid=productList[position].imagId
            var desc=productList[position].desc
           val intent= Intent(this,MainActivity2::class.java)
            intent.putExtra("name",name)
            intent.putExtra("price",price)
            intent.putExtra("rating",rating)
            intent.putExtra("desc",desc)
            intent.putExtra("imgid",imgid)
            startActivity(intent)

        }

    }
}