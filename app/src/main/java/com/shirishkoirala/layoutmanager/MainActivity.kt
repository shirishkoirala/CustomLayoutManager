package com.shirishkoirala.layoutmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.rv_list)

        recyclerView.adapter = ListItemAdapter(
            listOf(
                ListItem(
                    1,
                    "Jaws",
                    "When a killer shark unleashes chaos on a beach community off Cape Cod, it's up to a local sheriff, a marine biologist, and an old seafarer to hunt the beast down.",
                    R.drawable.jaws
                ),
                ListItem(
                    2,
                    "Back to the Future (1985)",
                    "Marty McFly, a 17-year-old high school student, is accidentally sent 30 years into the past in a time-traveling DeLorean invented by his close friend, the maverick scientist Doc Brown.",
                    R.drawable.back_to_the_future
                ),
                ListItem(
                    3,
                    "Goodfellas",
                    "The story of Henry Hill and his life in the mafia, covering his relationship with his wife Karen and his mob partners Jimmy Conway and Tommy DeVito.",
                    R.drawable.good_fellas
                ),
                ListItem(
                    4,
                    "The Matrix (1999)",
                    "When a beautiful stranger leads computer hacker Neo to a forbidding underworld, he discovers the shocking truth--the life he knows is the elaborate deception of an evil cyber-intelligence.",
                    R.drawable.matrix
                ),
                ListItem(
                    5,
                    "Pulp Fiction (1994)",
                    "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
                    R.drawable.pulp_fiction
                ),
                ListItem(
                    5,
                    "The Shawshank Redemption (1994)",
                    "A Maine banker convicted of the murder of his wife and her lover in 1947 gradually forms a friendship over a quarter century with a hardened convict, while maintaining his innocence and trying to remain hopeful through simple compassion.",
                    R.drawable.shawshank_redemption
                ),
                ListItem(
                    5,
                    "Star Wars: Episode IV - A New Hope",
                    "Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a Wookiee and two droids to save the galaxy from the Empire's world-destroying battle station, while also attempting to rescue Princess Leia from the mysterious Darth Vader.",
                    R.drawable.star_wars
                ),
            )
        )

        recyclerView.layoutManager =
            CustomLayoutManager(this, CustomLayoutManager.HORIZONTAL, false)
        LoopingSnapHelper().attachToRecyclerView(recyclerView)
        recyclerView.setHasFixedSize(true)
    }
}