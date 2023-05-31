package uz.gita.multiviewcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.multiviewcompose.ui.theme.MultiViewComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiViewComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 16.dp),
        content = {
            items(Constants.dataList) { data ->
                when (data) {
                    is Data.Text -> {
                        TextType(str = data.txt)
                    }

                    is Data.Image -> {
                        ImageType(img = data.img, str = data.txt)
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        })
}

@Composable
fun TextType(str: String) {
    Text(
        modifier = Modifier
            .border(1.dp, color = Color.Blue, RoundedCornerShape(8.dp))
            .padding(16.dp)
            .fillMaxSize(),
        text = str
    )
}

@Composable
fun ImageType(img: Int, str: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, color = Color.Blue, shape = RoundedCornerShape(8.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(shape = ShapeDefaults.Medium),
            painter = painterResource(id = img),
            contentDescription = null
        )
        Text(modifier = Modifier.padding(start = 16.dp), text = str)
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    MultiViewComposeTheme {
        Greeting()
    }
}