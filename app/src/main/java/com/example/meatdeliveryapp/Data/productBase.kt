package com.example.meatdeliveryapp.Data

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class productBase {

    val categoryNames = listOf("Bread_products", "Vegetables_fruits", "Grocery", "Milk_eggs", "Sweets",
        "Fish", "Meat", "Drinks", "Canned", "Frozen_food",
        "Oil_spices", "Snacks" , "Coffee_tea", "Baby", "Cleaning" , "Medicine" )
    val categoriesRef = Firebase.database.getReference("Categories")

    val categoryRefs = categoryNames.map { categoriesRef.child(it) }

    fun test() {

        val breadRef = categoryRefs[0]
        val vegetablesRef = categoryRefs[1]
        val groceryRef = categoryRefs[2]
        val milkRef = categoryRefs[3]
        val sweetsRef = categoryRefs[4]
        val fishRef = categoryRefs[5]
        val meatRef = categoryRefs[6]
        val drinkRef = categoryRefs[7]
        val cannedRef = categoryRefs[8]
        val frozenRef = categoryRefs[9]
        val oilRef = categoryRefs[10]
        val snacksRef = categoryRefs[11]
        val coffeeRef = categoryRefs[12]
        val babyRef = categoryRefs[13]
        val cleaningRef = categoryRefs[14]
        val medicineRef = categoryRefs[15]

        //Хлебобулочные изделия
        //Хлеб
        breadRef.child("Bread").child("product101").setValue(ProductTest(101,"Хлеб белый", 55,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fhleb1.jpg?alt=media&token=869da003-b851-4156-9dcb-d26b3b4309ab"))
        breadRef.child("Bread").child("product102").setValue(ProductTest(102,"Батон", 48,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-03%20(2).jpg?alt=media&token=4a63c4fa-8f0d-47f6-aaef-690a29cebc75"))
        breadRef.child("Bread").child("product103").setValue(ProductTest(103,"Хлеб серый", 35,
        "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-03%20(3).jpg?alt=media&token=7d729940-22e1-41ba-b829-51fc27d05ff8"))
        breadRef.child("Bread").child("product104").setValue(ProductTest(104,"Хлеб Бородинский", 70,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fborodin.jpg?alt=media&token=aab7e9d2-e8a8-4bec-af2f-ee8db6155b59"))
        breadRef.child("Bread").child("product105").setValue(ProductTest(105,"Батон красная цена", 35,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        //Выпечка
        breadRef.child("Bakery").child("product111").setValue(ProductTest(111,"Сдоба", 65,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fsdoba.jpg?alt=media&token=92ca2c18-92f9-4695-a764-61f5360ba7e8"))
        breadRef.child("Bakery").child("product112").setValue(ProductTest(112,"Сочни", 40,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fsochni2.jpg?alt=media&token=d6c4a8a4-5454-433d-9492-d43fce00f9a1"))
        breadRef.child("Bakery").child("product113").setValue(ProductTest(113,"Баранки", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04%20(6).jpg?alt=media&token=acaa4be8-a623-48fb-b2b6-fce6f1185a0f"))
        //Крекеры, хлебцы
        breadRef.child("Crackers").child("product121").setValue(ProductTest(121,"Хлебцы Dr. Korner", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04%20(5).jpg?alt=media&token=e940079d-7e26-4f0e-ada2-28063986e450"))
        breadRef.child("Crackers").child("product122").setValue(ProductTest(122,"Хлебцы Зерница", 65,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04%20(4).jpg?alt=media&token=7d43535f-cdab-457b-a4b8-479527fa0a58"))
        breadRef.child("Crackers").child("product123").setValue(ProductTest(123,"Соломка с солью", 48,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04%20(3).jpg?alt=media&token=12101d29-ce58-48e3-86a9-09307307425e"))
        breadRef.child("Crackers").child("product124").setValue(ProductTest(124,"Крекер Яшкино", 45,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04%20(2).jpg?alt=media&token=fdfcb4e7-78e8-4583-9fa6-9b2884f3ca0e"))
        breadRef.child("Crackers").child("product125").setValue(ProductTest(125,"Крекер Тук", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04.jpg?alt=media&token=84b70cd4-1dc5-4c32-b46e-a04257e87a49"))

        //Овощи, фрукты, зелень
        //Овощи
        vegetablesRef.child("Vegetables").child("product201").setValue(ProductTest(201,"Картофель 1кг", 31,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fkartofel.jpg?alt=media&token=31d46aeb-5a2d-4f15-a06d-50f72882867c"))
        vegetablesRef.child("Vegetables").child("product202").setValue(ProductTest(202,"Морковь 1кг", 50,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fmorkov.jpg?alt=media&token=d8321ac4-ffbb-481d-91dd-d0fe48fde79e"))
        vegetablesRef.child("Vegetables").child("product203").setValue(ProductTest(203,"Лук репчатый 100г", 5,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fluk.jpg?alt=media&token=e6fc4644-469a-4a79-8a59-15fb6a160817"))
        vegetablesRef.child("Vegetables").child("product204").setValue(ProductTest(204,"Помидоры 1кг", 150,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fpomidori.jpg?alt=media&token=b00a87f6-b319-4bc1-9a78-ff0272725403"))
        vegetablesRef.child("Vegetables").child("product205").setValue(ProductTest(205,"Огурцы 1кг", 110,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fogyrci.jpg?alt=media&token=8e87e08e-e3c9-4eb8-9d6c-44a17348da66"))
        vegetablesRef.child("Vegetables").child("product206").setValue(ProductTest(206,"Свекла 500г", 40,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-22_16-19-05.jpg?alt=media&token=7641fef9-3954-4aeb-b19c-0b1752297cab"))
        vegetablesRef.child("Vegetables").child("product207").setValue(ProductTest(207,"Редис 100г", 12,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-22_16-19-06.jpg?alt=media&token=742be7c5-33f3-4e77-8cb6-3894f0219da4"))
        vegetablesRef.child("Vegetables").child("product208").setValue(ProductTest(208,"Капуста 1кг", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fkapusta.jpg?alt=media&token=8b9d4f7e-f2b8-4e91-a276-a309b2a400cc"))
        vegetablesRef.child("Vegetables").child("product209").setValue(ProductTest(209,"Чеснок 100г", 29,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-22_16-19-06%20(3).jpg?alt=media&token=f7287965-60d5-4f2a-8840-87af19ffc200"))
        //Фрукты
        vegetablesRef.child("Fruits").child("product211").setValue(ProductTest(211,"Яблоки Голден 400г", 60,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fyabloki_golden.jpg?alt=media&token=60dce40c-539c-4764-8663-bcfd4ae0f4a6"))
        vegetablesRef.child("Fruits").child("product212").setValue(ProductTest(212,"Яблоки красные 400г", 75,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fyabloki_krasn.jpg?alt=media&token=4cbdeb24-03c7-432f-988e-1236c6c32441"))
        vegetablesRef.child("Fruits").child("product213").setValue(ProductTest(213,"Апельсины 1кг", 110,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-24_00-54-02.jpg?alt=media&token=81cb472e-3420-4238-921a-7eeb7d2bf0c9"))
        vegetablesRef.child("Fruits").child("product214").setValue(ProductTest(214,"Лимоны 100г", 30,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Flimon.jpg?alt=media&token=a94671a8-e5b5-4479-9e74-b8e9f17cccb7"))
        vegetablesRef.child("Fruits").child("product215").setValue(ProductTest(215,"Мандарины 1кг", 160,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-24_00-54-03.jpg?alt=media&token=f930dc09-cd35-4df2-98f0-ef1c57c0862f"))
        vegetablesRef.child("Fruits").child("product216").setValue(ProductTest(216,"Виноград Киш-миш 400г", 60,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-23_17-12-58%20(2).jpg?alt=media&token=45dcbe3d-22e1-490f-92ae-ea14eee03407"))
        vegetablesRef.child("Fruits").child("product217").setValue(ProductTest(217,"Виноград красный 400г", 95,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-23_17-12-58.jpg?alt=media&token=03d64087-d37f-4767-a26d-3822a3adb0a9"))
        vegetablesRef.child("Fruits").child("product218").setValue(ProductTest(218,"Бананы 500г", 69,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fbanani.jpg?alt=media&token=60e1e537-8b80-411d-afc7-801fdf648967"))
        //Зелень
        vegetablesRef.child("Greens").child("product221").setValue(ProductTest(221,"Укроп", 50,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-24_00-49-55.jpg?alt=media&token=9856e476-003b-4d01-ab39-67a1f06586af"))
        vegetablesRef.child("Greens").child("product222").setValue(ProductTest(222,"Лук 100г", 70,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fluk_zelen.jpg?alt=media&token=9f4a42a2-ef79-4e8e-aac5-849a2057fa33"))
        vegetablesRef.child("Greens").child("product223").setValue(ProductTest(223,"Салат", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-24_00-49-55%20(2).jpg?alt=media&token=6e708607-ae0d-4be3-bcda-61e1b1ec69cd"))
        //Грибы
        vegetablesRef.child("Mushrooms").child("product231").setValue(ProductTest(231,"Шапминьоны 250г", 100,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-24_00-38-44.jpg?alt=media&token=cd64542e-d915-43b0-bc1b-63a43316f99c"))

        //Крупы, макароны
        //Крупы
        groceryRef.child("Groats").child("product301").setValue(ProductTest(301,"Рис пропаренный шлифованный 900г", 73,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2Fris1.jpg?alt=media&token=53552182-595e-4c33-b34f-37da089658b2"))
        groceryRef.child("Groats").child("product302").setValue(ProductTest(302,"Рис круглозернистый 900г", 65,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2FrisCruglozern.jpg?alt=media&token=518c9800-2543-450f-a543-76872b563acf"))
        groceryRef.child("Groats").child("product303").setValue(ProductTest(303,"Рис длиннозернистый 900г", 96,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2FrisDlinnozer.jpg?alt=media&token=d682a788-5ccd-402d-899c-4f1ed7ed0990"))
        groceryRef.child("Groats").child("product304").setValue(ProductTest(304,"Греча Мистраль 900г", 73,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2Fgrecha_mistral.jpg?alt=media&token=b6760a15-9e16-48f4-87e7-240caa014d1b"))
        groceryRef.child("Groats").child("product305").setValue(ProductTest(305,"Греча Селяночка 900г", 99,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2Fgrecha_selyanochka.jpg?alt=media&token=5e5c2da9-ff8f-407d-ac44-cd61744abe58"))
        groceryRef.child("Groats").child("product306").setValue(ProductTest(306,"Горох Селяночка 900г", 73,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2Fgoroh_slyanochka.jpg?alt=media&token=97f66c2c-57f9-4da6-96cb-b48b8137a6a1"))
        groceryRef.child("Groats").child("product307").setValue(ProductTest(307,"Манная крупа 900г", 73,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2Fmanka.jpg?alt=media&token=795b849d-9ebd-4fc0-a7a0-638a69793e44"))


        //Макароны
        groceryRef.child("Pasta").child("product311").setValue(ProductTest(311,"Макароны Барилла 900г", 129,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2Fmakaroni_barilla.jpg?alt=media&token=8258e367-0bc5-4170-80b5-0560c488518d"))
        groceryRef.child("Pasta").child("product312").setValue(ProductTest(312,"Макароны Макфа 900г", 65,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2Fmakaroni_makfa.jpg?alt=media&token=4dc36c5a-981c-44d1-9b5f-2f3f48b56618"))
        groceryRef.child("Pasta").child("product313").setValue(ProductTest(313,"Макароны Шебекенские 900г", 56,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2Fmakaroni_shebekenskie.jpg?alt=media&token=1c099814-fdfb-4126-849c-7b94a2222dc3"))
        groceryRef.child("Pasta").child("product314").setValue(ProductTest(314,"Спагетти Траттория 900г", 150,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2Fmakaroni_trattoria.jpg?alt=media&token=d682c874-9d9b-4444-b96b-aebac9ccfca3"))
        groceryRef.child("Pasta").child("product315").setValue(ProductTest(315,"Спагетти Макфа 900г", 70,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2Fspageti_makfa.jpg?alt=media&token=b68d4203-1473-4d6c-837e-a19cfde5bb5b"))

        //Для завтрака
        groceryRef.child("Breakfast").child("product321").setValue(ProductTest(321,"Селяночка Геркулес 500г", 70,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2Fgercules_selyanochka.jpg?alt=media&token=f8805cca-9979-4548-a337-e551b8bdf023"))
        groceryRef.child("Breakfast").child("product322").setValue(ProductTest(322,"Селяночка Овсяные хлопья 350г", 60,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2Fovsyanka_selyanochka.jpg?alt=media&token=d42575be-a82f-4103-92f2-2cc637b06b68"))

        //Быстрое приготовление
        groceryRef.child("Fast").child("product331").setValue(ProductTest(331,"Ролтон Вермишель", 30,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2Frolton_paket.jpg?alt=media&token=516d1208-d252-4d01-a5ce-b9caa0a09554"))
        groceryRef.child("Fast").child("product332").setValue(ProductTest(332,"Доширак пюре", 45,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2Fdoshirak_pure.jpg?alt=media&token=f21e8bf4-e528-4201-91ca-6b96193be644"))
        groceryRef.child("Fast").child("product333").setValue(ProductTest(333,"Доширак Вермишель", 35,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2Fdoshirak_paket.jpg?alt=media&token=092024f5-2056-4f49-b63d-ff8f810b0f6a"))
        groceryRef.child("Fast").child("product334").setValue(ProductTest(334,"Доширак", 58,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2Fdoshirak_lapsha.jpg?alt=media&token=2665709e-5f0b-4478-a824-331e98b9a163"))
        groceryRef.child("Fast").child("product335").setValue(ProductTest(335,"Харчо суп", 30,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fgrocery%2Fharcho.jpg?alt=media&token=cbd483f8-ee49-4215-8666-e1c8428d271e"))

        //Молочные продукты
        //Молоко,кефир
        milkRef.child("Milk").child("product401").setValue(ProductTest(401,"Молоко Вкусняев", 70,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmilk%2Fmoloko2.jpg?alt=media&token=be60473b-e1cb-4228-a433-ba2ff599aa35"))
        milkRef.child("Milk").child("product402").setValue(ProductTest(402,"Молоко Домик", 70,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmilk%2Fmoloko3.jpg?alt=media&token=4441977e-dbdd-475c-baf4-4ec868755232"))
        milkRef.child("Milk").child("product403").setValue(ProductTest(403,"Молоко Красная цена", 70,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmilk%2Fmoloko4.jpg?alt=media&token=b85c3b52-4d72-435f-8411-202b6da55ecb"))
        milkRef.child("Milk").child("product404").setValue(ProductTest(404,"Кефир Очень важная", 70,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmilk%2Fkefir1.jpg?alt=media&token=bed3ef39-9032-4041-b790-90a504b87246"))
        milkRef.child("Milk").child("product405").setValue(ProductTest(405,"Кефир Село зеленое", 70,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmilk%2Fkefir2.jpg?alt=media&token=7366e626-8b4f-4b78-b325-5194e9b36edb"))

        //Йогурты
        milkRef.child("Yoghurts").child("product411").setValue(ProductTest(411,"Йогурт Чудо", 65,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmilk%2Fyogurt4.jpg?alt=media&token=d4b9e357-2f4c-495a-bb41-fd7b6604fa7f"))
        milkRef.child("Yoghurts").child("product412").setValue(ProductTest(412,"Йогурт Активия", 65,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmilk%2Fyogurt3.jpg?alt=media&token=5973b54e-7255-42c8-ac57-1238417c9c89"))
        milkRef.child("Yoghurts").child("product413").setValue(ProductTest(413,"Йогурт Нежный", 65,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmilk%2Fyogurt2.jpg?alt=media&token=a6c95f43-ce7e-45e3-9d27-fb02f98076ff"))
        milkRef.child("Yoghurts").child("product414").setValue(ProductTest(414,"Йогурт Даниссимо", 65,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmilk%2Fyogurt.jpg?alt=media&token=19235462-5725-42cb-9740-36951dbd6d6d"))

        //Масло, сметана, майонез, сгущенка, сыр
        milkRef.child("Butters").child("product421").setValue(ProductTest(421,"Масло Крестъянское", 130,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmilk%2Fmaslo.jpg?alt=media&token=f0d03f5e-7936-418b-8c05-86d88c72269e"))
        milkRef.child("Butters").child("product422").setValue(ProductTest(422,"Сметана Простоквашино", 110,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmilk%2Fsmetana.jpg?alt=media&token=81ea0148-e10f-4389-9d4f-0337e9451cf5"))
        milkRef.child("Butters").child("product423").setValue(ProductTest(423,"Сыр Село зеленое", 130,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmilk%2Fsir3.jpg?alt=media&token=b93ce76b-44f8-4817-aa89-ec47d34617fb"))
        milkRef.child("Butters").child("product424").setValue(ProductTest(424,"Сыр Хохланд", 130,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmilk%2Fsir2.jpg?alt=media&token=c942d763-1c2c-4493-a638-547e5ba18ffd"))
        milkRef.child("Butters").child("product425").setValue(ProductTest(425,"Сыр Президент", 130,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmilk%2Fsir.jpg?alt=media&token=c7bc7119-d60a-42e6-9447-456c1df2f45f"))
        milkRef.child("Butters").child("product426").setValue(ProductTest(426,"Майонез Провансаль", 130,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Foil%2Fmayonez.jpg?alt=media&token=80d01caa-66cb-4e8d-8769-61d269179615&_gl=1*1275sqn*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTA3MzcuMC4wLjA."))

        //Яйца
        milkRef.child("Eggs").child("product431").setValue(ProductTest(431,"Яйца", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmilk%2Feggs.jpg?alt=media&token=dbdd0cef-c142-4e61-9b5a-774665a722f2"))

        //Сладости
        //Шоколад
        sweetsRef.child("Chocolate").child("product501").setValue(ProductTest(501,"Шоколад Альпен Голд", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Falpengold.jpg?alt=media&token=d7b22ba9-1747-4da4-811a-4504f3a9bc0e&_gl=1*hlq9eh*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTIyNTEuMC4wLjA."))
        sweetsRef.child("Chocolate").child("product502").setValue(ProductTest(502,"Шоколад Россия Щедрая Душа", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Frossia.jpg?alt=media&token=42c840c8-454c-4796-8955-4c1c14855578&_gl=1*u6mvrv*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTIzNzQuMC4wLjA."))
        sweetsRef.child("Chocolate").child("product503").setValue(ProductTest(503,"Шоколад Воздушный", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Fvozdyshni.jpg?alt=media&token=ec9978a4-b27e-45ee-bd4c-7e379d182ccc&_gl=1*1jh8iuz*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTIzNTkuMC4wLjA."))

        //Конфеты, батончики
        sweetsRef.child("Chocolate_bar").child("product511").setValue(ProductTest(511,"Баунти", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Fbounty.jpg?alt=media&token=0cd70ce7-84da-4920-8784-590f271999a2&_gl=1*b7lhij*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTI1MDcuMC4wLjA."))
        sweetsRef.child("Chocolate_bar").child("product512").setValue(ProductTest(512,"Чудо", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Fchydo.jpg?alt=media&token=62cac6f0-6463-4990-83c4-7a2b6a474367&_gl=1*1kxxrd9*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTI1MTAuMC4wLjA."))
        sweetsRef.child("Chocolate_bar").child("product513").setValue(ProductTest(513,"Милки вэй", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Fmilky.jpg?alt=media&token=01cdfb98-cb9f-448c-b1a9-b07332c80d48&_gl=1*gv1lqp*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTI1MjQuMC4wLjA."))
        sweetsRef.child("Chocolate_bar").child("product514").setValue(ProductTest(514,"Пикник", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Fpicnik.jpg?alt=media&token=3c04a974-3dee-498e-8710-e4bece8205bd&_gl=1*101gga6*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTI1MzYuMC4wLjA."))
        sweetsRef.child("Chocolate_bar").child("product515").setValue(ProductTest(515,"Сникерс", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Fsnickers.jpg?alt=media&token=d5e52f20-279c-4074-b3d8-42e4dde81de7&_gl=1*1f34y3c*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTI1NDAuMC4wLjA."))
        sweetsRef.child("Chocolate_bar").child("product516").setValue(ProductTest(516,"Киндер", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Fkinder.jpg?alt=media&token=521353f1-dc7f-4622-bcef-8d6c9edef990&_gl=1*1t39b8l*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTI1MTQuMC4wLjA."))

        //Печенья
        sweetsRef.child("Cookies").child("product521").setValue(ProductTest(521,"Чоко пай", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Fchokopie.jpg?alt=media&token=9366a797-66b1-4dbf-9f92-155736a686b2&_gl=1*yj2id4*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTI3MDYuMC4wLjA."))
        sweetsRef.child("Cookies").child("product522").setValue(ProductTest(522,"Орео", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Foreo.jpg?alt=media&token=947491af-6c50-4455-97de-962514273fe9&_gl=1*1mesi43*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTI3MTYuMC4wLjA."))
        sweetsRef.child("Cookies").child("product523").setValue(ProductTest(523,"Юбилейное", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Fpechenya.jpg?alt=media&token=58c54100-00cd-46b2-a997-9bc1036b6288&_gl=1*1guxk8m*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTI3MTkuMC4wLjA."))
        sweetsRef.child("Cookies").child("product524").setValue(ProductTest(524,"Вафли Голандские Яшкино", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Fvafli1.jpg?alt=media&token=8fb98cee-3416-41c0-baf4-7918da06c388&_gl=1*11f4117*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTI3MjMuMC4wLjA."))
        sweetsRef.child("Cookies").child("product525").setValue(ProductTest(525,"Вафли Яшкино", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Fvafli2.jpg?alt=media&token=40f5f9e3-9dc9-45d0-b13b-ce3b2f96bb3e&_gl=1*1nqfioo*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTI3MjcuMC4wLjA."))
        sweetsRef.child("Cookies").child("product526").setValue(ProductTest(526,"Вафли Шарлиз", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Fvafli3.jpg?alt=media&token=b9dc4bd7-360e-43ed-a078-c8eebabc9162&_gl=1*dwc7lq*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTI3MzAuMC4wLjA."))

        //Жвачки
        sweetsRef.child("Gum").child("product531").setValue(ProductTest(531,"Орбит", 45,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Forbit.jpg?alt=media&token=7f08beaa-156b-45fa-bc94-4787a53114f3&_gl=1*1gbr1ut*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTMxMTYuMC4wLjA."))
        sweetsRef.child("Gum").child("product532").setValue(ProductTest(532,"Ментос", 58,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Fmentos.jpg?alt=media&token=6eb35a3d-e802-4d46-96d4-f5b3f83b0ed9&_gl=1*zspe83*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTMxMTEuMC4wLjA."))
        sweetsRef.child("Gum").child("product533").setValue(ProductTest(533,"M & M`s", 45,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Fmandm.jpg?alt=media&token=40c0a4b6-61fa-442e-bd31-0037e19ae86b&_gl=1*rudvmt*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTMxMDguMC4wLjA."))

        //Джем
        sweetsRef.child("Jam").child("product541").setValue(ProductTest(541,"Паста Нутелла", 245,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsweets%2Fnutella.jpg?alt=media&token=74589a01-4c13-4b47-ba8c-49587359ae6c&_gl=1*o8ennb*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTMxMjEuMC4wLjA."))

        //Рыба
        //Рыба
        fishRef.child("Fish").child("product601").setValue(ProductTest(601,"Сельдь Замороженная", 245,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffish%2Fseld.jpg?alt=media&token=d78f0c5c-ce75-427a-8dfd-a6af6044af1d&_gl=1*azfq6q*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTQ0MTAuMC4wLjA."))
        fishRef.child("Fish").child("product602").setValue(ProductTest(602,"Треска", 245,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffish%2Ftreska.jpg?alt=media&token=4cdcab5e-ca81-42dd-a6ff-6b71fcce90d5&_gl=1*s97hs5*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTQ0MTguMC4wLjA."))
        fishRef.child("Fish").child("product603").setValue(ProductTest(603,"Форель", 245,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffish%2Fforel.jpg?alt=media&token=2db6bafb-f0a7-4a4a-8e98-d0934c624880&_gl=1*14vyk2f*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTQ0MDMuMC4wLjA."))

        //Консервы из рыбы
        fishRef.child("canned").child("product611").setValue(ProductTest(611,"Горбуша", 245,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffish%2Fgorbusha.jpg?alt=media&token=f1f841e8-6773-4563-b3d7-f59d61052079&_gl=1*1huxv0g*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTQ1NjMuMC4wLjA."))
        fishRef.child("canned").child("product612").setValue(ProductTest(612,"Сайра", 245,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffish%2Fsaira.jpg?alt=media&token=9b8d242b-174b-48e4-b299-3712bac9054f&_gl=1*zmacbb*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTQ1NjkuMC4wLjA."))
        fishRef.child("canned").child("product613").setValue(ProductTest(613,"Тунец", 245,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffish%2Ftunec.jpg?alt=media&token=36070407-a0dc-40a8-8e26-50fd5388c96a&_gl=1*160nv5c*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTQ1ODAuMC4wLjA."))
        fishRef.child("canned").child("product614").setValue(ProductTest(614,"Шпроты", 245,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffish%2Fshproti.jpg?alt=media&token=fcfe8f8a-6e41-407c-8c41-7e7b9361996e&_gl=1*oks13r*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTQ1NzUuMC4wLjA."))
        fishRef.child("canned").child("product615").setValue(ProductTest(615,"Сельдь", 245,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffish%2Fseld2.jpg?alt=media&token=c1238821-242a-42d1-954e-53dd00923715&_gl=1*s0x5gx*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTQ1NzIuMC4wLjA."))

        //
        fishRef.child("fish_snacks").child("product621").setValue(ProductTest(621,"Крабовые палочки", 245,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffish%2Fkrab.jpg?alt=media&token=5d0c9a50-c543-4d31-90f2-422dd07a3cf9&_gl=1*1tkubbm*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYwOTcyMS4yNS4xLjE2ODU2MTQ1NjYuMC4wLjA."))


        //Мясо
        //Мясо
        meatRef.child("meat").child("product701").setValue(ProductTest(701,"Курица", 265,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmeat%2Fmyaso_kurica.jpg?alt=media&token=34592808-3032-4b58-8758-fdf125dccad9&_gl=1*180s1um*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4wLjE2ODU2MTg5MDcuMC4wLjA."))
        meatRef.child("meat").child("product702").setValue(ProductTest(702,"Говядина", 395,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmeat%2Fmyaso_govadina.jpg?alt=media&token=8432bc12-8b85-4a04-a652-a848938218e8&_gl=1*16n1bon*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTg5MTAuMC4wLjA."))

        //Колбасы
        meatRef.child("sausages").child("product711").setValue(ProductTest(711,"Колбаса Папа Может", 365,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmeat%2Fkolbasa_papamojet.jpg?alt=media&token=1cfb47d3-883c-4684-9bb1-ce2c4f5d03d3&_gl=1*1xpmgyb*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTkxMTQuMC4wLjA."))
        meatRef.child("sausages").child("product712").setValue(ProductTest(712,"Колбаса полусухая", 265,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmeat%2Fkolbasa_salchichon.jpg?alt=media&token=4563300f-2be3-4331-8ba1-1c66b8fe39ae&_gl=1*15yie6u*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTkxMTcuMC4wLjA."))
        meatRef.child("sausages").child("product713").setValue(ProductTest(713,"Сосиски Папа Может", 285,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmeat%2Fsosiski_papamojet.jpg?alt=media&token=0a6f83db-7f52-43f6-aa89-d934efa9080f&_gl=1*2zhcy7*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTkxMjAuMC4wLjA."))
        meatRef.child("sausages").child("product714").setValue(ProductTest(714,"сосиски Ядрена Копоть", 265,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmeat%2Fsosiski_yadrena.jpg?alt=media&token=77fd06f4-36a2-4e1c-960c-2e97a294c4e2&_gl=1*6yklyz*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTkxMjIuMC4wLjA."))

        //Фарш
        meatRef.child("forcemeat").child("product721").setValue(ProductTest(721,"Фарш Индейка", 365,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmeat%2Ffarsh_kurinni.jpg?alt=media&token=42e36ece-bd48-49f3-aa78-9f17cf778207&_gl=1*1g9sw0r*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTkyNDcuMC4wLjA."))


        //Напитки
        //Вода
        drinkRef.child("water").child("product801").setValue(ProductTest(801,"Святой Источник без газа", 65,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fdrinks%2Fvoda1.jpg?alt=media&token=6bcf36fa-a1e3-4da7-b2c7-673140a5ccde&_gl=1*iex7kz*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTk0MzUuMC4wLjA."))
        drinkRef.child("water").child("product802").setValue(ProductTest(802,"Святой Источник с газом", 65,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fdrinks%2Fvoda2.jpg?alt=media&token=ded75033-546b-4bd9-9193-db304785b7ad&_gl=1*cv22li*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTk0MzguMC4wLjA."))

        //Соки
        drinkRef.child("juices").child("product811").setValue(ProductTest(811,"Сок Любимый манго", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fdrinks%2Fsok1.jpg?alt=media&token=758e8c5b-6a26-4ebf-a4de-dfa79b2526b3&_gl=1*1mh21qt*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTk1MzIuMC4wLjA."))
        drinkRef.child("juices").child("product812").setValue(ProductTest(812,"Сок Любимый яблоко", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fdrinks%2Fsok3.jpg?alt=media&token=d6047ddd-39bd-4324-9861-6f46a46893a7&_gl=1*10e6hpy*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTk1MzguMC4wLjA."))
        drinkRef.child("juices").child("product813").setValue(ProductTest(813,"Сок Сады Придонья", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fdrinks%2Fsok2.jpg?alt=media&token=e1edfd62-0b31-441f-ab22-a6977e6808d0&_gl=1*1ud10s3*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTk1MzUuMC4wLjA."))

        //Лимонады,квас и тд
        drinkRef.child("lemonade").child("product821").setValue(ProductTest(821,"Кола Добрый", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fdrinks%2Fcola1.jpg?alt=media&token=ed0ccbf6-9ade-4abf-bcc1-d58622738d32&_gl=1*1ozcybk*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTk2NjQuMC4wLjA."))
        drinkRef.child("lemonade").child("product822").setValue(ProductTest(822,"Кола Зеро", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fdrinks%2Fcola2.jpg?alt=media&token=583366ef-c362-45a4-bf09-c44f2dfe47b3&_gl=1*1jizmlw*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTk2NjYuMC4wLjA."))
        drinkRef.child("lemonade").child("product823").setValue(ProductTest(823,"Фреш Бар 1.5л", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fdrinks%2Ffresh.jpg?alt=media&token=59cc33e3-a2c0-44ee-880b-2a235c8b1dae&_gl=1*mwqacj*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTk2NzAuMC4wLjA."))
        drinkRef.child("lemonade").child("product824").setValue(ProductTest(824,"Фреш бар 0.5л", 50,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fdrinks%2Ffresh2.jpg?alt=media&token=a0ad975b-4bd1-47a8-a678-4735aff7d7c1&_gl=1*k5wg31*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTk2NzMuMC4wLjA."))
        drinkRef.child("lemonade").child("product825").setValue(ProductTest(825,"Чай Липтон", 70,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fdrinks%2Flipton.jpg?alt=media&token=8b87ae88-463f-40cd-85ea-dc4e71e9f575&_gl=1*1fthiwc*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTk2ODEuMC4wLjA."))
        drinkRef.child("lemonade").child("product826").setValue(ProductTest(826,"Палпи", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fdrinks%2Fpuplpi.jpg?alt=media&token=c169188b-03a2-4710-9f88-0a4deafeda06&_gl=1*157lwn2*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTk2ODQuMC4wLjA."))
        drinkRef.child("lemonade").child("product827").setValue(ProductTest(827,"Фрутмотив", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fdrinks%2Ffrutmotiv.jpg?alt=media&token=ede046bf-dc40-49dd-9a65-e4456379dfc0&_gl=1*ymxze9*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTk2NzUuMC4wLjA."))
        drinkRef.child("lemonade").child("product828").setValue(ProductTest(828,"Квас Очаковский", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fdrinks%2Fkvas.jpg?alt=media&token=8154c15e-fbaa-405b-b74c-02a636370adc&_gl=1*4o2r1w*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTk2NzguMC4wLjA."))
        drinkRef.child("lemonade").child("product829").setValue(ProductTest(829,"Энергетик Драйв", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fdrinks%2Fdrive.jpg?alt=media&token=018e0026-9335-4e21-85d6-8eb03720ded1&_gl=1*1grbbgf*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYxODkwNy4yNi4xLjE2ODU2MTk2NjguMC4wLjA."))

        //Консервы
        //Консервированные овощи, бобы
        cannedRef.child("canned_vegetables").child("product901").setValue(ProductTest(901,"Фасоль с овощами", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcanned%2Ffasol.jpg?alt=media&token=657d298d-09d3-4bd6-85d2-ec8a968ddebf&_gl=1*cb4vuw*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4wLjE2ODU2MjI2OTkuMC4wLjA."))
        cannedRef.child("canned_vegetables").child("product902").setValue(ProductTest(902,"Фасоль", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcanned%2Ffasol2.jpg?alt=media&token=14e27a95-300f-4379-8ecc-9093d7d3843b&_gl=1*7h9tgr*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjI3MDIuMC4wLjA."))
        cannedRef.child("canned_vegetables").child("product903").setValue(ProductTest(903,"Горошек", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcanned%2Fgoroh.jpg?alt=media&token=3d755df0-666c-493b-8908-72935f02384d&_gl=1*igo29e*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjI3MDcuMC4wLjA."))
        cannedRef.child("canned_vegetables").child("product904").setValue(ProductTest(904,"Кукуруза", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcanned%2Fkukuruza.jpg?alt=media&token=79f2c994-6a74-46bc-806a-f437a2a07bcb&_gl=1*mkr43q*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjI3MDkuMC4wLjA."))
        cannedRef.child("canned_vegetables").child("product905").setValue(ProductTest(905,"Оливки", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcanned%2Folivki.jpg?alt=media&token=bd72d710-acf8-4591-89f9-fa821b12376c&_gl=1*znbnp8*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjI3MTQuMC4wLjA."))
        cannedRef.child("canned_vegetables").child("product906").setValue(ProductTest(906,"Огурцы", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcanned%2Fogurci.jpg?alt=media&token=bb008d8e-fea1-4f34-9e36-01235ae7bfe6&_gl=1*1dy4fq8*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjI3MTIuMC4wLjA."))

        //Мясные и рыбные консервы
        cannedRef.child("canned_meat").child("product911").setValue(ProductTest(911,"Тушенка Говядина", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcanned%2Ftushenka2.jpg?alt=media&token=579f7ed9-ee6c-4ec6-9678-7aa551a14a5d&_gl=1*1wyi61h*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjI4NjAuMC4wLjA."))
        cannedRef.child("canned_meat").child("product912").setValue(ProductTest(912,"Тушенка Свинина", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcanned%2Ftushenka1.jpg?alt=media&token=3b6d2739-2e85-4aaf-af9c-6c08bb5a3cf1&_gl=1*1jtqh9e*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjI4NTcuMC4wLjA."))
        cannedRef.child("canned_meat").child("product913").setValue(ProductTest(913,"Тунец", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcanned%2Ftunec.jpg?alt=media&token=b1f09a7f-006f-4227-a635-5c062d79a8b7&_gl=1*19u7gfb*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjI4NTQuMC4wLjA."))
        cannedRef.child("canned_meat").child("product914").setValue(ProductTest(914,"Сайра", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcanned%2Fsaira.jpg?alt=media&token=86206bee-f478-46d7-8999-244e7628945f&_gl=1*6oj2s8*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjI4NDYuMC4wLjA."))
        cannedRef.child("canned_meat").child("product915").setValue(ProductTest(915,"Горбуша", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcanned%2Fgorbusha.jpg?alt=media&token=43e905ed-d05a-4ca2-9fcf-b839d8936cf5&_gl=1*hojprk*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjI4NDIuMC4wLjA."))

        //Фруктовые консверы
        cannedRef.child("canned_fruit").child("product921").setValue(ProductTest(921,"Ананасовые кольца", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcanned%2Fananasi.jpg?alt=media&token=bdbc56f4-aabe-4aa8-8a47-75a2a42e3e9f&_gl=1*xq9ovr*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjI4MzkuMC4wLjA."))


        //Замороженные продукты
        //Пельмени
        frozenRef.child("dumplings").child("product1001").setValue(ProductTest(1001,"Пельмени Цезарь", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffrozen%2Fcezar.jpg?alt=media&token=70f381d4-2d51-4ac1-939e-283c99fbb65b&_gl=1*1bfqugw*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjMyNjYuMC4wLjA."))
        frozenRef.child("dumplings").child("product1002").setValue(ProductTest(1002,"Бульмени", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffrozen%2Fbulmeni.jpg?alt=media&token=e2865f14-c620-4824-a923-ac6b30b14d1c&_gl=1*fz3crx*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjMyNzEuMC4wLjA."))

        //Полуфабрикаты
        frozenRef.child("semimanufactures").child("product1011").setValue(ProductTest(1001,"Блинчики с ветчиной и сыром", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffrozen%2Fblinchiki.jpg?alt=media&token=423f2e88-f423-40d2-b3a4-7a88edcb78d3&_gl=1*1gx9ua3*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjMzNTcuMC4wLjA."))
        frozenRef.child("semimanufactures").child("product1012").setValue(ProductTest(1012,"Блинчики с курицей", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffrozen%2Fblinchiki2.jpg?alt=media&token=96209b09-d868-4394-a269-f1adee76c67f&_gl=1*13osvb0*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjMzNjAuMC4wLjA."))
        frozenRef.child("semimanufactures").child("product1013").setValue(ProductTest(1013,"Чебупели", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffrozen%2Fchebupelli.jpg?alt=media&token=e054a15b-8568-4928-a114-8127d57d0bc7&_gl=1*1asibv8*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjMzNjQuMC4wLjA."))
        frozenRef.child("semimanufactures").child("product1014").setValue(ProductTest(1014,"Котлеты Семейные", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffrozen%2Fkotleti.jpg?alt=media&token=6edd66f9-03bc-4efe-acdd-2372f129e58b&_gl=1*1g0e4ww*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjMzNjYuMC4wLjA."))
        frozenRef.child("semimanufactures").child("product1015").setValue(ProductTest(1015,"Наггетсы куринные", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffrozen%2Fnagetsi.jpg?alt=media&token=1affad39-961c-43e2-9ce0-f2d22db5c808&_gl=1*1ns5bol*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjMzNjkuMC4wLjA."))

        //Мороженое
        frozenRef.child("icecreams").child("product1021").setValue(ProductTest(1021,"Рожок Гост", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffrozen%2Frojok.jpg?alt=media&token=9a50baa4-6441-4e56-80a5-7a4e17818afb&_gl=1*mckz5l*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA1NzA2Mi40MS4xLjE2ODYwNTcwNzUuMC4wLjA."))
        frozenRef.child("icecreams").child("product1022").setValue(ProductTest(1022,"Пломбир Гост", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffrozen%2Fplombir.jpg?alt=media&token=061910ca-361c-4c59-8d41-1572d25a2157&_gl=1*11szxkp*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA1NzA2Mi40MS4xLjE2ODYwNTcwNjkuMC4wLjA."))
        frozenRef.child("icecreams").child("product1023").setValue(ProductTest(1023,"Золотой Стандарт", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffrozen%2Fplombir2.jpg?alt=media&token=7519efd9-5626-4d94-8bcf-8c969d8ecb65&_gl=1*s0fzz9*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA1NzA2Mi40MS4xLjE2ODYwNTcwNzMuMC4wLjA."))

        //Масло, специи, соусы
        //Приправы, специи
        oilRef.child("seasonings").child("product1101").setValue(ProductTest(1101,"Соль", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Foil%2Fsol.jpg?alt=media&token=22c65170-72d9-4cc2-9c92-ac3ad2e0cc69&_gl=1*dio2wp*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjM2MjAuMC4wLjA."))
        oilRef.child("seasonings").child("product1102").setValue(ProductTest(1102,"Сахар", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Foil%2Fsahar.jpg?alt=media&token=4cf19af0-6357-45f4-9cee-7fd018524c15&_gl=1*bsoldj*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjM2MjMuMC4wLjA."))
        oilRef.child("seasonings").child("product1103").setValue(ProductTest(1103,"Перец черный", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Foil%2Fperec.jpg?alt=media&token=26bdba32-5e13-4d34-ab02-ab7a3aa066b8&_gl=1*1bhjfp*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjM2MjYuMC4wLjA."))
        oilRef.child("seasonings").child("product1104").setValue(ProductTest(1104,"Перец", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Foil%2Fpriprava2.jpg?alt=media&token=4d7709d4-1b1b-4707-bf59-2f941a449804&_gl=1*1e1swog*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjM2NDQuMC4wLjA."))
        oilRef.child("seasonings").child("product1105").setValue(ProductTest(1105,"Приправа для курицы", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Foil%2Fpriprava1.jpg?alt=media&token=411daa19-8649-4510-982e-613fc3fc3480&_gl=1*16rsesi*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjM2NDEuMC4wLjA."))
        oilRef.child("seasonings").child("product1106").setValue(ProductTest(1106,"Куриный бульон", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Foil%2Fbulon.jpg?alt=media&token=281272ab-3bac-4878-9032-c66d5feb6479&_gl=1*1p21mg5*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjM2MzguMC4wLjA."))
        oilRef.child("seasonings").child("product1107").setValue(ProductTest(1107,"Мука Макфа", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Foil%2Fmuka.jpg?alt=media&token=f09aed19-d112-452d-910a-07496c3d4c4b&_gl=1*t2lsio*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjM2MjkuMC4wLjA."))


        //Масло
        oilRef.child("oil").child("product1111").setValue(ProductTest(1111,"Подсолнечное Золотая Семечка", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Foil%2Fmaslo1.jpg?alt=media&token=da886e55-5eba-4694-8637-7281b2f0e75a&_gl=1*q4j9pu*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjM4NTguMC4wLjA."))
        oilRef.child("oil").child("product1112").setValue(ProductTest(1112,"Оливковое Глобал", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Foil%2Fmaslo2.jpg?alt=media&token=71e398be-261c-4a3c-8248-4f66c9bb6096&_gl=1*b49hmh*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjM4NTYuMC4wLjA."))


        //Кетчуп, майонез
        oilRef.child("ketchup").child("product1121").setValue(ProductTest(1121,"Кетчуп Махеев", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Foil%2Fketchup.jpg?alt=media&token=d47bf62d-e1cf-469f-ba4c-632064c94152&_gl=1*38d0bj*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjM4NjEuMC4wLjA."))
        oilRef.child("ketchup").child("product1122").setValue(ProductTest(1122,"Майонез Провансаль", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Foil%2Fmayonez.jpg?alt=media&token=80d01caa-66cb-4e8d-8769-61d269179615&_gl=1*aifyod*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NTYyMjY5OS4yNy4xLjE2ODU2MjM4NjQuMC4wLjA."))

            //ДОДЕЛАТЬ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //Снэки
        //Чипсы
        snacksRef.child("chips").child("product1201").setValue(ProductTest(1201,"Читос Сырный", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsnacks%2Fcheetos.jpg?alt=media&token=af630774-3d6d-4c74-ba52-b219f320de75&_gl=1*1efn4qo*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzQ2NzguMC4wLjA."))
        snacksRef.child("chips").child("product1202").setValue(ProductTest(1202,"Лэйс с крабом", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsnacks%2Flays1.jpg?alt=media&token=1103f79a-73d6-4c36-815a-e3a606f93fb4&_gl=1*1rcl0gz*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzQ2NzIuMC4wLjA."))
        snacksRef.child("chips").child("product1203").setValue(ProductTest(1203,"Лэйс с сыром", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsnacks%2Flays2.jpg?alt=media&token=c7ee7955-0523-421c-a144-0aee013d47c5&_gl=1*1r2s4uy*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4wLjE2ODYwNzQ2NjkuMC4wLjA."))

        //Семечки, орехи
        snacksRef.child("nuts").child("product1211").setValue(ProductTest(1211,"Микс Бар Кешью", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsnacks%2Fkeshu.jpg?alt=media&token=79131dc4-50c9-41e0-8ecf-87eb5a6384ad&_gl=1*fqrjcl*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzUxNjMuMC4wLjA."))
        snacksRef.child("nuts").child("product1212").setValue(ProductTest(1212,"Микс Бар Арахис", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsnacks%2Farahis.jpg?alt=media&token=abc06668-b90c-4bce-ad84-15a32ac828d6&_gl=1*9ko0fv*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzUxNjAuMC4wLjA."))
        snacksRef.child("nuts").child("product1213").setValue(ProductTest(1213,"Семечки От Мартина", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsnacks%2Fsemechki2.jpg?alt=media&token=65c3576c-e3cf-4696-a4e9-9c6eaed52d2e&_gl=1*5bvt1o*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzUxNTcuMC4wLjA."))
        snacksRef.child("nuts").child("product1214").setValue(ProductTest(1214,"Бабкины Семечки", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsnacks%2Fsemechki1.jpg?alt=media&token=55c5c0e6-6f20-4437-948a-29dbd3f794c4&_gl=1*zakvd5*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzUxNTQuMC4wLjA."))


        //Сухарики
        snacksRef.child("crackers").child("product1221").setValue(ProductTest(1221,"Сухарики Хрустим", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsnacks%2Fhrusteam.jpg?alt=media&token=df917805-33c1-4615-830b-9bde8114a744&_gl=1*fw5t7p*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzU2MzQuMC4wLjA."))
        snacksRef.child("crackers").child("product1221").setValue(ProductTest(1221,"Сухарики Фишка", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fsnacks%2Ffishka.jpg?alt=media&token=76a1dd81-ceff-49d7-82a0-cb859ab786be&_gl=1*6duv93*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzU2MzEuMC4wLjA."))




        //Для дома
        //Для гигиены
        cleaningRef.child("hygiene").child("product1301").setValue(ProductTest(1301,"Мыло Абсолют Жидкое", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffor_home%2Fmilo.jpg?alt=media&token=947effc9-7237-440a-824a-a1765ee28151&_gl=1*y2mapv*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzY1OTUuMC4wLjA."))
        cleaningRef.child("hygiene").child("product1302").setValue(ProductTest(1302,"Зубная паста Колгейт", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffor_home%2Fpasta.jpg?alt=media&token=335e1bcc-cfe9-4798-8102-eea409b43c10&_gl=1*1blnfez*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzY2MDAuMC4wLjA."))
        cleaningRef.child("hygiene").child("product1303").setValue(ProductTest(1303,"Зубная щетка Колгейт", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffor_home%2Fshetka.jpg?alt=media&token=974f6b89-fd07-485e-95db-0e5e27a04df6&_gl=1*12vosv7*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzY2MDQuMC4wLjA."))

        //Для мытья посуды
        cleaningRef.child("washing").child("product1311").setValue(ProductTest(1311,"Губки для мытья посуды", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffor_home%2Fgubki.jpg?alt=media&token=c395dc55-df1f-459b-9e7f-6dc5b83d4892&_gl=1*430qlr*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzcyODIuMC4wLjA."))
        cleaningRef.child("washing").child("product1312").setValue(ProductTest(1312,"Фейри для мытья посуды", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffor_home%2Ffairy.jpg?alt=media&token=4246f7c9-f521-4225-a792-f07ca30b948b&_gl=1*gbe4dv*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzcyODQuMC4wLjA."))
        cleaningRef.child("washing").child("product1313").setValue(ProductTest(1313,"Очиститель Комет", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffor_home%2Fcomet.jpg?alt=media&token=3a9b8a21-a066-49bb-b2fc-e2a78a59633e&_gl=1*o2ulkm*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzcyODcuMC4wLjA."))
        cleaningRef.child("washing").child("product1314").setValue(ProductTest(1314,"Стиральный порошок Лоск", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffor_home%2Flosk.jpg?alt=media&token=f260da0a-6226-4048-be06-d0eb3f92ca42&_gl=1*17sh536*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzcyOTUuMC4wLjA."))


        //Для туалета
        cleaningRef.child("toilet").child("product1321").setValue(ProductTest(1321,"Ароматизатор Аир Вик", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffor_home%2Faroma.jpg?alt=media&token=175aacc3-a306-4e0e-a3dc-3d2f076d1203&_gl=1*iwurjc*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzc2NzkuMC4wLjA."))
        cleaningRef.child("toilet").child("product1321").setValue(ProductTest(1321,"Туалетная бумага Зева", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffor_home%2Ftualetnaya1.jpg?alt=media&token=1bfc7121-c61d-4356-877c-b2971a0e3e06&_gl=1*4avmdh*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzc2NzIuMC4wLjA."))
        cleaningRef.child("toilet").child("product1321").setValue(ProductTest(1321,"Салфетки универсальные", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Ffor_home%2Fpolotenca.jpg?alt=media&token=3d697a75-5b9e-4b17-ac84-0f6bc86e3020&_gl=1*dw6pur*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA3NDY2OS40My4xLjE2ODYwNzc2NzUuMC4wLjA."))



        //Кофе и чай
        //Кофе
        coffeeRef.child("coffee").child("product1401").setValue(ProductTest(1401,"Кофе Нескафе", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcoffee%2Fnescafe.jpg?alt=media&token=04e9cffc-b8a6-4720-ad87-e9609149d448&_gl=1*csgxvg*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODMxMTUuMC4wLjA."))
        coffeeRef.child("coffee").child("product1402").setValue(ProductTest(1402,"Кофе Якобс", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcoffee%2Fjacobs.jpg?alt=media&token=0016f500-6e20-449a-bd04-8f03c4523719&_gl=1*2p2ljo*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODMxMTEuMC4wLjA."))
        coffeeRef.child("coffee").child("product1403").setValue(ProductTest(1403,"Кофе Маккофе 3 в 1", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcoffee%2Fmaccofe.jpg?alt=media&token=b45cd62d-70af-4d83-974d-a25fe5bf133e&_gl=1*icgsqh*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODMxMTguMC4wLjA."))

        //Чай
        coffeeRef.child("tea").child("product1411").setValue(ProductTest(1411,"Чай Тесс с шиповником", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcoffee%2Ftess.jpg?alt=media&token=2e1d4391-6609-4e9f-a0c7-47f4f8d16987&_gl=1*1250f5l*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODMzNTguMC4wLjA."))
        coffeeRef.child("tea").child("product1412").setValue(ProductTest(1412,"Чай Кертис зеленый", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcoffee%2Fcurtis.jpg?alt=media&token=b2801214-2563-41d1-96c5-6c1c97093ecb&_gl=1*1f9fnm6*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODMzNjEuMC4wLjA."))
        coffeeRef.child("tea").child("product1413").setValue(ProductTest(1413,"Чай Кертис черный", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcoffee%2Fcurtis2.jpg?alt=media&token=477df163-27b3-41d5-87bf-f17df175eef1&_gl=1*15rif30*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODMzNjQuMC4wLjA."))
        coffeeRef.child("tea").child("product1414").setValue(ProductTest(1414,"Чай Гринфилд черный", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcoffee%2Fgreendfield2.jpg?alt=media&token=5eb646bf-78a8-4a36-9481-3fe933ba7f16&_gl=1*1xiak0p*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODMzNjcuMC4wLjA."))
        coffeeRef.child("tea").child("product1415").setValue(ProductTest(1415,"Чай Гринфилд зеленый", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcoffee%2Fgreenfield.jpg?alt=media&token=d88add7d-e6af-4b99-ab6a-d7381b14cc9d&_gl=1*1sqnsbx*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODMzNjkuMC4wLjA."))


        //Какао
        coffeeRef.child("cocoa").child("product1421").setValue(ProductTest(1421,"Какаое Хрутка", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fcoffee%2Fkakao.jpg?alt=media&token=56908310-6ab0-4f5b-892a-c965ff398455&_gl=1*ymlvtv*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODM1MzIuMC4wLjA."))


        //Детские продукты
        //Подгузники
        babyRef.child("diapers").child("product1501").setValue(ProductTest(1501,"Памперсы Памперс", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbaby%2Fpampersi1.jpg?alt=media&token=7ecd18a6-973f-4a1e-8351-27ddede1c6ef&_gl=1*1xtjvrz*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODM2NTEuMC4wLjA."))
        babyRef.child("diapers").child("product1502").setValue(ProductTest(1502,"Памперсы Хоней Кид", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbaby%2Fpanpersi2.jpg?alt=media&token=66c11de9-d0b1-496b-b52f-2685ff987dfd&_gl=1*1ncllot*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODM2NTQuMC4wLjA."))

        //Еда
        babyRef.child("nutrition").child("product1511").setValue(ProductTest(1511,"Йогурт Агуша", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbaby%2Fyogurt.jpg?alt=media&token=40907f13-51db-457e-92d2-229eef72d967&_gl=1*fhxcqq*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODM5MTIuMC4wLjA."))
        babyRef.child("nutrition").child("product1512").setValue(ProductTest(1512,"Кашка Агуша", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbaby%2Fsok.jpg?alt=media&token=eae4a4cb-92dc-43b8-b610-71afcf7c7d98&_gl=1*a02ng6*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODM5MTAuMC4wLjA."))
        babyRef.child("nutrition").child("product1513").setValue(ProductTest(1513,"Пюре Тема", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbaby%2Fpure3.jpg?alt=media&token=044586ae-d82a-4576-ae22-8f026950c106&_gl=1*1hn1bm8*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODM5MDcuMC4wLjA."))
        babyRef.child("nutrition").child("product1514").setValue(ProductTest(1514,"Пюре Фруто Няня", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbaby%2Fpure2.jpg?alt=media&token=d1b2e4ba-8ad4-4a6e-8e5b-9a3f2627fe6e&_gl=1*19pmnov*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODM5MDUuMC4wLjA."))
        babyRef.child("nutrition").child("product1515").setValue(ProductTest(1515,"Пюре Агуша", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbaby%2Fpure.jpg?alt=media&token=0326455d-6e0d-4172-ab5e-aded5e52afed&_gl=1*znkk8r*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODM3NjEuMC4wLjA."))


        //Аптечка
        //Нужное
        medicineRef.child("medicine").child("product1601").setValue(ProductTest(1601,"Маски", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmedicine%2Fphoto_2023-05-23_20-06-59%20(2).jpg?alt=media&token=e4eab9e1-f174-4c65-8647-6986de8180b6&_gl=1*miqeob*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODQwMzYuMC4wLjA."))
        medicineRef.child("medicine").child("product1602").setValue(ProductTest(1602,"Хлоргексидин", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmedicine%2Fphoto_2023-05-23_20-06-59.jpg?alt=media&token=c1fad01e-27d8-477e-8991-3cc9e4e6bd1b&_gl=1*gz1l8u*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODQwMzkuMC4wLjA."))
        medicineRef.child("medicine").child("product1603").setValue(ProductTest(1603,"Контекс", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmedicine%2Fphoto_2023-05-23_20-07-00.jpg?alt=media&token=999e7a60-8995-45de-8203-37bdb3c8fca4&_gl=1*qz7ccn*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODQwNDEuMC4wLjA."))
        medicineRef.child("medicine").child("product1604").setValue(ProductTest(1604,"Пластыри", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmedicine%2Fphoto_2023-05-23_20-07-01.jpg?alt=media&token=98ab3a6e-1da0-40c1-bc5d-d3911f3c749d&_gl=1*vvziyb*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODQwNDMuMC4wLjA."))
        medicineRef.child("medicine").child("product1605").setValue(ProductTest(1605,"Тест для беременности", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmedicine%2Fphoto_2023-05-23_20-07-02.jpg?alt=media&token=5faaf424-f88d-4836-879c-4754eb24673b&_gl=1*jl00q7*_ga*NDMyMDIyNDUzLjE2ODM4NDA3NTQ.*_ga_CW55HF8NVT*MTY4NjA4MzAzNi40NC4xLjE2ODYwODQwNDUuMC4wLjA."))



    }
}


