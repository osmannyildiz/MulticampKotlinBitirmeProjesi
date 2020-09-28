package ml.ikiyuz.multicampkotlinapp.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Community(
    val name: String,
    val description: String,
    val banner: String,
    val leader: CommunityLeader,
    val links: CommunityLinks
)

@Serializable
data class CommunityLeader(
    val name: String,
    val photo: String
)

@Serializable
data class CommunityLinks(
    val twitter: String,
    val instagram: String,
    val youtube: String,
    val participation: String
)
