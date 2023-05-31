package uz.gita.multiviewcompose


object Constants {
    val dataList = ArrayList<Data>()


    init {
        repeat(5) {
            dataList.add(Data.Text("Text$it"))
            dataList.add(Data.Image(R.drawable.ic_launcher_background, "Image$it"))
        }
        dataList.shuffle()
    }
}