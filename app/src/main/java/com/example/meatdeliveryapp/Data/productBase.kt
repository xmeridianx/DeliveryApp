package com.example.meatdeliveryapp.Data

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class productBase {

    val categoryNames = listOf("Bread_products", "Vegetables_fruits", "Grocery", "Milk_eggs", "Sweets",
        "Fish", "Meat", "Drinks", "Canned", "Frozen_food",
        "Oil_spices", "Sauce" , "Snacks" , "Coffee_tea", "Baby" , "Hygiene" , "Cleaning" , "Medicine" )
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
        val sauceRef = categoryRefs[11]
        val snacksRef = categoryRefs[12]
        val coffeeRef = categoryRefs[13]
        val babyRef = categoryRefs[14]
        val hygieneRef = categoryRefs[15]
        val cleaningRef = categoryRefs[16]
        val medicineRef = categoryRefs[17]

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

        //Eggs
        milkRef.child("Eggs").child("product431").setValue(ProductTest(431,"Яйца", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fmilk%2Feggs.jpg?alt=media&token=dbdd0cef-c142-4e61-9b5a-774665a722f2"))
/*
        meatRef.child("products").child("product201").setValue(ProductTest("мясо 1", 30))
        meatRef.child("products").child("product202").setValue(ProductTest("Mясо 2", 40))


        milkRef.child("products").child("product501").setValue(ProductTest("ррррр", 40))
        sweetsRef.child("products").child("product601").setValue(ProductTest("ррррр", 40))
        fishRef.child("products").child("product701").setValue(ProductTest("ррррр", 40))
        drinkRef.child("products").child("product801").setValue(ProductTest("ррррр", 40))
        cannedRef.child("products").child("product901").setValue(ProductTest("ррррр", 40))
        frozenRef.child("products").child("product1001").setValue(ProductTest("ррррр", 40))
        oilRef.child("products").child("product1201").setValue(ProductTest("ррррр", 40))
        sauceRef.child("products").child("product1301").setValue(ProductTest("ррррр", 40))
        snacksRef.child("products").child("product1401").setValue(ProductTest("ррррр", 40))
        coffeeRef.child("products").child("product1501").setValue(ProductTest("ррррр", 40))
        hygieneRef.child("products").child("product1601").setValue(ProductTest("ррррр", 40))
        cleaningRef.child("products").child("product1701").setValue(ProductTest("ррррр", 40))
        medicineRef.child("products").child("product1801").setValue(ProductTest("ррррр", 40))

 */
    }
}


