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


        breadRef.child("products").child("product101").setValue(ProductTest("Хлеб 1", 10))
        breadRef.child("products").child("product101").setValue(ProductTest("хлеб 2", 20))

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
    }
}


