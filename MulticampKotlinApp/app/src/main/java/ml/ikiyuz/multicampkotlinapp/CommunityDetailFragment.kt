package ml.ikiyuz.multicampkotlinapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import coil.load
import coil.transform.CircleCropTransformation
import kotlinx.android.synthetic.main.fragment_community_detail.*

class CommunityDetailFragment : Fragment(R.layout.fragment_community_detail) {
    val navArgs by navArgs<CommunityDetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Text on the top bar
        activity?.title = navArgs.name

        textViewDescription.text = navArgs.description
        textViewLeaderName.text = navArgs.leaderName

        imageViewBanner.load(navArgs.banner) {
            crossfade(true)
        }
        imageViewLeader.load(navArgs.leaderPhoto) {
            crossfade(true)
            transformations(CircleCropTransformation())
        }

        buttonTwitter.setOnClickListener {
            openLink(navArgs.linksTwitter)
        }
        buttonInstagram.setOnClickListener {
            openLink(navArgs.linksInstagram)
        }
        buttonYoutube.setOnClickListener {
            openLink(navArgs.linksYoutube)
        }
        buttonParticipation.setOnClickListener {
            openLink(navArgs.linksParticipation)
        }
    }

    fun openLink(uri: String) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(uri)))
    }
}