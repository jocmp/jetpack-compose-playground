/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.ui.core.samples


import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.core.paint
import androidx.ui.foundation.Box
import androidx.ui.foundation.drawBackground
import androidx.ui.geometry.Size
import androidx.ui.graphics.Color
import androidx.ui.graphics.painter.Painter
import androidx.ui.graphics.drawscope.DrawScope
import androidx.ui.layout.padding
import androidx.ui.unit.dp


@Composable
fun PainterModifierSample() {
    class CustomPainter : Painter() {

        override val intrinsicSize: Size
            get() = Size(300.0f, 300.0f)

        override fun DrawScope.onDraw() {
            drawCircle(
                center = center,
                radius = size.minDimension / 2.0f,
                color = Color.Red
            )
        }
    }

    Box(
        modifier =
            Modifier.drawBackground(Color.Gray)
                .padding(30.dp)
                .drawBackground(Color.Yellow)
                .paint(CustomPainter())
    ) { /** intentionally empty **/ }
}