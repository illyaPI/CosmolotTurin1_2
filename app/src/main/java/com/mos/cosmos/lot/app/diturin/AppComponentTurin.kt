package com.mos.cosmos.lot.app.diturin

import com.mos.cosmos.lot.app.importantturin.applicationturin.WebViewApplicationTurin
import com.mos.cosmos.lot.app.repositoryturin.activitiesturin.LoadingActivityTurin
import com.mos.cosmos.lot.app.repositoryturin.activitiesturin.WebViewActivityTurin
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RepositoryModuleTurin::class])
interface AppComponentTurin {

  fun injectTurin(applicationTurin: WebViewApplicationTurin)
  fun injectTurin(activityTurin: LoadingActivityTurin)
  fun injectTurin(activityTurin: WebViewActivityTurin)
}