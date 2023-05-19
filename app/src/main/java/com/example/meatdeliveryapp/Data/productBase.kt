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


        breadRef.child("products").child("product101").setValue(ProductTest(101,"Хлеб 1", 55,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        breadRef.child("products").child("product102").setValue(ProductTest(102,"хлеб 2", 20,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fborodin.jpg?alt=media&token=aab7e9d2-e8a8-4bec-af2f-ee8db6155b59"))
        breadRef.child("products").child("product103").setValue(ProductTest(103,"хлеб 3", 33,
        "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbulgarskiy.jpg?alt=media&token=45e491c3-3c65-4476-bbdd-9c2357345895"))

        vegetablesRef.child("products").child("product201").setValue(ProductTest(201,"Картофель", 31,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product202").setValue(ProductTest(202,"Морковь", 32,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product203").setValue(ProductTest(203,"Лук репчатый", 33,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product204").setValue(ProductTest(204,"Помидоры", 34,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product205").setValue(ProductTest(205,"Огурцы", 35,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product206").setValue(ProductTest(206,"Свекла", 36,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product207").setValue(ProductTest(207,"Редис", 37,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product208").setValue(ProductTest(208,"Капуста", 38,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product209").setValue(ProductTest(209,"Чеснок", 38,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))


        vegetablesRef.child("products").child("product210").setValue(ProductTest(210,"Бананы", 40,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product211").setValue(ProductTest(211,"Яблоки Голден", 40,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product212").setValue(ProductTest(212,"Яблоки красные", 40,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product213").setValue(ProductTest(213,"Апельсины", 40,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product214").setValue(ProductTest(214,"Лимоны", 40,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product215").setValue(ProductTest(215,"Мандарины", 40,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))


        vegetablesRef.child("products").child("product220").setValue(ProductTest(220,"Укроп", 38,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product221").setValue(ProductTest(221,"Пертушка", 38,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product222").setValue(ProductTest(222,"Салат", 38,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))

        vegetablesRef.child("products").child("product230").setValue(ProductTest(230,"Шапминьоны", 38,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
        vegetablesRef.child("products").child("product301").setValue(ProductTest(301,"Шапминьоны", 38,
            "https://firebasestorage.googleapis.com/v0/b/delivery-bf3b3.appspot.com/o/images%2Fbread%2Fbaton.jpg?alt=media&token=9aaa311b-554d-475f-9144-34a0b9e80315"))
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


