package com.michaelflisar.composethemer.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.runtime.rememberCoroutineScope
import com.michaelflisar.composedebugdrawer.core.DebugDrawer
import com.michaelflisar.composedebugdrawer.core.rememberDebugDrawerState
import com.michaelflisar.composethemer.ComposeThemerTheme
import com.michaelflisar.composethemer.demo.composables.Content
import com.michaelflisar.composethemer.demo.composables.Drawer
import kotlinx.coroutines.launch

class DemoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {

            val scope = rememberCoroutineScope()
            val drawerState = rememberDebugDrawerState(expandSingleOnly = true)
            BackHandler(drawerState.drawerState.isOpen) {
                scope.launch {
                    drawerState.drawerState.close()
                }
            }

            ComposeThemerTheme {
                DebugDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        Drawer(drawerState)
                    },
                    content = {
                        Content()
                    }
                )
            }
        }
    }
}