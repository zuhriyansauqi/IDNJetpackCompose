package media.idn.idnjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import media.idn.compose.R
import media.idn.compose.components.IDNBottomSheet
import media.idn.compose.components.IDNButton
import media.idn.compose.components.IDNIllustrationInfo
import media.idn.compose.ui.IDNTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val modalBottomSheetState =
                rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
            val scope = rememberCoroutineScope()
            IDNTheme {
                ModalBottomSheetLayout(
                    sheetContent = {
                        IDNBottomSheet(
                            type = IDNBottomSheet.SingleButton(
                                text = "Tutup",
                                onClick = {
                                    scope.launch {
                                        modalBottomSheetState.hide()
                                    }
                                }
                            ),
                        ) {
                            IDNIllustrationInfo(
                                title = "Kode referral sudah berhasil digunakan",
                                subtitle = "Yuk selesaikan misi dan dapatkan reward lebih",
                                cover = R.drawable.illustration_point
                            )
                        }
                    },
                    sheetState = modalBottomSheetState,
                    sheetBackgroundColor = IDNTheme.colors.surface,
                    sheetShape = IDNTheme.shapes.bottomSheet,
                ) {
                    Scaffold(backgroundColor = IDNTheme.colors.surface) {
                        MainScreen(scope = scope, state = modalBottomSheetState)
                    }
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(scope: CoroutineScope, state: ModalBottomSheetState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(IDNTheme.colors.surface),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        IDNButton(
            onClick = {
                scope.launch {
                    state.show()
                }
            },
            large = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(
                text = "Click me!",
                style = IDNTheme.typography.button
            )
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun MainScreenPreview() {
    val modalBottomSheetState =
        rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    IDNTheme {
        MainScreen(scope = scope, state = modalBottomSheetState)
    }
}
