package hunter_dev.testing.hsbc.core

import android.content.Context
import android.content.Intent
import android.net.Uri

fun sendEmail(context: Context, email: String) {
    context.startActivity(
        Intent(Intent.ACTION_SENDTO).setData(Uri.parse("mailto:{$email}"))
    )
}

fun makeCall(context: Context, phone: String) {
    context.startActivity(
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel::{$phone}"))
    )
}