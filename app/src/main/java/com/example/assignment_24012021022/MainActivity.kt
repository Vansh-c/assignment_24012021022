package com.example.assignment_24012021022

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private var myadapter: MusicAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        // starts from here we are making object  basically and all object have same properties .
        var musicList = ArrayList<MusicItem>()
        musicList.add(MusicItem("War" , R.drawable.hritik_roshan , R.raw.kabir_theme))
        musicList.add(MusicItem("Hero's \nJourney" , R.drawable.shadow_fight,  R.raw.hero_journey))
        musicList.add(MusicItem("Bang Bang" , R.drawable.bang_bang , R.raw.bang_bang))
        musicList.add(MusicItem("aasman se\naaya farishta", R.drawable.even_in_parise , R.raw.aasman_se))
        musicList.add(MusicItem("Luffy's\nfierce attack" , R.drawable.luffy, R.raw.luffy))
        musicList.add(MusicItem("Ghunghroo" , R.drawable.ghungroo , R.raw.ghungroo))

        var recyclerView = findViewById<RecyclerView>(R.id.rv)
        myadapter = MusicAdapter(musicList)
        recyclerView.adapter = myadapter
    }

    override fun onDestroy() {
        super.onDestroy()
        myadapter?.releasePlayer()
    }
}