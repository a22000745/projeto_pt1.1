package pt.ulusofona.deisi.cm2223.app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pt.ulusofona.deisi.cm2223.app.databinding.ItemNotificationBinding
import java.util.Calendar

class NotificationAdapter(private var items: List<Notification> = listOf()): RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    class NotificationViewHolder(val binding: ItemNotificationBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder{
        return NotificationViewHolder(
            ItemNotificationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.binding.nFilme.text = items[position].filme
        holder.binding.nData.text= items[position].getData()
    }

    override fun getItemCount() = items.size


    fun updateItems(items: List<Notification>) {
        for(notification in items){
            if (notification.dataEstreia.before(Calendar.getInstance())){
                Notifications.removeNotification(notification)
            }
        }
        this.items = items
        notifyDataSetChanged()
    }

}
