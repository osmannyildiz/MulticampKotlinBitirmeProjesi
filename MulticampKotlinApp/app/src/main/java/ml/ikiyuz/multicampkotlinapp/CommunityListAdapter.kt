package ml.ikiyuz.multicampkotlinapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import coil.load
import kotlinx.android.synthetic.main.item_community_list.view.*
import ml.ikiyuz.multicampkotlinapp.data.model.Community

class CommunityListAdapter(
    val communityList: List<Community>,
    val navController: NavController
) : RecyclerView.Adapter<CommunityListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_community_list, parent, false)
        val vh = CommunityListViewHolder(view)
        return vh
    }

    override fun onBindViewHolder(holder: CommunityListViewHolder, position: Int) {
        val community = communityList[position]
        holder.bind(community)
        holder.view.setOnClickListener {
            val destination = CommunityListFragmentDirections.actionViewCommunityDetail(
                // I couldn't manage to send a Community object or a Map, so...
                community.name,
                community.description,
                community.banner,
                community.leader.name,
                community.leader.photo,
                community.links.twitter,
                community.links.instagram,
                community.links.youtube,
                community.links.participation
            )
            navController.navigate(destination)
        }
    }

    override fun getItemCount(): Int {
        return communityList.size
    }
}

class CommunityListViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(community: Community) {
        view.imageViewListBanner.load(community.banner)
    }
}