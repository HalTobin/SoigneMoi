package feature.login.presentation

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import ui.Screen
import ui.theme.SoigneMoiTheme
import ui.util.rememberNavController

@Preview
@Composable
fun LoginScreenPreview() = SoigneMoiTheme {
    val navController by rememberNavController(Screen.Login.route)
    LoginScreen(
        navController = navController,
        state = LoginState(),
        onEvent = {},
        uiEvent = MutableSharedFlow<LoginController.UiEvent>().asSharedFlow()
    )
}