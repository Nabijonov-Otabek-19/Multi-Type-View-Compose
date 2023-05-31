package uz.gita.multiviewcompose

sealed interface Data {
    data class Text(val txt: String): Data
    data class Image(val img: Int, val txt: String): Data
}