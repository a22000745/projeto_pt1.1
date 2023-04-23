package pt.ulusofona.deisi.cm2223.app

import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pt.ulusofona.deisi.cm2223.app.databinding.ItemMovieBinding

class MovieAdapter (private val onMovieClick: (Int) -> Unit,private var items: List<Movie> = listOf()) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.itemView.setOnClickListener{onMovieClick(position) }
        holder.binding.lObsevacoes?.text = items[position].observacoes
        holder.binding.lData?.text = items[position].getData()
        holder.binding.lFilme.text = items[position].nome
        holder.binding.lCinema.text = items[position].cinema
        holder.binding.lAvaliacao.text = items[position].avaliacao.toString()
    }
    override fun getItemCount() = items.size
    fun updateItems(items: List<Movie>){
        this.items = items
        notifyDataSetChanged()
    }

}
