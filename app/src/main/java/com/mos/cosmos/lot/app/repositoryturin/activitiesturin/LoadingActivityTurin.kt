package com.mos.cosmos.lot.app.repositoryturin.activitiesturin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.mos.cosmos.lot.app.databinding.ActivityLoadingTurinBinding
import com.mos.cosmos.lot.app.importantturin.RepositoryTurin
import com.mos.cosmos.lot.app.importantturin.applicationturin.WebViewApplicationTurin
import com.mos.cosmos.lot.app.repositoryturin.viewbindingturin.ViewBindingActivityTurin
import kotlinx.coroutines.delay
import javax.inject.Inject

class LoadingActivityTurin : ViewBindingActivityTurin<ActivityLoadingTurinBinding>(ActivityLoadingTurinBinding::inflate) {

  @Inject lateinit var repositoryTurin: RepositoryTurin

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    injectTurin()
    if (repositoryTurin.lastBinomLinkTurin != null) {
      startActivity(Intent(this, WebViewActivityTurin::class.java))
      finish()
    }
    lifecycleScope.launchWhenCreated {
      delay(SETUP_DELAY_TURIN)
      setupFirebaseTurin()
    }
  }

  private fun setupFirebaseTurin() {
    val firebaseConfigTurin = FirebaseRemoteConfig.getInstance()
    firebaseConfigTurin.fetchAndActivate().addOnCompleteListener(this) {
      val whiteBaseTurin = firebaseConfigTurin.getString(WHITE_BASE_TURIN)
      val blackBaseTurin = firebaseConfigTurin.getString(BLACK_BASE_TURIN).ifEmpty { null }
      val defaultKeyTurin = firebaseConfigTurin.getString(DEFAULT_KEY_TURIN)

      repositoryTurin.whiteBaseTurin = whiteBaseTurin
      repositoryTurin.blackBaseTurin = blackBaseTurin
      repositoryTurin.defaultKeyTurin = defaultKeyTurin

      startActivity(Intent(this, WebViewActivityTurin::class.java))
      finish()
    }
  }

  private fun injectTurin(): Unit = (application as WebViewApplicationTurin).appComponentTurin.injectTurin(this)

  companion object {

    private const val TAG_TURIN: String = "LoadingActivity"

    private const val WHITE_BASE_TURIN: String = "moswhitepage"
    private const val BLACK_BASE_TURIN: String = "mosblackpage"
    private const val DEFAULT_KEY_TURIN: String = "mosdefkey"

    private const val SETUP_DELAY_TURIN: Long = 5000L
  }
}