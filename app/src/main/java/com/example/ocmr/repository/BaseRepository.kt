package com.example.ocmr.repository

import com.example.ocmr.service.OcmrService
import javax.inject.Inject

/**
 * Created by BM Anderson on 18/01/2022.
 */
class BaseRepository @Inject constructor(
    val ocmrService: OcmrService
) {
}