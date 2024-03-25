package com.example.m4movies

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var myRecyclerView: RecyclerView
    lateinit var movieList: ArrayList<Data>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        myRecyclerView=findViewById(R.id.RV)

        var posters = arrayOf(R.drawable.captain_1,R.drawable.captain_2,R.drawable.captain_3,
            R.drawable.iron_1,R.drawable.iron_2,R.drawable.iron_3,R.drawable.thor_1,R.drawable.thor_2,
            R.drawable.thor_3,R.drawable.thor_4)
        var titles = arrayOf("Captain America: The First Avenger","Captain America: The Winter Soldier ","Captain America: Civil War",
            "Iron Man","Iron Man 2 ","Iron Man 3",
            "Thor","Thor: The Dark World","Thor: Ragnarok","Thor: Love and Thunder")
        var year= arrayOf("2011","2014","2016","2008","2010","2013","2011","2013","2017","2022")
        var more= arrayOf("This film chronicles Steve Rogers' transformation into Captain America during World War II and his fight against the villainous Red Skull.","Captain America and Black Widow team up to battle a mysterious new enemy while S.H.I.E.L.D. is compromised.","The Avengers fracture when a global conflict arises over government oversight of superheroes.\n",
            "Playboy billionaire Tony Stark becomes Iron Man after a kidnapping incident forces him to create a powerful armored suit."," Tony Stark struggles to balance his duties as Iron Man with his declining health while facing a new villain.","Tony Stark grapples with PTSD and a mysterious enemy who attacks his personal life.",
            "Thor is banished to Earth by his father Odin for his arrogance. While on Earth, Thor learns what it takes to be a true hero.","Thor and Jane Foster return to Asgard to battle a new enemy who threatens to plunge the Nine Realms into darkness.","Thor is imprisoned on a distant planet without his hammer Mjolnir. To escape Sakaar, he must participate in a gladiatorial contest against the Hulk.","Thor embarks on a new journey to find inner peace, but must team up with Valkyrie, Korg, and his ex-girlfriend Jane Foster (now wielding the power of Mjolnir) to stop Gorr the God Butcher from eliminating all gods.")

        myRecyclerView.layoutManager=LinearLayoutManager(this)
        movieList= arrayListOf()
        for (i in posters.indices){
            val movie=Data(posters[i], titles[i], year[i], more[i])
            movieList.add(movie)
        }

        val adapter= MyAdapter(movieList, this)
        myRecyclerView.adapter=adapter
        adapter.setItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@MainActivity,"hii",Toast.LENGTH_SHORT).show()
                val intent =Intent(this@MainActivity, MainActivity2 ::class.java)
                intent.putExtra("poster", posters[position])
                intent.putExtra("title", titles[position])
                intent.putExtra("year", year[position])
                intent.putExtra("more", more[position])
                startActivity(intent)
            }

        })
    }
}