package com.senai.carterinha.feature.carterinha.presentation.component

import android.graphics.Bitmap
import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.createBitmap
import androidx.core.graphics.set
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.qrcode.QRCodeWriter

@Composable
fun QrCode(
    conteudo: String,
    modifier: Modifier = Modifier
) {
    val bitmap = gerarQrCode(conteudo)

    // O QR Code em si continua preto sobre branco (é assim que ele é
    // confiavelmente legível); a moldura verde por fora é o que integra ao
    // visual "terminal" do restante da carteirinha.
    Image(
        bitmap = bitmap.asImageBitmap(),
        contentDescription = "QR Code",
        modifier = modifier
            .size(160.dp)
            .border(width = 1.dp, color = MaterialTheme.colorScheme.primary)
            .background(androidx.compose.ui.graphics.Color.White)
            .padding(8.dp)
    )
}


fun gerarQrCode(
    conteudo: String,
    tamanho: Int = 512,
    margem: Int = 1
): Bitmap {

    val hints = mapOf(
        EncodeHintType.MARGIN to margem
    )

    val writer = QRCodeWriter()
    val bitMatrix = writer.encode(
        conteudo,
        BarcodeFormat.QR_CODE,
        tamanho,
        tamanho,
        hints
    )

    val bitmap = createBitmap(tamanho, tamanho)

    for (x in 0 until tamanho) {
        for (y in 0 until tamanho) {
            bitmap[x, y] = if (bitMatrix[x, y]) Color.BLACK else Color.WHITE
        }
    }

    return bitmap
}

@Preview(showBackground = true)
@Composable
fun QrCodePreviewClaro() {
    QrCode("25162248")
}