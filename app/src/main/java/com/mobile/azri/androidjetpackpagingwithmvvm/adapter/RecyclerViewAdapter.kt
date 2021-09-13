import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mobile.azri.androidjetpackpagingwithmvvm.R
import com.mobile.azri.androidjetpackpagingwithmvvm.adapter.DiffUtilCallback
import com.mobile.azri.androidjetpackpagingwithmvvm.databinding.RecyclerRowItemBinding
import com.mobile.azri.androidjetpackpagingwithmvvm.model.CharacterData

class RecyclerViewAdapter : PagedListAdapter<CharacterData, RecyclerViewAdapter.RecyclerViewHolder>(DiffUtilCallback()){

    private lateinit var bindingHolder : RecyclerRowItemBinding

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        bindingHolder = RecyclerRowItemBinding.inflate(inflater,parent,false)

        return RecyclerViewHolder(bindingHolder)
    }

    class RecyclerViewHolder(binding:RecyclerRowItemBinding): RecyclerView.ViewHolder(binding.root) {
        private val binding = binding
        fun bind(data: CharacterData){
            with(binding){
                binding.tvName.text = data.name.toString()
                binding.tvSpecies.text = data.species.toString()

                val url = data.image
                Glide.with(binding.imgThumb)
                    .load(url)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_background)
                    .into(binding.imgThumb)
            }
        }
    }

}