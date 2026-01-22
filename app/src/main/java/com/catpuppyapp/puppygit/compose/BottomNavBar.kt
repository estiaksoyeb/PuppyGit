package com.catpuppyapp.puppygit.compose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Difference
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.Folder
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.catpuppyapp.puppygit.constants.Cons
import com.catpuppyapp.puppygit.play.pro.R

@Composable
fun BottomNavBar(
    currentHomeScreen: MutableIntState,
    isVisible: Boolean,
    goToRepoPage: () -> Unit,
    goToChangeListPage: () -> Unit,
    goToEditorPage: () -> Unit,
    goToFilesPage: () -> Unit
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = MaterialTheme.colorScheme.onSurface,
            tonalElevation = 8.dp
        ) {
            // Repos
            NavigationBarItem(
                selected = currentHomeScreen.intValue == Cons.selectedItem_Repos,
                onClick = { 
                    if (currentHomeScreen.intValue != Cons.selectedItem_Repos) {
                        goToRepoPage() 
                    }
                },
                icon = { Icon(Icons.Filled.Inventory, contentDescription = stringResource(R.string.repos)) },
                label = { Text(stringResource(R.string.repos)) }
            )

            // Folders
            NavigationBarItem(
                selected = currentHomeScreen.intValue == Cons.selectedItem_Files,
                onClick = { 
                    if (currentHomeScreen.intValue != Cons.selectedItem_Files) {
                        goToFilesPage() 
                    }
                },
                icon = { Icon(Icons.Filled.Folder, contentDescription = stringResource(R.string.files)) },
                label = { Text(stringResource(R.string.files)) }
            )

            // ChangeList
            NavigationBarItem(
                selected = currentHomeScreen.intValue == Cons.selectedItem_ChangeList,
                onClick = { 
                    if (currentHomeScreen.intValue != Cons.selectedItem_ChangeList) {
                        goToChangeListPage() 
                    }
                },
                icon = { Icon(Icons.Filled.Difference, contentDescription = stringResource(R.string.changelist)) },
                label = { Text(stringResource(R.string.changelist)) }
            )

            // Editor
            NavigationBarItem(
                selected = currentHomeScreen.intValue == Cons.selectedItem_Editor,
                onClick = { 
                    if (currentHomeScreen.intValue != Cons.selectedItem_Editor) {
                        goToEditorPage() 
                    }
                },
                icon = { Icon(Icons.Filled.EditNote, contentDescription = stringResource(R.string.editor)) },
                label = { Text(stringResource(R.string.editor)) }
            )
        }
    }
}
