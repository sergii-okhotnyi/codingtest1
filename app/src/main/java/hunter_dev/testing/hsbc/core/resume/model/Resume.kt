package hunter_dev.testing.hsbc.core.resume.model

import com.google.gson.annotations.SerializedName

/**
 * Resume DTO model
 */
data class Resume(
    @SerializedName("full_name") val fullName: String,
    @SerializedName("email") val email: String? = null,
    @SerializedName("phone") val phone: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("photo_url") val photoUrl: String? = null,
    @SerializedName("summary") val summary: List<String>? = null,
    @SerializedName("topics") val topics: List<String>? = null,
    @SerializedName("experience") val experience: List<Experience>? = null
)

/**
 * Resume.Work experience DTO model
 */
data class Experience(
    @SerializedName("company_name") val companyName: String?,
    @SerializedName("role") val role: String?,
    @SerializedName("period") val period: String?,
    @SerializedName("description") val description: List<String>?,
    @SerializedName("logo_url") val logoUrl: String?
)