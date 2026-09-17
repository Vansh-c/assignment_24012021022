package com.example.assignment_24012021022

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

data class MusicItem(val title: String, var imageRes: Int, var audioRes: Int)

class MusicAdapter(private var musicList: List<MusicItem>) : RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {

    private var mediaPlayer: MediaPlayer? = null
    private var isLooping = false
    private var isPlaying = false

    // Track WHICH song is currently playing (-1 means nothing)
    private var currentPlayingPosition = -1
    private var currentLoopingPosition = -1  // this tracks which song is looping currently .

    class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var musicPhoto: ImageView = itemView.findViewById<ImageView>(R.id.img)
        val title: TextView = itemView.findViewById<TextView>(R.id.tv)
        val btn1: FloatingActionButton = itemView.findViewById<FloatingActionButton>(R.id.btn1)
        val btn2: FloatingActionButton = itemView.findViewById<FloatingActionButton>(R.id.btn2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MusicViewHolder(view)
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val song = musicList[position]

        holder.musicPhoto.setImageResource(song.imageRes)
        holder.title.text = song.title

        // Update icon based on whether THIS specific row is playing
        if (position == currentPlayingPosition && isPlaying) {
            holder.btn1.setImageResource(R.drawable.double_bar)
        } else {
            holder.btn1.setImageResource(R.drawable.arrow_left)
        }

        // Play / Pause Click
        holder.btn1.setOnClickListener {
            val clickedPos = holder.adapterPosition

            if (currentPlayingPosition == clickedPos) {
                // SAME SONG CLICKED: Just toggle Play / Pause
                if (isPlaying) {
                    mediaPlayer?.pause()
                    isPlaying = false
                    holder.btn1.setImageResource(R.drawable.arrow_left)
                } else {
                    mediaPlayer?.start()
                    isPlaying = true
                    holder.btn1.setImageResource(R.drawable.double_bar)
                }
            } else {
                // DIFFERENT SONG CLICKED: Stop old song, switch to new song!
                val oldPosition = currentPlayingPosition

                // 1. Release previous MediaPlayer
                mediaPlayer?.stop()
                mediaPlayer?.release()
                mediaPlayer = null

                // 2. Start the new song
                currentPlayingPosition = clickedPos
                mediaPlayer = MediaPlayer.create(holder.itemView.context, song.audioRes)
                isLooping = (currentLoopingPosition == clickedPos)
                mediaPlayer?.isLooping = isLooping
                mediaPlayer?.start()
                isPlaying = true

                // When song finishes
                mediaPlayer?.setOnCompletionListener {
                    if (!isLooping) {
                        isPlaying = false
                        currentPlayingPosition = -1
                        notifyItemChanged(clickedPos)
                    }
                }

                // 3. Refresh old row (to show play icon) and new row (to show pause icon)
                if (oldPosition != -1) {
                    notifyItemChanged(oldPosition)
                }
                notifyItemChanged(clickedPos)
            }
        }

        // Replay / Loop Toggle

        if (position == currentLoopingPosition) {
            holder.btn2.setImageResource(R.drawable.replay)
        } else {
            holder.btn2.setImageResource(R.drawable.loop_inactive)
        }

        holder.btn2.setOnClickListener {
            val clickedPos = holder.adapterPosition

            if (currentLoopingPosition == clickedPos) {
                currentLoopingPosition = -1
                isLooping = false
                if (currentPlayingPosition == clickedPos) {
                    mediaPlayer?.isLooping = false
                }
                // loop is off: show inactive icon
                holder.btn2.setImageResource(R.drawable.loop_inactive)
            } else {
                val oldLoopPosition = currentLoopingPosition
                currentLoopingPosition = clickedPos
                isLooping = true

                if (currentPlayingPosition == clickedPos) {
                    mediaPlayer?.isLooping = true
                }

                // looping ON: show replay icon and start from beginning.
                holder.btn2.setImageResource(R.drawable.replay)

                if (oldLoopPosition != -1) {
                    notifyItemChanged(oldLoopPosition)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return musicList.size
    }

    // this is called in MainActivity in  OnDestroy() function
    fun releasePlayer() {
        mediaPlayer?.release()
        mediaPlayer = null
    }
}