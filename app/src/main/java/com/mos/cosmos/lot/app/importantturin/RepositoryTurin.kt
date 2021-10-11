package com.mos.cosmos.lot.app.importantturin

import com.mos.cosmos.lot.app.importantturin.modelsturin.BinomLinkTurin

interface RepositoryTurin {

  var binomLinkTurin: BinomLinkTurin?
  var whiteBaseTurin: String
  var blackBaseTurin: String?
  var defaultKeyTurin: String

  var lastBinomLinkTurin: String?
}