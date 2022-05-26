package com.asad.composy

import androidx.annotation.IntDef
import com.asad.composy.HomeActivity.Companion.MULTI_SELECTION_EVENT
import com.asad.composy.HomeActivity.Companion.SINGLE_SELECTION_EVENT

/**
 * @Author: Asad Mukhtar
 * @Date: 11/4/22
 */
@Target(AnnotationTarget.TYPE)
@IntDef(
    SINGLE_SELECTION_EVENT,
    MULTI_SELECTION_EVENT
)
annotation class ClickEvents
