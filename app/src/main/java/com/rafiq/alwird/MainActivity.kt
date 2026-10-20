package com.rafiq.alwird

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import com.rafiq.alwird.ui.theme.RafiqTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RafiqTheme {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) { AppRoot() }
            }
        }
    }
}

private val tabs = listOf("الرئيسية", "القرآن", "الأذكار", "الإحصائيات")

@Composable
fun AppRoot() {
    var selected by remember { mutableIntStateOf(0) }
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.background) {
                tabs.forEachIndexed { i, label ->
                    NavigationBarItem(selected = selected == i, onClick = { selected = i },
                        icon = {}, label = { Text(label) }, alwaysShowLabel = true)
                }
            }
        },
    ) { pad ->
        Box(Modifier.padding(pad).fillMaxSize(), contentAlignment = Alignment.Center) {
            // مكان مؤقت: الشاشات الحقيقية تُبنى في المرحلة 3
            Text("${tabs[selected]} — قيد البناء", color = MaterialTheme.colorScheme.onBackground)
        }
    }
}
