package ml.ikiyuz.multicampkotlinapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import kotlinx.android.synthetic.main.fragment_community_list.*
import ml.ikiyuz.multicampkotlinapp.data.RetrofitProvider
import ml.ikiyuz.multicampkotlinapp.data.model.Community

class CommunityListFragment : Fragment(R.layout.fragment_community_list) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Text on the top bar
        activity?.title = getString(R.string.str_communities)

        lifecycleScope.launchWhenStarted {
            progressBarListLoading.visibility = View.VISIBLE

            val communityList : List<Community> = RetrofitProvider.myApi.getCommunities()
            val communityListAdapter = CommunityListAdapter(communityList, findNavController())
            recyclerViewCommunityList.adapter = communityListAdapter
            recyclerViewCommunityList.addItemDecoration(
                DividerItemDecoration(
                    recyclerViewCommunityList.context,
                    DividerItemDecoration.VERTICAL
                )
            )

            progressBarListLoading.visibility = View.GONE
        }
    }
}