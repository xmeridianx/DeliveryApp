package com.example.meatdeliveryapp.Data

import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class productBase {
    /*private val product1 = ProductTest("Хлеб", 35,)
    private val product2 = ProductTest("Булочка>", 55)
    private val product3 = ProductTest("Батон", 71,)
    private val product4 = ProductTest("Мясо курицы", 235,)
    private val product5 = ProductTest("Мясо говядина", 345,)
    private val product6 = ProductTest("Шашлык", 500,)
 /////////////
    val database = FirebaseDatabase.getInstance()
    val productsRef = database.getReference("товары")
 ////////////////////
    val product1Ref = productsRef.child("товар1")
    val product2Ref = productsRef.child("товар2")
    val product3Ref = productsRef.child("товар3")
    val product4Ref = productsRef.child("товар4")
    val product5Ref = productsRef.child("товар5")
    val product6Ref = productsRef.child("товар6")

    fun test(){
        product1Ref.setValue(product1)
        product2Ref.setValue(product2)
        product3Ref.setValue(product3)
        product4Ref.setValue(product4)
        product5Ref.setValue(product5)
        product6Ref.setValue(product6)
        }
     */

    /*
    val database = Firebase.database
    val categoriesRef = database.getReference("Categories")

    // Создаем категорию "Хлеб" и ее товары
    val breadRef = categoriesRef.child("Хлеб")
    val vegetablesRef = categoriesRef.child("Овощи и фрукты")
    val groceryRef = categoriesRef.child("Крупы и макароны")
    val milkRef = categoriesRef.child("Молочные продукты")
    val sweetsRef = categoriesRef.child("Сладости")
    val fishRef = categoriesRef.child("Рыбные продукты")
    val meatRef = categoriesRef.child("Мясные продукты")
    val drinkRef = categoriesRef.child("Напитки")
    val cannedRef = categoriesRef.child("Консервированные продуткы")
    val frozenRef = categoriesRef.child("Замороженные продукты")
     */
    val categoryNames = listOf("Хлеб", "Овощи и фрукты", "Крупы и макароны", "Молочные продукты", "Сладости",
        "Рыбные продукты", "Мясные продукты", "Напитки", "Консервированные продуткы", "Замороженные продукты",
        "Масло и специи", "Соусы" , "Снэки" , "Кофе и чай", "Детские продукты" , "Гигиена" , "Для дома" , "Аптечка" )
    val categoriesRef = Firebase.database.getReference("Categories")

    val categoryRefs = categoryNames.map { categoriesRef.child(it) }

    fun test() {
        /*
        breadRef.child("products").child("product1").setValue(ProductTest("Bread Product 1", 10))
        breadRef.child("products").child("product2").setValue(ProductTest("Bread Product 2", 20))
        meatRef.child("products").child("product3").setValue(ProductTest("Meat Product 1", 30))
        meatRef.child("products").child("product4").setValue(ProductTest("Meat Product 2", 40))

         */
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


        breadRef.child("products").child("product101").setValue(ProductTest(101,"Хлеб белый", 55,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fhleb1.jpg?alt=media&token=869da003-b851-4156-9dcb-d26b3b4309ab"))
        breadRef.child("products").child("product102").setValue(ProductTest(102,"Батон", 48,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-03%20(2).jpg?alt=media&token=4a63c4fa-8f0d-47f6-aaef-690a29cebc75"))
        breadRef.child("products").child("product103").setValue(ProductTest(103,"Хлеб серый", 35,
        "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-03%20(3).jpg?alt=media&token=7d729940-22e1-41ba-b829-51fc27d05ff8"))
        breadRef.child("products").child("product104").setValue(ProductTest(104,"Хлеб Бородинский", 70,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fborodin.jpg?alt=media&token=aab7e9d2-e8a8-4bec-af2f-ee8db6155b59"))
        breadRef.child("products").child("product105").setValue(ProductTest(105,"Батон красная цена", 35,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))


        breadRef.child("products").child("product111").setValue(ProductTest(111,"Сдоба", 65,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fsdoba.jpg?alt=media&token=92ca2c18-92f9-4695-a764-61f5360ba7e8"))
        breadRef.child("products").child("product112").setValue(ProductTest(112,"Сочни", 40,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fsochni2.jpg?alt=media&token=d6c4a8a4-5454-433d-9492-d43fce00f9a1"))
        breadRef.child("products").child("product113").setValue(ProductTest(113,"Баранки", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04%20(6).jpg?alt=media&token=acaa4be8-a623-48fb-b2b6-fce6f1185a0f"))


        breadRef.child("products").child("product121").setValue(ProductTest(121,"Хлебцы Dr. Korner", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04%20(5).jpg?alt=media&token=e940079d-7e26-4f0e-ada2-28063986e450"))
        breadRef.child("products").child("product122").setValue(ProductTest(122,"Хлебцы Зерница", 65,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04%20(4).jpg?alt=media&token=7d43535f-cdab-457b-a4b8-479527fa0a58"))
        breadRef.child("products").child("product123").setValue(ProductTest(123,"Соломка с солью", 48,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04%20(3).jpg?alt=media&token=12101d29-ce58-48e3-86a9-09307307425e"))
        breadRef.child("products").child("product124").setValue(ProductTest(124,"Крекер Яшкино", 45,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04%20(2).jpg?alt=media&token=fdfcb4e7-78e8-4583-9fa6-9b2884f3ca0e"))
        breadRef.child("products").child("product125").setValue(ProductTest(125,"Крекер Тук", 90,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fphoto_2023-05-23_17-09-04.jpg?alt=media&token=84b70cd4-1dc5-4c32-b46e-a04257e87a49"))



        vegetablesRef.child("products").child("product201").setValue(ProductTest(201,"Картофель 1кг", 31,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product202").setValue(ProductTest(202,"Морковь 1кг", 50,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product203").setValue(ProductTest(203,"Лук репчатый 100г", 5,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product204").setValue(ProductTest(204,"Помидоры 1кг", 150,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product205").setValue(ProductTest(205,"Огурцы 1кг", 110,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product206").setValue(ProductTest(206,"Свекла 500г", 40,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product207").setValue(ProductTest(207,"Редис 100г", 12,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product208").setValue(ProductTest(208,"Капуста 1кг", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product209").setValue(ProductTest(209,"Чеснок 100г", 29,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))


        vegetablesRef.child("products").child("product210").setValue(ProductTest(210,"Бананы 100г", 15,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fbanani.jpg?alt=media&token=60e1e537-8b80-411d-afc7-801fdf648967"))
        vegetablesRef.child("products").child("product211").setValue(ProductTest(211,"Яблоки Голден 100г", 15,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fyabloki_golden.jpg?alt=media&token=60dce40c-539c-4764-8663-bcfd4ae0f4a6"))
        vegetablesRef.child("products").child("product212").setValue(ProductTest(212,"Яблоки красные 100г", 18,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fyabloki_krasn.jpg?alt=media&token=4cbdeb24-03c7-432f-988e-1236c6c32441"))
        vegetablesRef.child("products").child("product213").setValue(ProductTest(213,"Апельсины 1кг", 110,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-24_00-54-02.jpg?alt=media&token=81cb472e-3420-4238-921a-7eeb7d2bf0c9"))
        vegetablesRef.child("products").child("product214").setValue(ProductTest(214,"Лимоны 100г", 30,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Flimon.jpg?alt=media&token=a94671a8-e5b5-4479-9e74-b8e9f17cccb7"))
        vegetablesRef.child("products").child("product215").setValue(ProductTest(215,"Мандарины 1кг", 160,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-24_00-54-03.jpg?alt=media&token=f930dc09-cd35-4df2-98f0-ef1c57c0862f"))
        vegetablesRef.child("products").child("product216").setValue(ProductTest(216,"Виноград Киш-миш 100г", 15,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-23_17-12-58%20(2).jpg?alt=media&token=45dcbe3d-22e1-490f-92ae-ea14eee03407"))
        vegetablesRef.child("products").child("product217").setValue(ProductTest(217,"Виноград красный 100г", 25,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-23_17-12-58.jpg?alt=media&token=03d64087-d37f-4767-a26d-3822a3adb0a9"))


        vegetablesRef.child("products").child("product220").setValue(ProductTest(220,"Укроп", 50,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-24_00-49-55.jpg?alt=media&token=9856e476-003b-4d01-ab39-67a1f06586af"))
        vegetablesRef.child("products").child("product221").setValue(ProductTest(221,"Лук 100г", 70,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fluk_zelen.jpg?alt=media&token=9f4a42a2-ef79-4e8e-aac5-849a2057fa33"))
        vegetablesRef.child("products").child("product222").setValue(ProductTest(222,"Салат", 80,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-24_00-49-55%20(2).jpg?alt=media&token=6e708607-ae0d-4be3-bcda-61e1b1ec69cd"))

        vegetablesRef.child("products").child("product230").setValue(ProductTest(230,"Шапминьоны 250г", 100,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-24_00-38-44.jpg?alt=media&token=cd64542e-d915-43b0-bc1b-63a43316f99c  "))
        vegetablesRef.child("products").child("product301").setValue(ProductTest(301,"Шапминьоны 250г", 100,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fvegetables%2Fphoto_2023-05-24_00-38-44.jpg?alt=media&token=cd64542e-d915-43b0-bc1b-63a43316f99c"))
/*
        meatRef.child("products").child("product201").setValue(ProductTest("мясо 1", 30))
        meatRef.child("products").child("product202").setValue(ProductTest("Mясо 2", 40))

        vegetablesRef.child("products").child("product301").setValue(ProductTest("ррррр", 40))

        groceryRef.child("products").child("product401").setValue(ProductTest("ррррр", 40))

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


